package hexlet.code.formatters.Json;


import java.util.HashMap;
import java.util.Map;
import hexlet.code.FileCondition;
import hexlet.code.Parser;

public class JsonFormat {

    public static String formatJson(Map resultMap, Map map1, Map map2)  throws Exception {


        Map valueOfKeyDoesntChange = new HashMap<>();
        Map valueOfKeyWasChanged = new HashMap<>();
        Map keyWasDeleted = new HashMap<>();
        Map keyWasAdded = new HashMap<>();



        resultMap.forEach((k, v) -> {
            switch ((int) v) {

                case FileCondition.VALUE_OF_KEY_DOESNT_CHANGE :
                    valueOfKeyDoesntChange.put(k, map1.get(k));
                    break;
                case FileCondition.VALUE_OF_KEY_WAS_CHANGED:
                    valueOfKeyWasChanged
                            .put(k, map1.get(k).toString() + " before, " + map2.get(k).toString() + " after");
                    break;
                case FileCondition.KEY_WAS_DELETED:
                    keyWasDeleted.put(k, map1.get(k));
                    break;
                case FileCondition.KEY_WAS_ADDED:
                    keyWasAdded.put(k, map2.get(k));
                    break;
                default:
                    break;
            }
        });
        Map mapToParseInJsonObject = new HashMap<>();


        putValue("valueOfKeyDoesntChange", mapToParseInJsonObject, valueOfKeyDoesntChange);
        putValue("valueOfKeyWasChanged", mapToParseInJsonObject, valueOfKeyWasChanged);
        putValue("keyWasDeleted", mapToParseInJsonObject, keyWasDeleted);
        putValue("keyWasAdded", mapToParseInJsonObject, keyWasAdded);


        return Parser.parseToJsonAsString(mapToParseInJsonObject);
    }
    public static void putValue(String key, Map mapJson, Map mapValue) {
        if (mapValue.size() != 0) {
            mapJson.put(key, mapValue);
        }
    }

}
