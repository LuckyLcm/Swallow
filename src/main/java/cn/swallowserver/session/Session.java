package cn.swallowserver.session;

import java.io.IOException;
import java.util.Map;

/**
 * @author Chen Haoming
 */
public interface Session {

    Object getAttribute (String name);

    void setAttribute (String name, Object attr);

    //Object getAttribute (String name, Object defaultAttr);

    //Map<String, Object> getAttributes();

    boolean isValid ();

    void close () throws IOException;

}
