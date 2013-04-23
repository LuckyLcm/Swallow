package cn.swallowserver;

import java.io.OutputStream;
import java.nio.channels.SelectionKey;

/**
 * @author Chen Haoming
 */
public class Response extends Interaction {

    private OutputStream out;

    public Response(SelectionKey selectionKey) {
        super(selectionKey);
    }

    public OutputStream getOut() {
        return out;
    }
}
