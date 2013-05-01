package cn.swallowserver;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Chen Haoming
 */
public class BaseAttributeHolder implements AttributeHolder {

    private Map<String, Object> attributes = new HashMap<String, Object>();

    @Override
    public Object getAttribute(String key) {
        return attributes.get(key);
    }

    @Override
    public void setAttribute(String key, Object value) {
        attributes.put(key,value);
    }
}
