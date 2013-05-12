package cn.swallowserver.filter;

import cn.swallowserver.interaction.Request;
import cn.swallowserver.interaction.Response;

/**
 * @author Chen Haoming
 */
public abstract class BaseFilter implements RequestFilterChain {

    private RequestFilter next;

    @Override
    public RequestFilter setNext (RequestFilter requestFilter) {
        this.next = requestFilter;
        return this;
    }

    public void filter (Request request, Response response) {
        doFilter (request, response);

        if (!response.isClosed () && null != next) {
            next.filter (request, response);
        }
    }

    protected abstract void doFilter (Request request, Response response);
}
