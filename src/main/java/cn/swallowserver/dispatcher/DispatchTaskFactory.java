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

    private Dispatcher dispatcher;

    public DispatchTask create (Request request) {
        DispatchTask task = new DispatchTask ();
        task.setFilterChain (requestFilterChain);
        task.setHandler (requestHandler);
        task.setRequest (request);
        task.setDispatcher (dispatcher);
        return task;
    }

    public void setRequestFilterChain (RequestFilterChain requestFilterChain) {
        this.requestFilterChain = requestFilterChain;
    }

    public void setRequestHandler (RequestHandler requestHandler) {
        this.requestHandler = requestHandler;
    }

    public void setDispatcher (Dispatcher dispatcher) {
        this.dispatcher = dispatcher;
    }
}
