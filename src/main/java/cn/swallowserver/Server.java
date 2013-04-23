package cn.swallowserver;

import cn.swallowserver.event.Event;
import cn.swallowserver.event.Notifier;
import cn.swallowserver.session.NIOSocketRequest;
import cn.swallowserver.session.NIOSocketResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * @author Chen Haoming
 */
public class Server extends BaseThread {

    private static final transient Logger log = LoggerFactory.getLogger(Server.class);

    public static final int PORT = 19999;
    public static final String UTF_8 = "UTF-8";

    private Selector selector;

    private Reader reader;
    private Writer writer;

    private Notifier notifier = new Notifier ();

    private String encoding = UTF_8;

    public Server () throws IOException {

        selector = Selector.open ();
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open ();
        serverSocketChannel.configureBlocking (false);
        ServerSocket serverSocket = serverSocketChannel.socket ();
        serverSocket.bind (new InetSocketAddress (PORT));
        serverSocketChannel.register (selector, SelectionKey.OP_ACCEPT);

        reader = new Reader (this);
        writer = new Writer (this);
    }

    @Override
    protected void preRunning () {
        reader.start ();
        writer.start ();

    }

    @Override
    protected void running () throws InterruptedException {
        try {
            int len = selector.select(DEFAULT_TIMEOUT);
            if (len > 0) {
                Iterator<SelectionKey> iterator = selector.selectedKeys ().iterator ();
                log.debug("{} SelectionKeys has been selected.", len);
                while (iterator.hasNext ()) {
                    SelectionKey key = iterator.next ();
                    iterator.remove ();

                    if (key.isValid()) {
                        if (key.isAcceptable ()) {
                            ServerSocketChannel channel = (ServerSocketChannel) key.channel ();
                            SocketChannel socketChannel = channel.accept ();
                            socketChannel.configureBlocking (false);
                            SelectionKey selectionKey = socketChannel.register(selector, SelectionKey.OP_READ);
                            notifier.fireAccepted (new Event (key));
                        }

                        if (key.isReadable ()) {
                            //reader.read (new NIOSocketRequest (key));
                            notifier.fireRead (new Event (key));
                        }

                        if (key.isWritable ()) {
                            //writer.write(new NIOSocketResponse (key));
                            notifier.fireWritten (new Event (key));
                        }
                    } else {
                        log.warn ("Key[{}] is invalid.", key);
                        key.cancel ();
                    }


                }
            }

            // todo: deal with timeout;
        } catch (IOException e) {
            throw new RuntimeException (e);
        }
    }

    @Override
    protected void postRunning () {
        reader.stopThread ();
        writer.stopThread ();
    }

    public Notifier getNotifier () {
        return notifier;
    }

    public void setNotifier (Notifier notifier) {
        this.notifier = notifier;
    }

    public String getEncoding () {
        return encoding;
    }

    public void setEncoding (String encoding) {
        this.encoding = encoding;
    }
}
