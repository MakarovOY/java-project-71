package hexlet.code;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


class DifferTest {


    public static String readFile(String filePath) throws Exception {

        Path path = Paths.get(filePath).toAbsolutePath();

        return Files.readString(path);
    }



    @Test
    public void testDifferJSONStylish() throws Exception {

        String actual = Differ.generate("src/test/resources/fixtures/Stylish1.json",
                "src/test/resources/fixtures/Stylish2.json");
        String expected = readFile("src/test/resources/fixtures/StringForStylishTest");

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void testDifferYAMLStylish() throws Exception {

        String  expected = readFile("src/test/resources/fixtures/StringForYamlStylishTest");

        String actual =
                Differ.generate("src/test/resources/fixtures/Stylish1.yaml",
                        "src/test/resources/fixtures/Stylish2.yaml");
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void testDifferFormatPlain() throws Exception {
        String expected = readFile("src/test/resources/fixtures/StringForPlainTest");
        String actual = Differ.generate("src/test/resources/fixtures/Plain1.json",
                "src/test/resources/fixtures/Plain2.json", "plain");
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void testDifferJsonFormat() throws Exception {

        String expected = readFile("src/test/resources/fixtures/StringForJsonTest");
        String actual = Differ.generate("src/test/resources/fixtures/file7.json",
                "src/test/resources/fixtures/file8.json", "json");

        Assertions.assertEquals(expected, actual);
    }
}
