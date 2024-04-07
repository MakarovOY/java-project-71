package hexlet.code;


import hexlet.code.formatters.Json.JsonFormat;
import hexlet.code.formatters.plain.PlainFormat;
import hexlet.code.formatters.stylish.StylishFormat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Differ {



    public static String generate(String filepath1, String filepath2, String formatName) throws Exception {

        var map1 = Parser.parseToJavaObject(filepath1);
        var map2 = Parser.parseToJavaObject(filepath2);

        ArrayList<String> allKeys = new ArrayList<>(sortAllKeys(map1, map2));
        LinkedHashMap resultMap = new LinkedHashMap();
        allKeys.forEach(e -> {


            resultMap.put(e, FileCondition.getChangeIndex(map1, map2, e));

        });

        switch (formatName) {
            case "Stylish":
                return StylishFormat.formatStylish(resultMap, map1, map2);
            case "Plain":
                return PlainFormat.formatPlain(resultMap, map1, map2);
            case "Json":
                return JsonFormat.formatJson(resultMap, map1, map2);
            default:
                break;

        }

//
//
        return StylishFormat.formatStylish(resultMap, map1, map2);
    }
    public static String generate(String filepath1, String filepath2) throws Exception {

        return generate(filepath1, filepath2,  "Stylish");
    }



    public static List sortAllKeys(Map map1, Map map2) {
        ArrayList<String> sortedAllKeys = new ArrayList<>();
        map1.forEach((k, v) -> {
            if (!sortedAllKeys.contains(k)) {
                sortedAllKeys.add((String) k);
            }

        });
        map2.forEach((k, v) -> {
            if (!sortedAllKeys.contains(k)) {
                sortedAllKeys.add((String) k);
            }

        });
        Collections.sort(sortedAllKeys);


        return sortedAllKeys;
    }


}
