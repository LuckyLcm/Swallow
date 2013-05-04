package cn.swallowserver.dispatcher;

import cn.swallowserver.filter.RequestFilterChain;
import cn.swallowserver.handler.RequestHandler;
import cn.swallowserver.interaction.Request;

/**
 * @author Chen Haoming
 */
public interface Dispatcher {

    void dispatch(Request request);

    void setRequestFilterChain(RequestFilterChain requestFilterChain);

    void setRequestHandler(RequestHandler requestHandler);
}
