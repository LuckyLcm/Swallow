package cn.swallowserver.dispatcher;

import cn.swallowserver.filter.RequestFilterChain;
import cn.swallowserver.handler.RequestHandler;
import cn.swallowserver.interaction.Request;
import cn.swallowserver.interaction.Response;

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

    public void setRequestFilterChains (RequestFilterChain[] requestFilterChains) {
        if (null != requestFilterChains && requestFilterChains.length > 0) {
            this.requestFilterChain = requestFilterChains[0];
            RequestFilterChain currentFilter = this.requestFilterChain;

            for (int i = 1; i < requestFilterChains.length; ++i) {
                currentFilter.setNext (requestFilterChains[i]);
                currentFilter = requestFilterChains[i];
            }

            currentFilter.setNext (new RequestFilterChain () {

                @Override
                public RequestFilterChain setNext (RequestFilterChain requestFilter) {
                    throw new UnsupportedOperationException (
                            "It's designed to be the last request filter. So never set next filter to it.");
                }

                @Override
                public void filter (Request request, Response response) {
                    requestHandler.handle (request, response);
                }
            });
        }
    }

    public void setRequestHandler (RequestHandler requestHandler) {
        this.requestHandler = requestHandler;
    }
}
