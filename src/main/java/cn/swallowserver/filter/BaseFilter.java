package cn.swallowserver.filter;

import cn.swallowserver.interaction.Request;
import cn.swallowserver.interaction.Response;

/**
 * @author Chen Haoming
 */
public abstract class BaseFilter implements RequestFilterChain {

    private RequestFilterChain next;

    /**
     *
     *
     *
     * @param requestFilter the next filer chain element. It filters request right after the current filter.
     * @return the next filter chain element which has been set.
     */
    @Override
    public RequestFilterChain setNext (RequestFilterChain requestFilter) {
        this.next = requestFilter;
        return next;
    }

    public final void filter (Request request, Response response) {
        doFilter (request, response);

        if (!response.isClosed () && null != next) {
            next.filter (request, response);
        }
    }

    protected abstract void doFilter (Request request, Response response);

    protected RequestFilterChain getNext () {
        return next;
    }
}
