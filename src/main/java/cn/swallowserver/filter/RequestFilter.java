package cn.swallowserver.filter;

import cn.swallowserver.interaction.Request;

/**
 * @author Chen Haoming
 */
public interface RequestFilter {

    Request filter(Request request);
}
