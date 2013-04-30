package cn.swallowserver.session;

import cn.swallowserver.session.BaseInteraction;
import cn.swallowserver.session.Request;
import cn.swallowserver.session.Session;

import java.io.InputStream;
import java.nio.channels.SelectionKey;

/**
 * @author Chen Haoming
 */
public abstract class BaseRequest extends BaseInteraction implements Request {

    public BaseRequest(Session session) {
        super(session);
    }

}
