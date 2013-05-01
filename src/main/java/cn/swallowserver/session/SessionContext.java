package cn.swallowserver.session;

import cn.swallowserver.AttributeHolder;

import java.net.InetSocketAddress;

/**
 * @author Chen Haoming
 */
public interface SessionContext extends AttributeHolder {

    InetSocketAddress getRemoteAddress ();
}
