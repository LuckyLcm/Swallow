package cn.swallowserver.session;

/**
 * @author Chen Haoming
 */
public interface Request {

    byte[] getOriginalRequest();

    String getJSONRequest();
}
