package cn.swallowserver.filter;

/**
 * @author Chen Haoming
 */
public interface RequestFilterChain extends RequestFilter {

    RequestFilterChain setNext (RequestFilterChain requestFilter);
}
