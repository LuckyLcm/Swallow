package cn.swallowserver.nio;

import cn.swallowserver.session.BaseResponse;
import cn.swallowserver.session.Session;

import java.io.OutputStream;
import java.nio.channels.SocketChannel;

/**
 * @author Chen Haoming
 */
public class NIOResponseImpl extends BaseResponse implements NIOResponse {

    public NIOResponseImpl(Session session) {
        super(session);
    }

    @Override
    public SocketChannel getSocketChannel () {
        return ((NIOSession)getSession()).getSocketChannel();
    }

    @Override
    public OutputStream getOut() {
        throw new UnsupportedOperationException();  //To change body of created methods use File | Settings | File Templates.
    }
}
