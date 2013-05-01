package cn.swallowserver;

import cn.swallowserver.interaction.Request;
import cn.swallowserver.interaction.Response;

/**
 * @author Chen Haoming
 */
public interface RequestHandler {

    void handle(Request request, Response response);
}
