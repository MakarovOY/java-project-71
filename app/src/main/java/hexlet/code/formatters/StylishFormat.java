package hexlet.code.formatters;

import hexlet.code.FileDiff;

import java.util.LinkedHashMap;
import java.util.Map;

public class StylishFormat {


    public static String formatStylish(LinkedHashMap<String, Map> keysInfoMap) {


        StringBuilder stringBuilder = new StringBuilder();



        keysInfoMap.forEach((k, v) -> {

            switch (v.get(FileDiff.KEY_CHANGE_STATUS).toString()) {
                case FileDiff.VALUE_OF_KEY_DOESNT_CHANGE:
                    stringBuilder.append("    " + k + ": " + v.get(FileDiff.KEY_ACTUAL_VALUE) + "\n");
                    break;
                case FileDiff.VALUE_OF_KEY_WAS_CHANGED:
                    stringBuilder.append("  - " + k + ": " + v.get(FileDiff.KEY_PREVIOUS_VALUE)
                            + "\n  + " + k + ": " + v.get(FileDiff.KEY_ACTUAL_VALUE) + "\n");
                    break;
                case FileDiff.KEY_WAS_DELETED:
                    stringBuilder.append("  - " + k + ": " + v.get(FileDiff.KEY_PREVIOUS_VALUE) + "\n");
                    break;
                case FileDiff.KEY_WAS_ADDED:
                    stringBuilder.append("  + " + k + ": " + v.get(FileDiff.KEY_ACTUAL_VALUE) + "\n");
                    break;
                default:
                    break;
            }

        });

        return  "{\n" + stringBuilder + "}";
    }

}
