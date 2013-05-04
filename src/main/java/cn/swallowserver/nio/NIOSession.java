package cn.swallowserver.nio;

import cn.swallowserver.session.BaseSession;
import cn.swallowserver.session.SessionContext;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * @author Chen Haoming
 */
public class NIOSession extends BaseSession {

    private boolean valid = true;

    private SocketChannel socketChannel;

    private SelectionKey readKey;

    private SelectionKey writeKey;

    public NIOSession (SocketChannel socketChannel, SelectionKey readKey, SelectionKey writeKey) throws IOException {
        super ((InetSocketAddress) socketChannel.getRemoteAddress (),
                (InetSocketAddress) socketChannel.getLocalAddress ());
        this.readKey = readKey;
        this.writeKey = writeKey;
    }

    public SocketChannel getSocketChannel () {
        return socketChannel;
    }

    @Override
    public SessionContext getSessionContext() {
        throw new UnsupportedOperationException();  //To change body of created methods use File | Settings | File Templates.
    }

    @Override
    public boolean isValid () {
        return valid;
    }

    @Override
    public void invalid () throws IOException {
        socketChannel.close ();
        this.valid = false;
    }

    public static NIOSession create (Selector selector, ServerSocketChannel serverSocketChannel) throws IOException {
        SocketChannel socketChannel = serverSocketChannel.accept ();
        socketChannel.configureBlocking (false);
        SelectionKey readKey = socketChannel.register(selector, SelectionKey.OP_READ);
        SelectionKey writeKey = socketChannel.register(selector, SelectionKey.OP_WRITE);
        return new NIOSession (socketChannel, readKey, writeKey);
    }

}
