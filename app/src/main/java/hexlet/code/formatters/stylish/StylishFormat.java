package hexlet.code.formatters.stylish;

import hexlet.code.FileCondition;

import java.util.LinkedHashMap;
import java.util.Map;

public class StylishFormat {


    public static String formatStylish(LinkedHashMap<String, Map> keysInfoMap) {


        StringBuilder stringBuilder = new StringBuilder();



        keysInfoMap.forEach((k, v) -> {

            switch (v.get(FileCondition.KEY_CHANGE_STATUS).toString()) {
                case FileCondition.VALUE_OF_KEY_DOESNT_CHANGE:
                    stringBuilder.append("    " + k + ": " + v.get(FileCondition.KEY_ACTUAL_VALUE) + "\n");
                    break;
                case FileCondition.VALUE_OF_KEY_WAS_CHANGED:
                    stringBuilder.append("  - " + k + ": " + v.get(FileCondition.KEY_PREVIOUS_VALUE)
                            + "\n  + " + k + ": " + v.get(FileCondition.KEY_ACTUAL_VALUE) + "\n");
                    break;
                case FileCondition.KEY_WAS_DELETED:
                    stringBuilder.append("  - " + k + ": " + v.get(FileCondition.KEY_PREVIOUS_VALUE) + "\n");
                    break;
                case FileCondition.KEY_WAS_ADDED:
                    stringBuilder.append("  + " + k + ": " + v.get(FileCondition.KEY_ACTUAL_VALUE) + "\n");
                    break;
                default:
                    break;
            }

        });

        return  "{\n" + stringBuilder.toString() + "}";
    }

}
