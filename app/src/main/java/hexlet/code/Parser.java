package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public class Parser {

    public  Map<String, Object> parseToJavaObject(String filepath) throws Exception {
        Path path = Paths.get(filepath).toAbsolutePath().normalize();

        String str = Files.readString(path);
        int lastDotIndex = filepath.lastIndexOf('.');
        String fileExtension = filepath.substring(lastDotIndex + 1);

        switch (fileExtension) {
            case "yaml":
            case "yml":
                ObjectMapper mapper = new YAMLMapper();
                return mapper.readValue(str, Map.class);
            case "json":
                ObjectMapper objectMapper1 = new ObjectMapper();
                return objectMapper1.readValue(str, Map.class);
            default:
                throw new Exception("Wrong file format");
        }

    }


}
