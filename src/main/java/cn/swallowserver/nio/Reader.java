package cn.swallowserver.nio;

import cn.swallowserver.dispatcher.DispatchTask;
import cn.swallowserver.dispatcher.DispatchTaskFactory;
import cn.swallowserver.session.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author Chen Haoming
 */
public class Reader extends IOThread {

    private static final transient Logger log = LoggerFactory.getLogger (Reader.class);

    private BlockingQueue<SelectionKey> selectionKeys;

    private ExecutorService pool;

    private DispatchTaskFactory dispatchTaskFactory;

    Reader (Server server) {
        super (server);
    }

    @Override
    protected void preRunning () {
        selectionKeys = new LinkedBlockingQueue<SelectionKey> ();
        pool = new ThreadPoolExecutor (5, 50, 30, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable> (1000), new ThreadPoolExecutor.AbortPolicy ());
        dispatchTaskFactory = new DispatchTaskFactory ();
    }

    @Override
    protected void running () throws InterruptedException {
        SelectionKey selectionKey = selectionKeys.poll ();
        SocketChannel channel = (SocketChannel) selectionKey.channel ();
        ByteBuffer buffer = getBuffer ();
        buffer.clear ();
        byte[] allBytesRead = new byte[0];

        try {
            int len = channel.read (buffer);

            while (len > 0) {
                buffer.flip ();
                byte[] bytes = Arrays.copyOf (buffer.array (), len);
                byte[] temBytes = allBytesRead;
                allBytesRead = new byte[temBytes.length + bytes.length];
                System.arraycopy (temBytes, 0, allBytesRead, 0, temBytes.length);
                System.arraycopy (bytes, 0, allBytesRead, temBytes.length, bytes.length);
                len = channel.read (buffer);
            }

            if (allBytesRead.length > 0) {
                NIORequestImpl request = new NIORequestImpl (getServer ().getSocketChannelSessionMap ().get (channel));
                request.setOriginalMessage (allBytesRead);
                DispatchTask task = dispatchTaskFactory.create (request);

                try {
                    pool.execute (task);
                } catch (RejectedExecutionException e) {
                    log.warn ("Request is rejected to be executed:{}", request);
                }
            } else {
                log.error ("Nothing can be read from SocketChannel[{}].", channel);
            }
        } catch (IOException e) {
            log.error ("Exception occurred when reading from SocketChannel:{}\nMessage:", channel, e.getMessage ());
            return;
        }

        buffer.clear ();
    }

    @Override
    protected void postRunning () {
        try {
            pool.shutdown ();
            pool.awaitTermination (30, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            log.info ("Awaiting termination of executor-pool of request-dispatcher has been interrupted. The current reader stops right now. All uncompleted-dispatcher-tasks are ignored.");
            pool.shutdownNow ();
        }

        if (pool.isTerminated ()) {
            log.info ("Awaiting termination of executor-pool of request-dispatcher has been timeout. The current reader stops right now. All uncompleted-dispatcher-tasks are ignored.");
            pool.shutdownNow ();
        }

        selectionKeys = null;
        pool = null;
        dispatchTaskFactory = null;
    }

    void read (SelectionKey selectionKey) {
        if (!isRunning ()) {
            throw new IllegalStateException ("Read[" + this + "] is not started, so cannot read.");
        }
        selectionKeys.offer (selectionKey);
    }

}
