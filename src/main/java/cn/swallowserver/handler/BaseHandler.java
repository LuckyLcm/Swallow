package cn.swallowserver.handler;

import cn.swallowserver.filter.BaseFilter;
import cn.swallowserver.filter.RequestFilterChain;
import cn.swallowserver.interaction.Request;
import cn.swallowserver.interaction.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Chen Haoming
 */
public abstract class BaseHandler extends BaseFilter implements RequestHandler, RequestFilterChain {

    private static final transient Logger log = LoggerFactory.getLogger (BaseHandler.class);

    @Override
    protected void doFilter (Request request, Response response) {
        try {
            this.handle (request, response);

            if (!response.isClosed ()) {
                response.close ();
            }
        } catch (Throwable e) {
            log.error ("Exception occurred when handling request:[{}]. Exception message:[{}]", request, e.getMessage ());
            log.error ("Exception:", e);
        }
    }

    /**
     * Do not call this method. BaseHandler is decided to be the last filter chain element. No matter what you set to the
     * parameter, it throws an UnsupportedOperationException intended.
     *
     * @param requestFilter the next filer chain element. It filters request right after the current filter.
     *
     * @return nothing, but throwing an UnsupportedOperationException.
     */
    @Override
    public RequestFilterChain setNext (RequestFilterChain requestFilter) {
        throw new UnsupportedOperationException ();
    }
}
