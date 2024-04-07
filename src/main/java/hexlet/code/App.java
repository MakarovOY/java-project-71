package hexlet.code;

import picocli.CommandLine;
//import picocli.CommandLine.Command;
//import picocli.CommandLine.Option;
//import picocli.CommandLine.Parameters;

import java.io.File;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.util.Scanner;
import java.util.concurrent.Callable;

@CommandLine.Command (name = "gendiff", version =  "gendiff 1.00", description = "Compares two configuration"
        + " files and shows a difference.")
public class App implements Callable {


//    private static boolean follow;
    @CommandLine.Parameters(paramLabel = "filepath1", description = "path to first file")
    private String filepath1;
    @CommandLine.Parameters(paramLabel = "filepath2", description = "path to second file")
    private String filepath2;

    @CommandLine.Option(names = {"-h", "--help"}, usageHelp = true, description = "Show this help message and exit.")
    boolean help;
    @CommandLine.Option(names = {"V", "--version"}, description = "Print version information and exit.")
    boolean version;

    @CommandLine.Option(names = {"-f", "--format"}, defaultValue = "stylish",
            paramLabel = "format", description = "output format [default: ${DEFAULT-VALUE}]")
    File file;

    public static void main(String[] args) throws Exception  {


        App app = new App();


//    int something = new CommandLine(app).execute("C:\\Users\\PC SAN\\IdeaProjects\\java-project-71\\app\\file3.json",
//                "C:\\Users\\PC SAN\\IdeaProjects\\java-project-71\\app\\file4.json");

        app.call();
      //  var str = Differ.generate("C:\\Users\\PC SAN\\IdeaProjects\\java-project-71\\app\\file1.json",
        //  "C:\\Users\\PC SAN\\IdeaProjects\\java-project-71\\app\\file2.json");


    }
    @Override
    public Integer call() throws Exception {
        System.out.println(Differ.generate("C:\\Users\\PC SAN\\IdeaProjects\\java-project-71\\app\\file3.json",
                "C:\\Users\\PC SAN\\IdeaProjects\\java-project-71\\app\\file4.json", "Json"));
        return 1;
    }

}
