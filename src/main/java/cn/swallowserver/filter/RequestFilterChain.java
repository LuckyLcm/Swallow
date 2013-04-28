package cn.swallowserver.filter;

/**
 * @author Chen Haoming
 */
public interface RequestFilterChain extends RequestFilter {

    RequestFilter setNext(RequestFilter requestFilter);
}
