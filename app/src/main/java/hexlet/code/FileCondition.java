package hexlet.code;



import java.util.Map;

public class FileCondition {

    public static final int VALUE_OF_KEY_DOESNT_CHANGE = 0;
    public static final int VALUE_OF_KEY_WAS_CHANGED = 1;
    public static final int KEY_WAS_DELETED = 2;
    public static final int KEY_WAS_ADDED = 3;



    public static int getChangeIndex(Map map1, Map map2, String key) {

        int changeIndex = VALUE_OF_KEY_DOESNT_CHANGE;

        checkAndReplaceNullValue(map1, key);
        checkAndReplaceNullValue(map2, key);

        if (map1.containsKey(key) && map2.containsKey(key)) {

            changeIndex = (map1.get(key).equals(map2.get(key))) ? VALUE_OF_KEY_DOESNT_CHANGE : VALUE_OF_KEY_WAS_CHANGED;

        }
        if (map1.containsKey(key) && !map2.containsKey(key)) {
            changeIndex = KEY_WAS_DELETED;

        }
        if (!map1.containsKey(key) && map2.containsKey(key)) {
            changeIndex =  KEY_WAS_ADDED;

        }


        return  changeIndex;

    }
    public static void checkAndReplaceNullValue(Map map, String key) {
        if (map.get(key) == null) {
            map.replace(key, "null");
        }

    }
}

