package cn.swallowserver.nio;

import cn.swallowserver.interaction.Request;

import java.nio.channels.SocketChannel;

/**
 * @author Chen Haoming
 */
public interface NIORequest extends Request {

    SocketChannel getSocketChannel();
}
