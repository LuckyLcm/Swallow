package cn.swallowserver;

import cn.swallowserver.event.Notifier;
import cn.swallowserver.event.ServerEvenSource;

/**
 * @author Chen Haoming
 */
public interface SwallowServer extends ServerEvenSource {

    ServerContext getServerContext();

}
