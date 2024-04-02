package hexlet.code;

import java.util.*;

public class FileCondition {

    final static int VALUE_OF_KEY_DOESNT_CHANGE = 0;
    final static int VALUE_OF_KEY_WAS_CHANGED = 1;
    final static int KEY_WAS_DELETED = 2;
    final static int KEY_WAS_ADDED = 3;



    public static int getChangeIndex(Map map1, Map map2, String key) {

        int changeIndex = 0;

        checkAndReplaceNullValue(map1, key);
        checkAndReplaceNullValue(map2, key);

        if (map1.containsKey(key) && map2.containsKey(key)) {

            changeIndex = (map1.get(key).equals(map2.get(key))) ? 0 : 1;

        }
        if (map1.containsKey(key) && !map2.containsKey(key)) {
            changeIndex = 2;

        }
        if (!map1.containsKey(key) && map2.containsKey(key)) {
            changeIndex =  3;

        }


        return  changeIndex;

    }
    public static void checkAndReplaceNullValue(Map map, String key) {
        if (map.get(key) == null) {
            map.replace(key, "null");
        }

    }
}

