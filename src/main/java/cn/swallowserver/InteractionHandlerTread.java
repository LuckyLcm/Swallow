package cn.swallowserver;

import java.lang.ref.SoftReference;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

/**
 * @author Chen Haoming
 */
public abstract class InteractionHandlerTread extends BaseThread {

    private static final int CAPACITY = 1024;

    private Server server;
    private int bufferCapacity = CAPACITY;
    private int timeout = DEFAULT_TIMEOUT;
    private TimeUnit timeUnit = TimeUnit.MILLISECONDS;
    private SoftReference<ByteBuffer> bufferCache;

    InteractionHandlerTread(Server server) {
        this.server = server;
    }

    protected ByteBuffer getBuffer () {
        if (null == bufferCache || null == bufferCache.get ()) {
            bufferCache = new SoftReference<ByteBuffer> (ByteBuffer.allocate (bufferCapacity));
        }

        return bufferCache.get ();
    }

    public void setBufferCapacity (int bufferCapacity) {
        this.bufferCapacity = bufferCapacity;
    }

    protected Server getServer () {
        return server;
    }

    public void setTimeout (int timeout) {
        this.timeout = timeout;
    }

    public int getTimeout () {
        return timeout;
    }

    public TimeUnit getTimeUnit () {
        return timeUnit;
    }

    public void setTimeUnit (TimeUnit timeUnit) {
        this.timeUnit = timeUnit;
    }

}
