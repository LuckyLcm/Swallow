package cn.swallowserver.dispatcher;

import cn.swallowserver.filter.RequestFilterChain;
import cn.swallowserver.handler.RequestHandler;
import cn.swallowserver.interaction.Request;

/**
 * @author ICMLucky
 */
public class DispatchTask implements Runnable {

    private Request request;

    private RequestHandler handler;

    private Dispatcher dispatcher;

    private RequestFilterChain filterChain;

    @Override
    public void run () {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    void setRequest (Request request) {
        this.request = request;
    }

    void setHandler (RequestHandler handler) {
        this.handler = handler;
    }

    void setDispatcher (Dispatcher dispatcher) {
        this.dispatcher = dispatcher;
    }

    void setFilterChain (RequestFilterChain filterChain) {
        this.filterChain = filterChain;
    }
}
