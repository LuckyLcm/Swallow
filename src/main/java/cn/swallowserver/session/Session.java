package cn.swallowserver.session;

import cn.swallowserver.AttributeHolder;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.Map;

/**
 * @author Chen Haoming
 */
public interface Session extends AttributeHolder {

    InetSocketAddress getRemoteAddress ();

    InetSocketAddress getLocalAddress ();

    boolean isValid ();

    void invalid () throws IOException;

}
