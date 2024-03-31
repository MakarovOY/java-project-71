package hexlet.code;

import java.util.*;


public class Differ {



    public static String generate (String filepath1, String filepath2 ) throws Exception{

        var map1 = Parser.parse(filepath1);
        var map2 = Parser.parse(filepath2);

        ArrayList<String> allKeys= new ArrayList<>(sortAllKeys(map1,map2));
        LinkedHashMap resultMap = new LinkedHashMap();
        allKeys.forEach(e->{


                resultMap.put(e, FileCondition.getChangeIndex(map1,map2,e));

        });




        String resaltString ="{\n" + format(resultMap,map1,map2) + "}";
        return resaltString;
    }

    public static <K,T> String diff(Map map1,Map map2, K key, T value) {
        String differ = key + " : ";


        if (map1.containsKey(key) && map2.containsKey(key)) {
           differ = (map1.get(key).equals(map2.get(key)))?
                   "" + differ + map1.get(key) + "\n_" : differ + map1.get(key) + "\n" + "+" +differ + map2.get(key)+ "\n_-";
        }
        if(map1.containsKey(key) && !map2.containsKey(key)){
            differ =  differ + map1.get(key)+ "\n_-";

        }
        if(!map1.containsKey(key) && map2.containsKey(key)){
            differ =  differ + map2.get(key) + "\n_+";

        }

        return differ.replaceAll("_","");
    }

    public static List sortAllKeys(Map map1, Map map2 ){
        ArrayList<String> sortedAllKeys= new ArrayList<>();
        map1.forEach((k,v)->{
            if (!sortedAllKeys.contains(k)) {
                sortedAllKeys.add((String) k);
            }

        });
        map2.forEach((k,v)->{
            if (!sortedAllKeys.contains(k)) {
                sortedAllKeys.add((String) k);
            }

        });
        Collections.sort(sortedAllKeys);


        return sortedAllKeys;
    }
//    public static boolean valueIsObject(Map map, String key){
//       var classOfValue =  map.get(key).getClass();
//       if (!classOfValue.isPrimitive()){
//           return false;
//       }
//       return true;
//    }

   public static String format( Map resultMap, Map map1, Map map2){

       StringBuilder stringBuilder =new StringBuilder();

        resultMap.forEach((k,v)->{
            if(v.equals(FileCondition.valueOfKeyDoesntChange)){
                stringBuilder.append("  " + k + ": " + map1.get(k)+ "\n");
            }
            else if(v.equals(FileCondition.valueOfKeyWasChanged) ) {
                stringBuilder.append(" -" + k + ": " + map1.get(k)+ "\n +" + k + ": " + map2.get(k)+ "\n");

            }
            else if (v.equals(FileCondition.keyWasDeleted)) {
                stringBuilder.append(" -" + k + ": " + map1.get(k)+ "\n");

            }else if(v.equals(FileCondition.keyWasAdded)) {
              stringBuilder.append(" +" + k + ": " + map2.get(k)+ "\n");
            }


        });
            return stringBuilder.toString();
   }


}
