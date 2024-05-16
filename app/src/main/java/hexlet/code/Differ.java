package hexlet.code;


import hexlet.code.formatters.JsonFormat;
import hexlet.code.formatters.PlainFormat;
import hexlet.code.formatters.StylishFormat;

import java.util.Map;

public class Differ {



    public static String generate(String filepath1, String filepath2, String formatName) throws Exception {



        Map<String, Object> map1 = Parser.parseToJavaObject(filepath1);
        Map<String, Object> map2 = Parser.parseToJavaObject(filepath2);



        switch (formatName) {
            case "stylish":
                return StylishFormat.formatStylish(FileDiff.getDiffMap(map1, map2));
            case "plain":
                return PlainFormat.formatPlain(FileDiff.getDiffMap(map1, map2));
            case "json":
                return JsonFormat.formatJson(FileDiff.getDiffMap(map1, map2));
            default:
                throw new Exception("Wrong file format");

        }

    }

    public static String generate(String filepath1, String filepath2) throws Exception {

        return generate(filepath1, filepath2,  "stylish");
    }



}
