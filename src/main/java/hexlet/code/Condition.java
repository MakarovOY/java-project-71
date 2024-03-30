package hexlet.code;

import java.util.*;

public class Condition {

    final static int valueOfKeyDoesntChange = 0;
    final static int valueOfKeyWasChanged = 1;
    final static int keyWasDeleted = 2;
    final static int  keyWasAdded = 3;
    public static Map pres(Map map1, Map map2) {



//                map1.forEach((k,v)->{
//               var getC = v.getClass();
//               System.out.println(getC);
//           });
        List<String> keys1= new ArrayList<>();
        map1.forEach((k,v)->keys1.add((String)k));
        Collections.sort(keys1);



        List<String> keys2= new ArrayList<>();
        map2.forEach((k,v)->keys2.add((String)k));


        ///////////////////////

//        ArrayList<String> allKeys= new ArrayList<>();
//        map1.forEach((k,v)->{
//            if (!allKeys.contains(k)) {
//                allKeys.add((String) k);
//            }
//
//            });
//        map2.forEach((k,v)->{
//            if (!allKeys.contains(k)) {
//                allKeys.add((String) k);
//            }
//
//        });
//        Collections.sort(allKeys);


       LinkedHashMap resultMap = new LinkedHashMap();
//
//        allKeys.stream().forEach(e-> {
//           resultMap.put(e, getChangeInfo(map1,map2,e));
//        });







//       String[] keys1 = new String[map1.size()];
//       String[] keys2 = new String[map2.size()];




       // map2.size();

return resultMap;

    }
    public static int getChangeInfo(Map map1, Map map2, String key){

       int changeInfo =0 ;
//        if(map1.get(key)==null  ){
//            map1.put(key,"null");
//        }
//        if(map2.get(key)==null ){
//            map2.put(key,"null");
//        }
        if (map1.containsKey(key) && map2.containsKey(key)){

            changeInfo= (map1.get(key).equals(map2.get(key)))? 0: 1;

        }
        if(map1.containsKey(key) && !map2.containsKey(key)){
            changeInfo= 2;

        }
                if(!map1.containsKey(key) && map2.containsKey(key)){
                    changeInfo =  3;

        }


        return  changeInfo;
//
//        if (map1.containsKey(key) && map2.containsKey(key)) {
//            differ = (map1.get(key).equals(map2.get(key)))?
//                    "" + differ + map1.get(key) + "\n_" : differ + map1.get(key) + "\n" + "+" +differ + map2.get(key)+ "\n_-";
//        }
//        if(map1.containsKey(key) && !map2.containsKey(key)){
//            differ =  differ + map1.get(key)+ "\n_-";
//
//        }
//        if(!map1.containsKey(key) && map2.containsKey(key)){
//            differ =  differ + map2.get(key) + "\n_+";
//
//        }

    }
}

