package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class Parser {

    public static Map parseToJavaObject(String filepath) throws Exception {
        Path path = Paths.get(filepath).toAbsolutePath().normalize();

        Map map = new HashMap<>();
        String str = Files.readString(path);
        int lastDotIndex = filepath.lastIndexOf('.');
        String fileExtension = filepath.substring(lastDotIndex + 1, filepath.length());

        switch (fileExtension) {
            case "yaml":
            case "yml":
                ObjectMapper mapper = new YAMLMapper();
                map = mapper.readValue(str, Map.class);
                break;
            case "json":

                ObjectMapper objectMapper1 = new ObjectMapper();
                map = objectMapper1.readValue(str, Map.class);
                break;
            default:
                break;
        }

        return map;

    }

}
