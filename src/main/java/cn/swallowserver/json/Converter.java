package cn.swallowserver.json;

import java.util.Map;

/**
 * @author ICMLucky
 */
public interface Converter {

    Map<String,Object> convert (String jsonMsg);
}
