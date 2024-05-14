package hexlet.code;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class FileDiff {

    public static final String VALUE_OF_KEY_DOESNT_CHANGE = "VALUE_OF_KEY_DOESNT_CHANGE";
    public static final String VALUE_OF_KEY_WAS_CHANGED = "VALUE_OF_KEY_WAS_CHANGED";
    public static final String KEY_WAS_DELETED = "KEY_WAS_DELETED";
    public static final String KEY_WAS_ADDED = "KEY_WAS_ADDED";

    public static final  String KEY_CHANGE_STATUS = "keyChangeStatus";
    public static final String KEY_PREVIOUS_VALUE = "keyPreviousValue";
    public static final String KEY_ACTUAL_VALUE = "KeyActualValue";


    public static LinkedHashMap getDiffMap(Map<String, Object> map1, Map<String, Object> map2) {


        List<String> allKeysSorted = new ArrayList<>(sortKeys(map1, map2));


        checkAndReplaceNullValue(map1);
        checkAndReplaceNullValue(map2);

        LinkedHashMap<String, Map> keysInfoMap = new LinkedHashMap();

        for (var k: allKeysSorted) {

            Map<String, Object> keyInfo = new HashMap<>();

            if (map1.containsKey(k) && map2.containsKey(k)) {

                if (map1.get(k).equals(map2.get(k))) {
                    keyInfo.put(KEY_CHANGE_STATUS, VALUE_OF_KEY_DOESNT_CHANGE);
                    keyInfo.put(KEY_PREVIOUS_VALUE, map1.get(k));
                    keyInfo.put(KEY_ACTUAL_VALUE, map1.get(k));
                    keysInfoMap.put(k, keyInfo);
                } else {
                    keyInfo.put(KEY_CHANGE_STATUS, VALUE_OF_KEY_WAS_CHANGED);
                    keyInfo.put(KEY_PREVIOUS_VALUE, map1.get(k));
                    keyInfo.put(KEY_ACTUAL_VALUE, map2.get(k));
                    keysInfoMap.put(k, keyInfo);
                }

            }
            if (map1.containsKey(k) && !map2.containsKey(k)) {
                keyInfo.put(KEY_CHANGE_STATUS, KEY_WAS_DELETED);
                keyInfo.put(KEY_PREVIOUS_VALUE, map1.get(k));
                keyInfo.put(KEY_ACTUAL_VALUE, "null");
                keysInfoMap.put(k, keyInfo);

            }
            if (!map1.containsKey(k) && map2.containsKey(k)) {

                keyInfo.put(KEY_CHANGE_STATUS, KEY_WAS_ADDED);
                keyInfo.put(KEY_PREVIOUS_VALUE, "null");
                keyInfo.put(KEY_ACTUAL_VALUE, map2.get(k));
                keysInfoMap.put(k, keyInfo);

            }

        }

        return  keysInfoMap;
    }

    public static List<String> sortKeys(Map map1, Map map2) {

        return Stream.concat(map1.keySet().stream(), map2.keySet().stream())
                .distinct()
                .sorted()
                .toList();
    }


    public static void checkAndReplaceNullValue(Map map) {
        map.forEach((k, v) -> {

            if (map.get(k) == null) {
                map.replace(k, "null");
            }

        });

    }


}

