package cn.swallowserver;

import cn.swallowserver.BaseThread;
import cn.swallowserver.session.Request;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 *  @author Chen Haoming
 */
public class HandlerThread extends BaseThread {

    private Queue<Request> requestQueue = new LinkedBlockingQueue<Request>();

    @Override
    protected void preRunning() {
        throw new UnsupportedOperationException();  //To change body of created methods use File | Settings | File Templates.
    }

    @Override
    protected void running() throws InterruptedException {
        throw new UnsupportedOperationException();  //To change body of created methods use File | Settings | File Templates.
    }

    @Override
    protected void postRunning() {
        throw new UnsupportedOperationException();  //To change body of created methods use File | Settings | File Templates.
    }

    public void handle(Request request) {
        requestQueue.offer(request);
    }

}
