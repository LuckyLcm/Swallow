package cn.swallowserver.event;


import cn.swallowserver.SwallowServer;

/**
 * @author Chen Haoming
 */
public interface ServerEventNotifier {

    void registerListener(ServerListener listener);

    void fireAccepted(Event event);

    void fireConnected();

    void fireRead(Event event);

    void fireWritten(Event event);

    void fireClosed();

    void removeListener(ServerListener listener);
}
