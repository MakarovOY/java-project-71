package hexlet.code.formatters.stylish;

import hexlet.code.FileCondition;

import java.util.Map;

public class StylishFormat {
    public static String formatStylish(Map resultMap, Map map1, Map map2) {

        StringBuilder stringBuilder = new StringBuilder();

        resultMap.forEach((k, v) -> {
            if (v.equals(FileCondition.VALUE_OF_KEY_DOESNT_CHANGE)) {
                stringBuilder.append("  " + k + ": " + map1.get(k) + "\n");
            } else if (v.equals(FileCondition.VALUE_OF_KEY_WAS_CHANGED)) {
                stringBuilder.append(" -" + k + ": " + map1.get(k) + "\n +" + k + ": " + map2.get(k) + "\n");

            } else if (v.equals(FileCondition.KEY_WAS_DELETED)) {
                stringBuilder.append(" -" + k + ": " + map1.get(k) + "\n");

            } else if (v.equals(FileCondition.KEY_WAS_ADDED)) {
                stringBuilder.append(" +" + k + ": " + map2.get(k) + "\n");
            }


        });
        return  "{   \n" + stringBuilder.toString() + "}";
    }

}
