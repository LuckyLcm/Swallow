package cn.swallowserver;

import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;

/**
 * @author Chen Haoming
 */
public abstract class Interaction {

    protected SelectionKey selectionKey;
    protected SocketChannel socketChannel;

    public Interaction(SelectionKey selectionKey) {
        socketChannel = (SocketChannel)selectionKey.channel();
        this.selectionKey = selectionKey;
    }

    public SelectionKey getSelectionKey() {
        return selectionKey;
    }

    public SocketChannel getSocketChannel() {
        return socketChannel;
    }
}
