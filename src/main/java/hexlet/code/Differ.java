package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import picocli.CommandLine;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.stream.Collectors;

@CommandLine.Command (name = "gendiff",version =  "gendiff 1.00", description = "Compares two configuration files and shows a difference.")
public class Differ {

    private static boolean follow;
    @CommandLine.Parameters( paramLabel ="filepath1", description = "path to first file")
  private String filepath1;
  @CommandLine.Parameters( paramLabel ="filepath2", description = "path to second file")
  private String filepath2;

@CommandLine.Option(names = {"-h", "--help"}, usageHelp = true, description = "Show this help message and exit." )
    boolean help;
@CommandLine.Option(names = {"V", "--version"}, description = "Print version information and exit." )
boolean version;

@CommandLine.Option( names = {"-f", "--format"},  paramLabel = "format", description = "output format [default: stylish]")
File file;

//    @Override
//    public  Integer call(){
//
//        return 0;
//    }


    public static String generate (String filepath1, String filepath2 ) throws Exception{
        Path path1 = Paths.get(filepath1).toAbsolutePath().normalize();
        Path path2 = Paths.get(filepath2).toAbsolutePath().normalize();
//        if (!Files.exists(path1)) {
//            throw new Exception("File '" + path1 + "' does not exist");
//        }
        String json1 = Files.readString(path1);
        String json2 = Files.readString(path2);

        ObjectMapper objectMapper1 = new ObjectMapper();
        ObjectMapper objectMapper2 = new ObjectMapper();
//
        InputFile inputFile1 = objectMapper1.readValue(json1, InputFile.class);
        InputFile inputFile2 = objectMapper2.readValue(json2, InputFile.class);


//    String hostDiff = " host: ";
//       if(inputFile1.getHost() != null && inputFile2.getHost() != null){
//           if(inputFile1.getHost().equals(inputFile2.getHost())){
//            hostDiff = hostDiff + inputFile1.getHost();
//              // System.out.println(hostDiff);
//           }else{
//
//           }
//       }
        Map<String, Object> map1 = objectMapper1.readValue(json1, new TypeReference<Map<String,Object>>(){});
        Map<String, Object> map2 = objectMapper1.readValue(json2, new TypeReference<Map<String,Object>>(){});


        List<Map> listOfMaps = new ArrayList<>();
        listOfMaps.add(map1);
        listOfMaps.add(map2);
       var byGroup =  listOfMaps.stream()
                .collect(Collectors.groupingBy(map-> map.keySet()));
        System.out.println(byGroup);






 return "" ;
    }

}
