package cn.swallowserver;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Chen Haoming
 */
public abstract class BaseAttributeHolder implements AttributeHolder {

    private Map<String, Object> attributes = new HashMap<String, Object>();

    @Override
    public Object getAttribute(String key) {
        return attributes.get(key);
    }

    @Override
    public void setAttribute(String key, Object value) {
        attributes.put(key, value);
    }

    @Override
    public Object getAttribute(String name, Object defaultAttr) {
        return attributes.containsKey(name) ? attributes.get(name) : defaultAttr;
    }

    protected void setAttributes(Map<String, Object> attributes) {
        this.attributes = attributes;
    }
}
