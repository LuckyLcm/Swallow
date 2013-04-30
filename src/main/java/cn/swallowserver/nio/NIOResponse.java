package cn.swallowserver.nio;

import cn.swallowserver.session.Response;

import java.nio.channels.SocketChannel;

/**
 * @author Chen Haoming
 */
public interface NIOResponse extends Response {

    SocketChannel getSocketChannel();
}
