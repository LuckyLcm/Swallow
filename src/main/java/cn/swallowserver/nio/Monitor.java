package cn.swallowserver.nio;

import cn.swallowserver.ThreadTemplate;

/**
 * @author Chen Haoming
 */
public class Monitor extends ThreadTemplate {

    private Server server;

    Monitor (Server server) {
       this.server = server;
    }

    @Override
    protected void running () throws InterruptedException {
        server.getSocketChannelSessionMap ();
    }
}
