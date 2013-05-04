package cn.swallowserver.session;

import cn.swallowserver.BaseAttributeHolder;
import cn.swallowserver.SwallowServer;

import java.net.InetSocketAddress;

/**
 * @author Chen Haoming
 */
public class SessionContextImpl extends BaseAttributeHolder implements SessionContext {

    private SwallowServer server;

    private InetSocketAddress remoteAddress;

    public SessionContextImpl (InetSocketAddress remoteAddress) {
        this.remoteAddress = remoteAddress;
    }

    @Override
    public InetSocketAddress getRemoteAddress () {
        return remoteAddress;
    }

    @Override
    public SwallowServer getSwallowServer () {
        return server;
    }
}
