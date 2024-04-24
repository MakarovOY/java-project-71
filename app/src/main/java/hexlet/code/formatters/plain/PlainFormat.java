package hexlet.code.formatters.plain;

import hexlet.code.FileCondition;

import java.util.Map;

public class PlainFormat {
    public static String formatPlain(Map resultMap, Map map1, Map map2) {
        StringBuilder stringBuilder = new StringBuilder();

        changeObjectValue(map1);
        changeObjectValue(map2);

        resultMap.forEach((k, v) -> {

            if (v.equals(FileCondition.VALUE_OF_KEY_WAS_CHANGED)) {
                stringBuilder.append("Property '" + k + "' was updated. From "
                        + map1.get(k) + " to " + map2.get(k) + "\n");

            } else if (v.equals(FileCondition.KEY_WAS_DELETED)) {
                stringBuilder.append("Property '" + k + "' was removed" + "\n");

            } else if (v.equals(FileCondition.KEY_WAS_ADDED)) {
                stringBuilder.append("Property '" + k + "' was added with value: " + map2.get(k) + "\n");
            }


        });
        return stringBuilder.toString().trim();
    }


    public static <T> boolean isValuePrimitive(T value) {

        var typeName = value.getClass().getName();

        switch (typeName) {
            case "java.lang.String":
            case "java.lang.Integer":
            case "java.lang.Boolean":
            case "java.lang.Double":
            case "java.lang.Float":
            case "java.lang.Character":
                return true;
            default:
                return false;
        }
    }



    public static Map changeObjectValue(Map map) {
        map.forEach((k, v) -> {
            if (!isValuePrimitive(v)) {
                map.put(k, "[complex value]");
            }
        });
        return map;
    }
}
