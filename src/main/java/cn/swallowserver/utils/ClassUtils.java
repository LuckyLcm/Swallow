package cn.swallowserver.utils;

/**
 * @author Chen Haoming
 */
public class ClassUtils {

    public static void checkAttributeClass (String key, Object attribute, Class aClass) {
        if (null != attribute && ! (aClass.isInstance (attribute))) {
            throw new IllegalStateException ("Attribute[" + key + ":" + attribute
                    + "(" + attribute.getClass () + ")] is not an instance of " + aClass);
        }
    }
}
