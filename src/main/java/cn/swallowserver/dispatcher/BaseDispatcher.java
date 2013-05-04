package cn.swallowserver.dispatcher;

import cn.swallowserver.filter.RequestFilterChain;
import cn.swallowserver.handler.RequestHandler;
import cn.swallowserver.interaction.Request;
import cn.swallowserver.interaction.Response;

/**
 *  @author Chen Haoming
 */
public abstract class BaseDispatcher implements Dispatcher {

    private RequestFilterChain filterChain;

    private Request request;

    private RequestHandler handler;

//    public void run() {
//        Request result = filterChain.filter(request);
//        Response response = create(result);
//
//    }

    @Override
    public void dispatch(Request request) {
        throw new UnsupportedOperationException();  //To change body of created methods use File | Settings | File Templates.
    }

    @Override
    public void setRequestFilterChain(RequestFilterChain requestFilterChain) {
        this.filterChain = requestFilterChain;
    }

    @Override
    public void setRequestHandler(RequestHandler requestHandler) {
        this.handler = requestHandler;
    }

    public abstract Response create(Request request);


}
