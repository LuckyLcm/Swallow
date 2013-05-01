package cn.swallowserver;

import java.net.InetSocketAddress;

/**
 * @author Chen Haoming
 */
public interface ServerContext extends AttributeHolder {

    String getServerEncoding();

    InetSocketAddress getLocalAddress ();
}
