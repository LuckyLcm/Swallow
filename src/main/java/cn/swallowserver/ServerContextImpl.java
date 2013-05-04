package cn.swallowserver;

import java.net.InetSocketAddress;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Chen Haoming
 */
public class ServerContextImpl extends BaseAttributeHolder implements ServerContext {

    private String encoding = "UTF-8";

    private InetSocketAddress localAddress;

    public ServerContextImpl() {
        super();
        this.setAttributes(new ConcurrentHashMap<String, Object>());
    }

    @Override
    public String getServerEncoding() {
        return encoding;
    }

    @Override
    public InetSocketAddress getLocalAddress() {
        return localAddress;
    }

    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }

    public void setLocalAddress(InetSocketAddress localAddress) {
        this.localAddress = localAddress;
    }
}
