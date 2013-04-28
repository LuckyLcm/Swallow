package cn.swallowserver.filter;

import cn.swallowserver.session.Request;

/**
 * @author Chen Haoming
 */
public interface RequestFilter {

    Request filter(Request request);
}
