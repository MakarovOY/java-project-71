package hexlet.code;


import hexlet.code.formatters.JsonFormat;
import hexlet.code.formatters.PlainFormat;
import hexlet.code.formatters.StylishFormat;

public class Differ {



    public static String generate(String filepath1, String filepath2, String formatName) throws Exception {

        var map1 = Parser.parseToJavaObject(filepath1);
        var map2 = Parser.parseToJavaObject(filepath2);



        switch (formatName) {
            case "stylish":
                return StylishFormat.formatStylish(FileDiff.getDiffMap(map1, map2));
            case "plain":
                return PlainFormat.formatPlain(FileDiff.getDiffMap(map1, map2));
            case "json":
                return JsonFormat.formatJson(FileDiff.getDiffMap(map1, map2));
            default:
                break;

        }

        return StylishFormat.formatStylish(FileDiff.getDiffMap(map1, map2));
    }

    public static String generate(String filepath1, String filepath2) throws Exception {

        return generate(filepath1, filepath2,  "stylish");
    }



}
