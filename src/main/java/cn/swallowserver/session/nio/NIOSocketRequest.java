package cn.swallowserver.session.nio;

import cn.swallowserver.session.Request;
import cn.swallowserver.session.Session;

import java.nio.channels.SelectionKey;

/**
 * @author Chen Haoming
 */
public class NIOSocketRequest extends NIOSocketInteraction implements Request {

    public NIOSocketRequest (SelectionKey selectionKey, Session session) {
        super(selectionKey, session);
    }

}
