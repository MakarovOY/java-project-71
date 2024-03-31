package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class Parser {

    public static Map parse (String filepath)throws Exception {
        Path path = Paths.get(filepath).toAbsolutePath().normalize();

        Map map = new HashMap<>();
        String str = Files.readString(path);

      String str1Arr =  filepath.substring(filepath.length()-3);
      if(str1Arr.equals("son")){

          ObjectMapper objectMapper1 = new ObjectMapper();

           map = objectMapper1.readValue(str,Map.class);

      }
        if(str1Arr.equals("aml")||str1Arr.equals("yml") ){
            ObjectMapper mapper = new YAMLMapper();
             map = mapper.readValue(str, Map.class);
        }


        return map;

    }

}
