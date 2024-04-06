package hexlet.code.formatters.Json;


import java.util.HashMap;
import java.util.Map;
import hexlet.code.FileCondition;
import hexlet.code.Parser;

public class JsonFormat {

    public static String formatJson(Map resultMap, Map map1, Map map2)  throws Exception {

        JsonObject jsonObject = new JsonObject();
        jsonObject.setValueOfKeyDoesntChange(new HashMap());
        jsonObject.setValueOfKeyWasChanged(new HashMap());
        jsonObject.setKeyWasDeleted(new HashMap());
        jsonObject.setKeyWasAdded(new HashMap());


        resultMap.forEach((k, v) -> {

            switch ((int) v) {

                case FileCondition.VALUE_OF_KEY_DOESNT_CHANGE :
                    jsonObject.getValueOfKeyDoesntChange().put(k, map1.get(k));
                    break;
                case FileCondition.VALUE_OF_KEY_WAS_CHANGED:
                    jsonObject.getValueOfKeyWasChanged()
                            .put(k, map1.get(k).toString() + " before, " + map2.get(k).toString() + " after");
                    break;
                case FileCondition.KEY_WAS_DELETED:
                    jsonObject.getKeyWasDeleted().put(k, map1.get(k));
                    break;
                case FileCondition.KEY_WAS_ADDED:
                    jsonObject.getKeyWasAdded().put(k, map2.get(k));
                    break;
                default:
                    break;
            }
        });

        return Parser.parseToJsonAsString(jsonObject);
    }

}
