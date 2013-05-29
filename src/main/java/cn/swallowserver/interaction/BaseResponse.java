package cn.swallowserver.interaction;

import cn.swallowserver.session.Session;

import java.io.IOException;
import java.io.OutputStream;

/**
 *
 * Base response to the client's request. A request is designed to be handled in a single thread and only one response
 * to each request. So none of requests' and responses' method is thread-safe.
 *
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

    protected void setOut (OutputStream out) {
        if ( null == out ) {
            throw new NullPointerException();
        }

        this.out = out;
    }

    public OutputStream getOut () {
        return out;
    }
}
