package cn.swallowserver.event;

import java.nio.channels.SelectionKey;

/**
 * @author Chen Haoming
 */
public class Event {

    public Event (SelectionKey selectionKey) {
        this.selectionKey = selectionKey;
    }

    private SelectionKey selectionKey;

    public SelectionKey getSelectionKey () {
        return selectionKey;
    }
}
