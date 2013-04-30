package cn.swallowserver.nio;

import cn.swallowserver.BaseThread;

import java.lang.ref.SoftReference;
import java.nio.ByteBuffer;
import java.util.concurrent.TimeUnit;

/**
 * @author Chen Haoming
 */
public abstract class IOThread extends BaseThread {

    private static final int CAPACITY = 1024;

    private Server server;
    private int bufferCapacity = CAPACITY;
    private int timeout = DEFAULT_TIMEOUT;
    private TimeUnit timeUnit = TimeUnit.MILLISECONDS;
    private SoftReference<ByteBuffer> bufferCache;

    IOThread(Server server) {
        if (null == server) {
            throw new NullPointerException("Server is null!");
        }
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
