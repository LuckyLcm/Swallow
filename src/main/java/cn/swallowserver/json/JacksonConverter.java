package cn.swallowserver.json;

import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.util.Map;

/**
 * @author ICMLucky
 */
public class JacksonConverter implements Converter {

    @Override
    public Map<String, Object> convert (String jsonMsg) {

        try {
            return new ObjectMapper ().readValue (jsonMsg, Map.class);
        } catch (IOException e) {
            throw new RuntimeException (e);
        }


    }
}
