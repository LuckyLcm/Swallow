package cn.swallowserver.session.nio;

import cn.swallowserver.session.Response;
import cn.swallowserver.session.Session;

import java.io.OutputStream;
import java.nio.channels.SelectionKey;

/**
 * @author Chen Haoming
 */
public class NIOSocketResponse extends NIOSocketInteraction implements Response {

    private OutputStream out;

    public NIOSocketResponse (SelectionKey selectionKey, Session session) {
        super(selectionKey, session);
    }

    public OutputStream getOut() {
        return out;
    }
}
