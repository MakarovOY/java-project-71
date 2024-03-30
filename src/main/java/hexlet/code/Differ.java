package hexlet.code;

import java.util.*;


public class Differ {



    public static String generate (String filepath1, String filepath2 ) throws Exception{

        var map1 = Parser.parse(filepath1);
        var map2 = Parser.parse(filepath2);

        ArrayList<String> allKeys= new ArrayList<>(sortAllKeys(map1,map2));
        LinkedHashMap resultMap = new LinkedHashMap();
        allKeys.forEach(e->{


                resultMap.put(e, Condition.getChangeInfo(map1,map2,e));

        });

//        resultMap.forEach((k,v)->{
//            System.out.println(k);
//            System.out.println(v);
//        });





//        List<String> strings = new ArrayList<>();
//
//        map1.forEach((key,value)->{
//
//            strings.add(diff(map1,map2,key,value));
//        });
//        map2.forEach((key,value)->{
//            if(!map1.containsKey(key) && map2.containsKey(key)){
//
//            strings.add(diff(map1,map2,key,value));
//            }
//        });
//        StringBuilder stringBuilder =new StringBuilder();
//        Collections.sort(strings);
//
//        strings.stream()
//
//
//                        .forEach(s ->{
//                    if (s.charAt(s.length()-1) == '+'|| s.charAt(s.length()-1) == '-') {
//                        s = (s.charAt(s.length()-1) + s).substring(0,s.length());
//                    }else {
//                        s= " " + s;
//                    }
//
//                    stringBuilder.append(s);});
//        String diffResult = stringBuilder.toString() ;
//
//
//                    return "{ \n" + diffResult + "}";

//        EntPresent.pres(map1,map2).forEach((k,v)->{
//            System.out.println(k);
//            System.out.println(v);
//        });

        String resStr ="{\n" + format(resultMap,map1,map2) + "}";
        return resStr;
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
            if(v.equals(Condition.valueOfKeyDoesntChange)){
                stringBuilder.append("  " + k + ": " + map1.get(k)+ "\n");
            }
            else if(v.equals(Condition.valueOfKeyWasChanged) )
            {
                stringBuilder.append(" -" + k + ": " + map1.get(k)+ "\n +" + k + ": " + map2.get(k)+ "\n");

            }
            else if (v.equals(Condition.keyWasDeleted)) {
                stringBuilder.append(" -" + k + ": " + map1.get(k)+ "\n");

            }else
            {
              stringBuilder.append(" +" + k + ": " + map2.get(k)+ "\n");
          }


        });
            return stringBuilder.toString();
   }


}
