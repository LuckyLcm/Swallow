package cn.swallowserver.session;

import cn.swallowserver.session.BaseInteraction;
import cn.swallowserver.session.Response;
import cn.swallowserver.session.Session;

import java.io.OutputStream;

/**
 * @author Chen Haoming
 */
public abstract class BaseResponse extends BaseInteraction implements Response {

    private OutputStream out;

    public BaseResponse(Session session) {
        super(session);
    }
}
