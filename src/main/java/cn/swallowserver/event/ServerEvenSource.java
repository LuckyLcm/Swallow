package cn.swallowserver.event;

/**
 * @author Chen Haoming
 */
public interface ServerEvenSource {

    void register(ServerEventNotifier notifier);

}
