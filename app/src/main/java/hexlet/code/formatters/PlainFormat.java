package hexlet.code.formatters;

import hexlet.code.FileDiff;

import java.util.LinkedHashMap;
import java.util.Map;

public class PlainFormat {

    public static String formatPlain(LinkedHashMap<String, Map> keysInfoMap) {
        StringBuilder stringBuilder = new StringBuilder();


        keysInfoMap.forEach((k, v) -> {

            switch (v.get(FileDiff.KEY_CHANGE_STATUS).toString()) {

                case FileDiff.VALUE_OF_KEY_WAS_CHANGED:
                    stringBuilder.append("Property '" + k + "' was updated. From "
                            + changeObjectValue(v.get(FileDiff.KEY_PREVIOUS_VALUE))
                            + " to " + changeObjectValue(v.get(FileDiff.KEY_ACTUAL_VALUE)) + "\n");
                    break;
                case FileDiff.KEY_WAS_DELETED:
                    stringBuilder.append("Property '" + k + "' was removed" + "\n");
                    break;
                case FileDiff.KEY_WAS_ADDED:
                    stringBuilder.append("Property '" + k + "' was added with value: "
                            + changeObjectValue(v.get(FileDiff.KEY_ACTUAL_VALUE)) + "\n");
                    break;
                default:
                    break;

            }
        });
        return stringBuilder.toString().trim();
    }


    public static  boolean isValuePrimitive(Object value) {

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



    public static String changeObjectValue(Object object) {
        if (!isValuePrimitive(object)) {
            return "[complex value]";
        }
        if (object.getClass().getName().equals("java.lang.String") && !object.equals("null")) {

            return "'" + object + "'";

        }
        return object.toString();
    }

}
