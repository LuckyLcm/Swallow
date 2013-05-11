package cn.swallowserver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Chen Haoming
 */
public abstract class ThreadTemplate extends Thread {

    public static final int DEFAULT_TIMEOUT = 5000;
    private static final transient Logger log = LoggerFactory.getLogger (ThreadTemplate.class);

    private boolean isRunning = true;

    @Override
    public final void run () {
        log.debug("The current thread starts to run.");
        preRunning ();

        while (isRunning) {
            try {
                running ();
            } catch (InterruptedException e) {
                log.info ("This thread is interrupted and going to stop.");
                break;
            } catch (Throwable t) {
                log.error ("Unexpected exception occurred.", t);
            }
        }

        postRunning ();
        log.debug("The current thread ends normally.");
    }

    protected void preRunning (){

    }

    /**
     * Running method which should be implemented by a concrete class.
     * Please note that it's called in a while-cycle,
     * so do not use cycle in the implemented method.
     */
    protected abstract void running () throws InterruptedException;

    protected void postRunning (){

    }

    /**
     * Stop the current thread if it's alive. Otherwise it has no effect.
     */
    public void stopThread () {
        if (this.isAlive ()) {
            this.isRunning = false;
            this.interrupt();
            log.debug ("Stopping current thread.");
        }
    }

    protected boolean isRunning() {
        return isRunning;
    }
}
