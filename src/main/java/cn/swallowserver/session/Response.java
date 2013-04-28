package cn.swallowserver.session;

import java.io.OutputStream;

/**
 * @author Chen Haoming
 */
public interface Response {

    OutputStream getOut();
}
