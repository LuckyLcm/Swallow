package cn.swallowserver.event;

/**
 * @author Chen Haoming
 */
public interface ServerEvenSource {

    void fireAccepted (Event event);

    void fireConnected ();

    void fireRead (Event event);

    void fireWritten (Event event);

    void fireClosed ();

    void addListener (ServerListener listener);

    void removeListener (ServerListener listener);
}
