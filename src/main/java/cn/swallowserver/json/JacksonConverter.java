package cn.swallowserver.json;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ICMLucky
 */
public class JacksonConverter implements Converter {
    @Override
    public Map<String, Object> convert (String jsonMsg) {
         jsonMsg = "{\"str\":\"string\",\"num\":\"123\"}" ;
        try{
            List<LinkedHashMap<String, Object>> list = objectMapper.readValue(jsonMsg, List.class);
            for (int i= 0;i < list.size ();i++) {
                Map<String, Object> map = list.get(i);
               if( assertEquals ("string", map.get ("str")) && assertEquals (123, map.get ("num"))){
                    System.out.println ("equal!!");
                   return map;
               }
            }
        } catch (IOException e){
                  e.printStackTrace();
        }



    }
}
