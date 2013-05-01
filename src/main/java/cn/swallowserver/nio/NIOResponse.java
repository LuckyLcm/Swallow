package cn.swallowserver.nio;

import cn.swallowserver.interaction.Response;

import java.nio.channels.SocketChannel;

/**
 * @author Chen Haoming
 */
public interface NIOResponse extends Response {

    SocketChannel getSocketChannel();
}
