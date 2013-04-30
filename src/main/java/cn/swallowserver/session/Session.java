package cn.swallowserver.session;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.Map;

/**
 * @author Chen Haoming
 */
public interface Session {

    Object getAttribute (String name);

    void setAttribute (String name, Object attr);

    //Object getAttribute (String name, Object defaultAttr);

    //Map<String, Object> getAttributes();

    InetSocketAddress getRemoteAddress ();

    void setRemoteAddress (InetSocketAddress remoteAddress);

    InetSocketAddress getLocalAddress ();

    void setLocalAddress (InetSocketAddress localAddress);

    boolean isValid ();

    void invalid () throws IOException;

}
