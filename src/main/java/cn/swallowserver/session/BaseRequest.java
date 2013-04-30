package cn.swallowserver.session;

import cn.swallowserver.session.BaseInteraction;
import cn.swallowserver.session.Request;
import cn.swallowserver.session.Session;

import java.io.InputStream;
import java.nio.channels.SelectionKey;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Chen Haoming
 */
public abstract class BaseRequest extends BaseInteraction implements Request {

    private Map<String, Object> attributes = new HashMap<String, Object>();

    public BaseRequest(Session session) {
        super(session);
    }

    @Override
    public Object getAttribute(String key) {
        return attributes.get(key);
    }

    @Override
    public void setAttribute(String key, Object value) {
        attributes.put(key,value);
    }
}
