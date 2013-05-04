package cn.swallowserver.session;

import cn.swallowserver.BaseAttributeHolder;

import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Chen Haoming
 */
public abstract class BaseSession extends BaseAttributeHolder implements Session {


    private InetSocketAddress remoteAddress;

    private InetSocketAddress localAddress;

    public BaseSession (InetSocketAddress remoteAddress, InetSocketAddress localAddress) {
        this.remoteAddress = remoteAddress;
        this.localAddress = localAddress;
    }


    public InetSocketAddress getRemoteAddress () {
        return remoteAddress;
    }

    public InetSocketAddress getLocalAddress () {
        return localAddress;
    }

}
