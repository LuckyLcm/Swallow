package cn.swallowserver.nio;

import cn.swallowserver.interaction.Request;
import cn.swallowserver.interaction.Response;
import cn.swallowserver.interaction.ResponseFactory;

/**
 * @author ICMLucky
 */
public class NIOResponseFactory implements ResponseFactory {


    @Override
    public Response create (Request request) {
        return new NIOResponseImpl (request.getSession ());

    }
}
