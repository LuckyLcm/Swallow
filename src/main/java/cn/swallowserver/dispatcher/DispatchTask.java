package cn.swallowserver.dispatcher;

import cn.swallowserver.RequestHandler;
import cn.swallowserver.filter.RequestFilterChain;
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
    public void run() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public void setHandler(RequestHandler handler) {
        this.handler = handler;
    }

    public void setDispatcher(Dispatcher dispatcher) {
        this.dispatcher = dispatcher;
    }

    public void setFilterChain(RequestFilterChain filterChain) {
        this.filterChain = filterChain;
    }
}
