package cn.swallowserver.session;

import java.nio.channels.SelectionKey;

/**
 * @author Chen Haoming
 */
public class NIOSocketRequest extends NIOSocketInteraction implements Request{

    public NIOSocketRequest (SelectionKey selectionKey, Session session) {
        super(selectionKey, session);
    }

}
