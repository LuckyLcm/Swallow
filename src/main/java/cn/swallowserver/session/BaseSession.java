package cn.swallowserver.session;

import cn.swallowserver.BaseAttributeHolder;

import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Chen Haoming
 */
public abstract class BaseSession extends BaseAttributeHolder implements Session {

    private Map<String, Object> attributes = new HashMap<String, Object> ();

    private InetSocketAddress remoteAddress;

    private InetSocketAddress localAddress;

    public BaseSession (InetSocketAddress remoteAddress, InetSocketAddress localAddress) {
        this.remoteAddress = remoteAddress;
        this.localAddress = localAddress;
    }

    @Override
    public Object getAttribute (String name) {
        return attributes.get (name);
    }

    @Override
    public void setAttribute (String name, Object attr) {
        attributes.put (name, attr);
    }

    public InetSocketAddress getRemoteAddress () {
        return remoteAddress;
    }

    public InetSocketAddress getLocalAddress () {
        return localAddress;
    }

}
