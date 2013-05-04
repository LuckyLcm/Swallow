package cn.swallowserver.session;

import cn.swallowserver.AttributeHolder;
import cn.swallowserver.SwallowServer;

import java.net.InetSocketAddress;

/**
 * @author Chen Haoming
 */
public interface SessionContext extends AttributeHolder {

    InetSocketAddress getRemoteAddress ();

    SwallowServer getSwallowServer();
}
