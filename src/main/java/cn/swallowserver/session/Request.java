package cn.swallowserver.session;

import cn.swallowserver.AttributeHolder;

import java.io.InputStream;

/**
 * @author Chen Haoming
 */
public interface Request extends AttributeHolder {

    //InputStream getIn();

    byte[] getOriginalMessage();

}
