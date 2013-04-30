package cn.swallowserver.session.nio;

import cn.swallowserver.session.Interaction;
import cn.swallowserver.session.Session;

import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;

/**
 * @author Chen Haoming
 */
public abstract class NIOSocketInteraction implements Interaction {

    private SelectionKey selectionKey;
    private SocketChannel socketChannel;
    private Session session;

    public NIOSocketInteraction (SelectionKey selectionKey, Session session) {
        socketChannel = (SocketChannel)selectionKey.channel();
        this.selectionKey = selectionKey;
        this.session = session;
    }

    @Override
    public SelectionKey getSelectionKey () {
        return selectionKey;
    }

    @Override
    public SocketChannel getSocketChannel () {
        return socketChannel;
    }

    @Override
    public Session getSession () {
        return session;
    }
}
