package cn.swallowserver;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Chen Haoming
 */
public abstract class BaseAttributeHolder implements AttributeHolder {

    private Map<String, Object> attributes = new HashMap<String, Object> ();
    private DateFormat dateFormat = new SimpleDateFormat ("z yyyy-MM-dd HH:mm:ss.SSS");

    @Override
    public Object getAttribute (String key) {
        return attributes.get (key);
    }

    @Override
    public void setAttribute (String key, Object value) {
        attributes.put (key, value);
    }

    @Override
    public Object getAttribute (String name, Object defaultAttr) {
        return attributes.containsKey (name) ? attributes.get (name) : defaultAttr;
    }

    @Override
    public String getString (String key) {
        Object attribute = this.getAttribute (key);
        return null == attribute ? null : (String) attribute;
    }

    @Override
    public Integer getInt (String key) {
        Object attribute = this.getAttribute (key);
        return null == attribute ? null :
                (String.class.isInstance (attribute) ? Integer.parseInt ((String) attribute) : (Integer) attribute);
    }

    @Override
    public Long getLong (String key) {
        Object attribute = this.getAttribute (key);
        return null == attribute ? null :
                (String.class.isInstance (attribute) ? Long.parseLong ((String) attribute) : (Long) attribute);
    }

    @Override
    public Float getFloat (String key) {
        Object attribute = this.getAttribute (key);
        return null == attribute ? null :
                (String.class.isInstance (attribute) ? Float.parseFloat ((String) attribute) : (Float) attribute);
    }

    @Override
    public Double getDouble (String key) {
        Object attribute = this.getAttribute (key);
        return null == attribute ? null :
                (String.class.isInstance (attribute) ? Double.parseDouble ((String) attribute) : (Double) attribute);
    }

    @Override
    public Date getDate (String key) {
        try {
            Object attribute = this.getAttribute (key);
            return null == attribute ? null : Date.class.isInstance (attribute) ?
                    (Date) attribute : dateFormat.parse ((String) attribute);
        } catch (Exception e) {
            throw new IllegalStateException (e);
        }
    }

    @Override
    public String getString (String key, String defaultAttr) {
        String str = this.getString (key);
        return null == str ? defaultAttr : str;
    }

    @Override
    public Integer getInt (String key, Integer defaultAttr) {
        Integer anInt = getInt (key);
        return null == anInt ? defaultAttr : anInt;
    }

    @Override
    public Long getLong (String key, Long defaultAttr) {
        Long aLong = getLong (key);
        return null == aLong ? defaultAttr : aLong;
    }

    @Override
    public Float getFloat (String key, Float defaultAttr) {
        Float aFloat = getFloat (key);
        return null == aFloat ? defaultAttr : aFloat;
    }

    @Override
    public Double getDouble (String key, Double defaultAttr) {
        Double aDouble = getDouble (key);
        return null == aDouble ? defaultAttr : aDouble;
    }

    @Override
    public Date getDate (String key, Date defaultAttr) {
        Date date = getDate (key);
        return null == date ? defaultAttr : date;
    }

    protected void setAttributes (Map<String, Object> attributes) {
        this.attributes = attributes;
    }

    public void setDateFormat (DateFormat dateFormat) {
        this.dateFormat = dateFormat;
    }
}
