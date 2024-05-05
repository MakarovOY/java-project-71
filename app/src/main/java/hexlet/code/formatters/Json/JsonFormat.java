package hexlet.code.formatters.Json;


import java.util.LinkedHashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonFormat {



    public static String formatJson(LinkedHashMap<String, Map> keysInfoMap)  throws Exception {

        ObjectMapper objectMapper = new ObjectMapper();

        String jsonObjectAsString = objectMapper.writeValueAsString(keysInfoMap);

        return jsonObjectAsString;

    }

}
