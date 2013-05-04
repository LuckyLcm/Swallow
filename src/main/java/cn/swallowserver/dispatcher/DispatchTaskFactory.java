package cn.swallowserver.dispatcher;

import cn.swallowserver.interaction.Request;

/**
 * @author ICMLucky
 */
public interface DispatchTaskFactory {

    DispatchTask create(Request request);
}
