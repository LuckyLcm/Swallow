package cn.swallowserver.dispatcher;

import cn.swallowserver.filter.RequestFilterChain;
import cn.swallowserver.handler.RequestHandler;
import cn.swallowserver.interaction.Request;

/**
 * @author ICMLucky
 */
public class DispatchTaskFactory {

    private RequestFilterChain requestFilterChain;

    private RequestHandler requestHandler;

    public DispatchTask create (Request request) {
        DispatchTask task = new DispatchTask ();
        task.setRequestFilterChain (requestFilterChain);
        task.setRequestHandler (requestHandler);
        task.setRequest (request);
        return task;
    }

    public void setRequestFilterChain (RequestFilterChain requestFilterChain) {
        this.requestFilterChain = requestFilterChain;
    }

    public void setRequestHandler (RequestHandler requestHandler) {
        this.requestHandler = requestHandler;
    }
}
