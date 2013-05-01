package cn.swallowserver.session;

import cn.swallowserver.AttributeHolder;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.Map;


public interface Session extends AttributeHolder {

    SessionContext getSessionContext();

    boolean isValid ();

    void invalid () throws IOException;

}
