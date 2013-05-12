package cn.swallowserver.interaction;

import java.io.IOException;
import java.io.OutputStream;

/**
 * @author Chen Haoming
 */
public interface Response extends Interaction {

    OutputStream getOut ();

    boolean isClosed ();

    void close () throws IOException;
}
