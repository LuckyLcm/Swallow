package cn.swallowserver.dispatcher;

import cn.swallowserver.filter.RequestFilterChain;
import cn.swallowserver.handler.RequestHandler;
import cn.swallowserver.interaction.Request;
import cn.swallowserver.interaction.Response;


/**
 * @author Chen Haoming
 */
public interface Dispatcher extends Runnable {

    void setRequestFilterChain (RequestFilterChain requestFilterChain);

    void setRequestHandler (RequestHandler requestHandler);

}
