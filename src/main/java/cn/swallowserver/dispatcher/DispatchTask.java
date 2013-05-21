package cn.swallowserver.dispatcher;

import cn.swallowserver.filter.BaseFilter;
import cn.swallowserver.filter.RequestFilterChain;
import cn.swallowserver.handler.RequestHandler;
import cn.swallowserver.interaction.Request;
import cn.swallowserver.interaction.Response;
import cn.swallowserver.interaction.ResponseFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author ICMLucky
 */
public class DispatchTask implements Dispatcher {

    private static final transient Logger log = LoggerFactory.getLogger (DispatchTask.class);

    private Request request;

    private RequestHandler requestHandler;

    private RequestFilterChain requestFilterChain;

    private ResponseFactory responseFactory;

    DispatchTask () {

    }

    @Override
    public void run () {
        try {
            Response response = responseFactory.create (request);
            requestFilterChain.filter (request, response);
            if (!response.isClosed ()) {
                requestHandler.handle (request, response);
                response.close ();
            }
        } catch (Throwable e) {
            log.error ("Exception occurred: ", e);
            // todo: tell client that server has thrown an exception.
        }
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
