package cn.swallowserver.interaction;

import cn.swallowserver.session.Session;

import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;

/**
 * @author Chen Haoming
 */
public interface Interaction {

    Session getSession ();
}
