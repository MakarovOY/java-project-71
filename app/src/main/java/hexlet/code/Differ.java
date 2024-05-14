package hexlet.code;


import hexlet.code.formatters.JsonFormat;
import hexlet.code.formatters.PlainFormat;
import hexlet.code.formatters.StylishFormat;

import java.util.Map;

public class Differ {



    public String generate(String filepath1, String filepath2, String formatName) throws Exception {

        Parser parser1 = new Parser();
        Parser parser2 = new Parser();

        Map<String, Object> map1 = parser1.parseToJavaObject(filepath1);
        Map<String, Object> map2 = parser2.parseToJavaObject(filepath2);



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

    public String generate(String filepath1, String filepath2) throws Exception {

        return this.generate(filepath1, filepath2,  "stylish");
    }



}
