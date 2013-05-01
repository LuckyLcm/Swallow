package cn.swallowserver.interaction;

import cn.swallowserver.session.Session;

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


}
