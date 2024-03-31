package hexlet.code;

import java.util.*;

public class FileCondition {

    final static int valueOfKeyDoesntChange = 0;
    final static int valueOfKeyWasChanged = 1;
    final static int keyWasDeleted = 2;
    final static int  keyWasAdded = 3;

//    public static Map innerCondition (Map map1, Map map2) {
//
//
//        List<String> keys1= new ArrayList<>();
//        map1.forEach((k,v)->keys1.add((String)k));
//        Collections.sort(keys1);
//
//        List<String> keys2= new ArrayList<>();
//        map2.forEach((k,v)->keys2.add((String)k));
//
//
//
//       LinkedHashMap resultMap = new LinkedHashMap();
//
//
//
//return resultMap;
//
//    }

    public static int getChangeIndex(Map map1, Map map2, String key){

       int changeIndex =0 ;
        if(map1.get(key)==null  ){
            map1.replace(key,"null");
        }
        if(map2.get(key)==null ){
            map2.replace(key,"null");
        }

        if (map1.containsKey(key) && map2.containsKey(key)){

            changeIndex= (map1.get(key).equals(map2.get(key)))? 0: 1;

        }
        if(map1.containsKey(key) && !map2.containsKey(key)){
            changeIndex= 2;

        }
                if(!map1.containsKey(key) && map2.containsKey(key)){
                    changeIndex =  3;

        }


        return  changeIndex;

    }
}

