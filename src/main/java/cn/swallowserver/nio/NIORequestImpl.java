package cn.swallowserver.nio;

import cn.swallowserver.interaction.BaseRequest;
import cn.swallowserver.interaction.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

/**
 * @author Chen Haoming
 */
public class NIORequestImpl extends BaseRequest implements NIORequest {

    private static final transient Logger log = LoggerFactory.getLogger(NIORequestImpl.class);

    private ByteBuffer buffer;

    private byte[] originalMessage;

    public NIORequestImpl(NIOSession session) {
        super(session);
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

    @Override
    public String getMessage() {
        String msg = Charset.forName("").decode (ByteBuffer.wrap (getOriginalMessage())).toString ();
        log.debug ("Read message: {}", msg);
        return msg;
    }

    @Override
    public RequestContext getRequestContext() {
        throw new UnsupportedOperationException();  //To change body of created methods use File | Settings | File Templates.
    }

    public void setOriginalMessage(byte[] originalMessage) {
        this.originalMessage = originalMessage;
    }
}
