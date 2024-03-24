package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.concurrent.Callable;


public class App {
  //  @Option(names = {"-h", "--help"}, description = "Show this help message and exit.")
   // boolean help;
    public static void main(String[] args) throws Exception  {




      //  Scanner scanner = new Scanner(System.in);
      //  if(scanner.next().equals("-h")){
       // new CommandLine(new HelloCommand()).execute("-h");}
//        Path writeFilePath1 = Paths.get("C:\\Users\\PC SAN\\IdeaProjects\\java-project-71\\app\\file1.json");
//        try {
//            Path createdFilePath = Files.createFile(writeFilePath1);
//            System.out.println("Файл создан: " + createdFilePath);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        Path writeFilePath2 = Paths.get("C:\\Users\\PC SAN\\IdeaProjects\\java-project-71\\app\\file2.json");
//        try {
//            Path createdFilePath = Files.createFile(writeFilePath2);
//            System.out.println("Файл создан: " + createdFilePath);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        int something = new CommandLine(new Differ() ).execute("-h");
      //  System.exit(something);

        var str = Differ.generate("C:\\Users\\PC SAN\\IdeaProjects\\java-project-71\\app\\file1.json","C:\\Users\\PC SAN\\IdeaProjects\\java-project-71\\app\\file2.json");


    }


}
