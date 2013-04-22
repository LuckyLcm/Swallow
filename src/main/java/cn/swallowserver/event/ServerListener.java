package cn.swallowserver.event;

/**
 * @author Chen Haoming
 */
public interface ServerListener {

    void onAccepted ();

    void onConnected ();

    void onRequested ();

    void onResponsed ();

    void onClosed ();
}
