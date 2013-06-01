package cn.swallowserver;

import java.util.Date;
import java.util.Map;

/**
 * @author Chen Haoming
 */
public interface AttributeHolder {

    Object getAttribute (String key);

    void setAttribute (String key, Object value);

    Object getAttribute (String name, Object defaultAttr);

    String getString (String key);

    Integer getInt (String key);

    Long getLong (String key);

    Float getFloat (String key);

    Double getDouble (String key);

    Date getDate (String key);

    String getString (String key, Object defaultAttr);

    Integer getInt (String key, Object defaultAttr);

    Long getLong (String key, Object defaultAttr);

    Float getFloat (String key, Object defaultAttr);

    Double getDouble (String key, Object defaultAttr);

    Date getDate (String key, Object defaultAttr);
}
