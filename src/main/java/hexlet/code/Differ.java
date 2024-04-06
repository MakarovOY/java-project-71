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

    public static Map getResultMap(List list, Map map1, Map map2) {
        LinkedHashMap resultMap = new LinkedHashMap();
        list.forEach(e -> {


            resultMap.put(e, FileCondition.getChangeIndex(map1, map2, (String) e));

        });
        return resultMap;
    }



//    public static String formatStylish(Map resultMap, Map map1, Map map2) {
//
//        StringBuilder stringBuilder = new StringBuilder();
//
//        resultMap.forEach((k, v) -> {
//            if (v.equals(FileCondition.VALUE_OF_KEY_DOESNT_CHANGE)) {
//                stringBuilder.append("  " + k + ": " + map1.get(k) + "\n");
//            } else if (v.equals(FileCondition.VALUE_OF_KEY_WAS_CHANGED)) {
//                stringBuilder.append(" -" + k + ": " + map1.get(k) + "\n +" + k + ": " + map2.get(k) + "\n");
//
//            } else if (v.equals(FileCondition.KEY_WAS_DELETED)) {
//                stringBuilder.append(" -" + k + ": " + map1.get(k) + "\n");
//
//            } else if (v.equals(FileCondition.KEY_WAS_ADDED)) {
//                stringBuilder.append(" +" + k + ": " + map2.get(k) + "\n");
//            }
//
//
//        });
//        return  "{\n" + stringBuilder.toString() + "}";
//    }

//    public static String formatPlain(Map resultMap, Map map1, Map map2) {
//        StringBuilder stringBuilder = new StringBuilder();
//
//        changeObjectValue(map1);
//        changeObjectValue(map2);
//
//        resultMap.forEach((k, v) -> {
//
//            if (v.equals(FileCondition.VALUE_OF_KEY_WAS_CHANGED)) {
//                stringBuilder.append("Property '" + k + "' was updated. From "
//                        + map1.get(k) + " to " + map2.get(k) + "\n");
//
//            } else if (v.equals(FileCondition.KEY_WAS_DELETED)) {
//                stringBuilder.append("Property '" + k + "' was removed" + "\n");
//
//            } else if (v.equals(FileCondition.KEY_WAS_ADDED)) {
//                stringBuilder.append("Property '" + k + "' was added with value: " + map2.get(k) + "\n");
//            }
//
//
//        });
//        return stringBuilder.toString();
//    }
//
//
//    public static <T> boolean isValuePrimitive(T value) {
//
//        var typeName = value.getClass().getName();
//
//         switch (typeName){
//             case "java.lang.String":
//             case "java.lang.Integer":
//             case "java.lang.Boolean":
//             case "java.lang.Double":
//             case "java.lang.Float":
//             case "java.lang.Char":
//                 return true;
//             default:
//                 return false;
//         }
//        }
//
//
//
//    public static Map changeObjectValue(Map map) {
//        map.forEach((k, v) -> {
//            if (!isValuePrimitive(v)) {
//                map.put(k, "[complex value]");
//            }
//        });
//        return map;
//    }

}
