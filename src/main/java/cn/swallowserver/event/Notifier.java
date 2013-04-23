package cn.swallowserver.event;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Chen Haoming
 */
public class Notifier implements ServerEvenSource {

    private List<ServerListener> listeners = new LinkedList<ServerListener> ();

    @Override
    public void fireAccepted (Event event) {
        for (ServerListener listener : listeners) {
            listener.onAccepted ();
        }
    }

    @Override
    public void fireConnected () {
        for (ServerListener listener : listeners) {
            listener.onConnected ();
        }
    }

    @Override
    public void fireRead (Event event) {
        for (ServerListener listener : listeners) {
            listener.onRequested ();
        }
    }

    @Override
    public void fireWritten (Event event) {
        for (ServerListener listener : listeners) {
            listener.onResponsed ();
        }
    }

    @Override
    public void fireClosed () {
        for (ServerListener listener : listeners) {
            listener.onClosed ();
        }
    }

    @Override
    public void addListener (ServerListener listener) {
        listeners.add (listener);
    }

    @Override
    public void removeListener (ServerListener listener) {
        listeners.remove (listener);
    }
}
