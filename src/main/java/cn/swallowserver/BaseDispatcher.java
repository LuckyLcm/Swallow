package cn.swallowserver;

import cn.swallowserver.filter.RequestFilterChain;
import cn.swallowserver.interaction.Request;
import cn.swallowserver.interaction.Response;

/**
 *  @author Chen Haoming
 */
public abstract class BaseDispatcher implements Runnable {

    private RequestFilterChain filterChain;

    private Request request;

    public BaseDispatcher(RequestFilterChain filterChain, Request request) {
        this.filterChain = filterChain;
        this.request = request;
    }

    @Override
    public void run() {
        Request result = filterChain.filter(request);
        Response response = create(result);
    }

    public abstract Response create(Request request);


}
