package hexlet.code;


import java.util.LinkedHashMap;
import java.util.Map;

public class FileCondition {

    public static final String VALUE_OF_KEY_DOESNT_CHANGE = "VALUE_OF_KEY_DOESNT_CHANGE";
    public static final String VALUE_OF_KEY_WAS_CHANGED = "VALUE_OF_KEY_WAS_CHANGED";
    public static final String KEY_WAS_DELETED = "KEY_WAS_DELETED";
    public static final String KEY_WAS_ADDED = "KEY_WAS_ADDED";

    public static final  String KEY_CHANGE_STATUS = "keyChangeStatus";
    public static final String KEY_PREVIOUS_VALUE = "keyPreviousValue";
    public static final String KEY_ACTUAL_VALUE = "KeyActualValue";




    public static String getChangeIndex(Map map1, Map map2, String key) {


        String changeIndex = VALUE_OF_KEY_DOESNT_CHANGE;

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


    public static LinkedHashMap getKeyInfo(LinkedHashMap<String, String> resultMap, Map map1, Map map2) {

        LinkedHashMap<String, Object> keysInfoMap = new LinkedHashMap();

        resultMap.forEach((k, v) -> {
            switch (v) {

                case FileCondition.VALUE_OF_KEY_DOESNT_CHANGE :

                    Map<String, Object> keyDoesntChanged = new LinkedHashMap<>();
                    keyDoesntChanged.put(KEY_CHANGE_STATUS, VALUE_OF_KEY_DOESNT_CHANGE);
                    keyDoesntChanged.put(KEY_PREVIOUS_VALUE, map1.get(k));
                    keyDoesntChanged.put(KEY_ACTUAL_VALUE, map1.get(k));
                    keysInfoMap.put(k, keyDoesntChanged);

                    break;


                case FileCondition.VALUE_OF_KEY_WAS_CHANGED:
                    Map<String, Object> keyWasChanged = new LinkedHashMap<>();
                    keyWasChanged.put(KEY_CHANGE_STATUS, VALUE_OF_KEY_WAS_CHANGED);
                    keyWasChanged.put(KEY_PREVIOUS_VALUE, map1.get(k));
                    keyWasChanged.put(KEY_ACTUAL_VALUE, map2.get(k));
                    keysInfoMap.put(k, keyWasChanged);

                    break;
                case FileCondition.KEY_WAS_DELETED:
                    Map<String, Object> keyWasDeleted = new LinkedHashMap<>();
                    keyWasDeleted.put(KEY_CHANGE_STATUS, KEY_WAS_DELETED);
                    keyWasDeleted.put(KEY_PREVIOUS_VALUE, map1.get(k));
                    keyWasDeleted.put(KEY_ACTUAL_VALUE, "null");
                    keysInfoMap.put(k, keyWasDeleted);

                    break;
                case FileCondition.KEY_WAS_ADDED:
                    Map<String, Object> keyWasAdded = new LinkedHashMap<>();
                    keyWasAdded.put(KEY_CHANGE_STATUS, KEY_WAS_ADDED);
                    keyWasAdded.put(KEY_PREVIOUS_VALUE, "null");
                    keyWasAdded.put(KEY_ACTUAL_VALUE, map2.get(k));
                    keysInfoMap.put(k, keyWasAdded);

                    break;
                default:
                    break;
            }
        });

        return keysInfoMap;

    }


    public static void checkAndReplaceNullValue(Map map, String key) {
        if (map.get(key) == null) {
            map.replace(key, "null");
        }
    }
}

