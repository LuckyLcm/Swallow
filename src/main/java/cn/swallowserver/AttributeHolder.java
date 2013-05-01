package cn.swallowserver;

/**
 * @author Chen Haoming
 */
public interface AttributeHolder {

    Object getAttribute(String key);

    void setAttribute(String key, Object value);

    //Object getAttribute (String name, Object defaultAttr);

    //Map<String, Object> getAttributes();
}
