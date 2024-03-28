package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import picocli.CommandLine;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

import java.util.stream.Collectors;


public class Differ {



    public static String generate (String filepath1, String filepath2 ) throws Exception{
//        Path path1 = Paths.get(filepath1).toAbsolutePath().normalize();
//        Path path2 = Paths.get(filepath2).toAbsolutePath().normalize();
//
//        String json1 = Files.readString(path1);
//        String json2 = Files.readString(path2);
//
//        ObjectMapper objectMapper1 = new ObjectMapper();
//        ObjectMapper objectMapper2 = new ObjectMapper();
//
//
//        var map1 = objectMapper1.readValue(json1,Map.class);
//        var map2 = objectMapper2.readValue(json2,Map.class);
        var map1 = Parser.parse(filepath1);
        var map2 = Parser.parse(filepath2);


        List<String> strings = new ArrayList<>();

        map1.forEach((key,value)->{

            strings.add(diff(map1,map2,key,value));
        });
        map2.forEach((key,value)->{
            if(!map1.containsKey(key) && map2.containsKey(key)){

            strings.add(diff(map1,map2,key,value));
            }
        });
        StringBuilder stringBuilder =new StringBuilder();
        Collections.sort(strings);

        strings.stream()


                        .forEach(s ->{
                    if (s.charAt(s.length()-1) == '+'|| s.charAt(s.length()-1) == '-') {
                        s = (s.charAt(s.length()-1) + s).substring(0,s.length());
                    }else {
                        s= " " + s;
                    }

                    stringBuilder.append(s);});
        String diffResult = stringBuilder.toString() ;
        String diffResult2 = "{ \n" + diffResult + "}";

                    return "{ \n" + diffResult + "}";
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

}
