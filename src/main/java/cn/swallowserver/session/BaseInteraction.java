package cn.swallowserver.session;

import cn.swallowserver.session.Interaction;
import cn.swallowserver.session.Session;

import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;

/**
 * @author Chen Haoming
 */
public abstract class BaseInteraction implements Interaction {

    private Session session;

    public BaseInteraction(Session session) {
        this.session = session;
    }

    @Override
    public Session getSession () {
        return session;
    }
}
