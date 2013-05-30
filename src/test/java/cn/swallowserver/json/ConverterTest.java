package cn.swallowserver.json;

import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * @author ICMLucky
 */
public class ConverterTest {

    @Test
    public void testConverter () {
        Converter converter = new JacksonConverter ();
        String jsonMsg = "{\"str\":\"string\",\"num\":123}";
        Map<String, Object> msg = converter.convert (jsonMsg);
        assertEquals ("string", msg.get ("str"));
        assertEquals (123, msg.get ("num"));


    }


}
