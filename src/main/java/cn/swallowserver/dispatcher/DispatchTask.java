package cn.swallowserver.dispatcher;

import cn.swallowserver.filter.RequestFilterChain;
import cn.swallowserver.handler.RequestHandler;
import cn.swallowserver.interaction.Request;
import cn.swallowserver.interaction.Response;
import cn.swallowserver.interaction.ResponseFactory;
import cn.swallowserver.nio.NIOResponseImpl;

/**
 * @author ICMLucky
 */
public class DispatchTask implements Dispatcher {

    private Request request;

    private RequestHandler requestHandler;

    private RequestFilterChain requestFilterChain;

    private ResponseFactory responseFactory;

    DispatchTask () {

    }

    @Override
    public void run () {
        Request request1 = requestFilterChain.filter (request);
        Response response = responseFactory.create (request1);
        requestHandler.handle (request1, response);
    }

    public void setRequest (Request request) {
        this.request = request;
    }

    public void setRequestHandler (RequestHandler requestHandler) {
        this.requestHandler = requestHandler;
    }

    public void setRequestFilterChain (RequestFilterChain requestFilterChain) {
        this.requestFilterChain = requestFilterChain;
    }

    public void setResponseFactory (ResponseFactory responseFactory) {
        this.responseFactory = responseFactory;
    }
}
