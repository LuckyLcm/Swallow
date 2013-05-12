package cn.swallowserver.nio;

import cn.swallowserver.session.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author Chen Haoming
 */
public class Writer extends IOThread {

    private static final transient Logger log = LoggerFactory.getLogger (Writer.class);

    private BlockingQueue<NIOPushMessage> pushMessagesQueue;

    Writer (Server server) {
        super (server);
        pushMessagesQueue = new LinkedBlockingQueue<NIOPushMessage> ();
    }

    @Override
    protected void preRunning () {

    }

    @Override
    protected void running () {
        NIOPushMessage pushMessage = pushMessagesQueue.poll ();
        NIOSession session = (NIOSession) pushMessage.getSession ();
        SocketChannel channel = session.getSocketChannel ();
        InputStream inputStream = pushMessage.getMessage ();
        List<ByteBuffer> bufferList = new LinkedList<ByteBuffer> ();

        try {
            int capacity = inputStream.available ();

            while (capacity > 0) {
                byte[] bytes = new byte[capacity];
                inputStream.read (bytes);
                ByteBuffer buffer = ByteBuffer.wrap (bytes);
                bufferList.add (buffer);
                capacity = inputStream.available ();
            }

            if ( ! bufferList.isEmpty ()) {
                channel.write ((ByteBuffer[]) bufferList.toArray ());
            }
        } catch (IOException e) {
            // todo: handle exception
        }

        log.debug ("Write message: {}");
        // todo: deal with msg;
    }

    @Override
    protected void postRunning () {

    }

    public void write (NIOPushMessage pushMessage) {
        pushMessagesQueue.offer (pushMessage);
    }
}
