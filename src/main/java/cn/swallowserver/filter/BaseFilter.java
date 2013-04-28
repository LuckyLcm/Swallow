package cn.swallowserver.filter;

import cn.swallowserver.session.Request;

/**
 * @author Chen Haoming
 */
public abstract class BaseFilter implements RequestFilterChain {

    private RequestFilter next;

    @Override
    public RequestFilter setNext(RequestFilter requestFilter) {
        this.next = requestFilter;
        return this;
    }

    public Request filter(Request request) {
        doFilter(request);
        if (null != next) {
            next.filter(request);
        }
        return request;
    }

    protected abstract void doFilter(Request request);
}
