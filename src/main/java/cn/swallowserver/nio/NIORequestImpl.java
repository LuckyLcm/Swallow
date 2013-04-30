package cn.swallowserver.nio;

import cn.swallowserver.session.BaseRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * @author Chen Haoming
 */
public class NIORequestImpl extends BaseRequest implements NIORequest {

    private static final transient Logger log = LoggerFactory.getLogger(NIORequestImpl.class);

    private ByteBuffer buffer;

    private byte[] originalMessage;

    public NIORequestImpl(NIOSession session, byte[] originalMessage) {
        super(session);
        this.originalMessage = originalMessage;
    }

    public ByteBuffer getBuffer () {
        return buffer;
    }

    @Override
    public SocketChannel getSocketChannel () {
        return ((NIOSession)getSession()).getSocketChannel();
    }

    @Override
    public byte[] getOriginalMessage () {
        return originalMessage;
    }

}
