package cn.swallowserver.filter;

import cn.swallowserver.interaction.Request;
import cn.swallowserver.interaction.Response;

/**
 * @author Chen Haoming
 */
public interface RequestFilter {

    void filter (Request request, Response response);
}
