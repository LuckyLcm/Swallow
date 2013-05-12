package cn.swallowserver.interaction;

import cn.swallowserver.session.Session;

import java.io.IOException;
import java.io.OutputStream;

/**
 * @author Chen Haoming
 */
public abstract class BaseResponse extends BaseInteraction implements Response {

    private OutputStream out;

    private boolean closed = false;

    public BaseResponse (Session session) {
        super (session);
    }

    @Override
    public boolean isClosed () {
        return closed;
    }

    @Override
    public void close () throws IOException {
        if (!isClosed ()) {
            OutputStream os = getOut ();
            try {
                os.flush ();
            } finally {
                os.close ();
                closed = true;
            }
        }
    }
}
