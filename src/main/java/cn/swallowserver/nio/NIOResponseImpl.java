package cn.swallowserver.nio;

import cn.swallowserver.interaction.BaseResponse;
import cn.swallowserver.session.Session;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * @author Chen Haoming
 *         <p/>
 *         Note that the output stream of this class can only be flushed once.
 */
public class NIOResponseImpl extends BaseResponse implements NIOResponse {

    public static final int DEFAULT_SIZE_OF_RESPONSE_AND_PUSH_MESSAGE = 1024;
    public static final int INCREMENT_FACTOR_RESPONSE_AND_PUSH_MESSAGE = 2;
    public static final int MAX_SIZE_OF_RESPONSE_AND_PUSH_MESSAGE
            = DEFAULT_SIZE_OF_RESPONSE_AND_PUSH_MESSAGE * INCREMENT_FACTOR_RESPONSE_AND_PUSH_MESSAGE * 32;

    private SocketChannel socketChannel;

    public NIOResponseImpl (Session session) {
        super (session);
        socketChannel = ((NIOSession) getSession ()).getSocketChannel ();
    }

    @Override
    public SocketChannel getSocketChannel () {
        return socketChannel;
    }

    @Override
    public OutputStream getOut () {
        return new OutputStream () {

            private byte[] bytes = new byte[DEFAULT_SIZE_OF_RESPONSE_AND_PUSH_MESSAGE];
            private int len = 0;
            private boolean closed = false;
            private boolean flushed = false;

            @Override
            public void write (int b) throws IOException {
                if (flushed || closed) {
                    throw new IllegalStateException (
                            "This stream has ever been flushed or closed, so can write data anymore.");
                }

                if (len == bytes.length) {
                    if (MAX_SIZE_OF_RESPONSE_AND_PUSH_MESSAGE == bytes.length) {
                        throw new IllegalStateException (
                                "Your message has reached the max size of response and push message. " +
                                        "So you could not write data anymore.");
                    }

                    byte[] tem = new byte[bytes.length * INCREMENT_FACTOR_RESPONSE_AND_PUSH_MESSAGE];
                    System.arraycopy (bytes, 0, tem, 0, bytes.length);
                    bytes = tem;
                }

                bytes[len++] = (byte) b;
            }

            @Override
            public void flush () throws IOException {
                if (!flushed && len > 0 && !closed) {
                    ByteBuffer byteBuffer = ByteBuffer.wrap (bytes);
                    socketChannel.write (byteBuffer);
                    bytes = null;
                    len = 0;
                    flushed = true;
                }
            }

            @Override
            public void close () throws IOException {
                if (!closed) {
                    flush ();
                    closed = true;
                }
            }
        };
    }
}
