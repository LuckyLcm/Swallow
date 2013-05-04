package cn.swallowserver.nio;

import cn.swallowserver.SwallowServer;
import cn.swallowserver.session.Session;
import cn.swallowserver.session.SessionContext;
import cn.swallowserver.session.SessionContextImpl;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Map;

/**
 * @author Chen Haoming
 */
public class NIOSession implements Session {

    private boolean valid = true;

    private SocketChannel socketChannel;

    private SelectionKey readKey;

    private SelectionKey writeKey;

    private SessionContext sessionContext;

    private final Object validLock = new Object ();

    public NIOSession (SocketChannel socketChannel, SessionContext sessionContext) {
        this.socketChannel = socketChannel;
        this.sessionContext = sessionContext;
    }

    public SocketChannel getSocketChannel () {
        return socketChannel;
    }

    @Override
    public SessionContext getSessionContext () {
        return sessionContext;
    }

    @Override
    public boolean isValid () {
        synchronized (validLock) {
            return valid;
        }
    }

    @Override
    public void invalid () throws IOException {
        synchronized (validLock) {
            if (valid) {
                socketChannel.close ();
                this.valid = false;
                Server server = (Server) sessionContext.getSwallowServer ();
                Map<SocketChannel, NIOSession> map = server.getSocketChannelSessionMap ();
                map.remove (socketChannel);
            }
        }

    }

    public static NIOSession create (Selector selector, ServerSocketChannel serverSocketChannel) throws IOException {
        SocketChannel socketChannel = serverSocketChannel.accept ();
        socketChannel.configureBlocking (false);
        NIOSession session = new NIOSession (socketChannel, new SessionContextImpl ((InetSocketAddress) socketChannel.getRemoteAddress ()));
        session.readKey = socketChannel.register (selector, SelectionKey.OP_READ);
        session.writeKey = socketChannel.register (selector, SelectionKey.OP_WRITE);
        return session;
    }

}
