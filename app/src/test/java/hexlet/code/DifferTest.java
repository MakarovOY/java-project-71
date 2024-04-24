package hexlet.code;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DifferTest {

    String resultStringForTest;
    String resultStringFonTestPlain;


    @BeforeEach
    public void createStringForTestStylish() {
        resultStringForTest =
                "{ \n +chars: [a, b, c, d]\n  key1: Some text\n -key3: null\n"
                        + " -numbers1: [1, 2, 3, 4]\n +numbers1: [1, 2]\n +numbers2: [3, 4, 5]\n -setting: true\n}";
    }
    @BeforeEach
    public void createStringForTestPlain() {
        resultStringFonTestPlain =
                "Property 'chars' was added with value: [complex value]\nProperty 'key3' was removed\n"
                        + "Property 'numbers1' was updated. From [complex value] to [complex value]\n"
                        + "Property 'numbers2' was added with value: [complex value]\nProperty 'setting' was removed";
    }


    @Test
    public void testDifferJSONStylish() throws Exception {


        String actual = Differ.generate("file7.json", "file8.json");
        Assertions.assertEquals(resultStringForTest, actual);

    }

    @Test
    public void testDifferYAMLStylish() throws Exception {

        String  expected =
                "{\n -follow: false\n"
                        + "  host: hexlet.io\n -proxy: 123.234.53.22\n -timeout: 50\n +timeout: 20\n +verbose: true\n}";


        String actual =
                Differ.generate("src/test/resources/file7.yml", "src/test/resources/file8.yml");
        Assertions.assertEquals(resultStringForTest, actual);
    }
    @Test
    public void testDifferFormatPlain() throws Exception {
        String actual = Differ.generate("file7.json", "file8.json", "plain");
        Assertions.assertEquals(resultStringFonTestPlain, actual);
    }
    @Test
    public void testDifferJsonFormat() throws Exception {
        String expected = "{\"valueOfKeyDoesntChange\":{\"key1\":\"Some text\"},\"valueOfKeyWasChanged\""
                + ":{\"numbers1\":\"[1, 2, 3, 4] before, [1, 2] after\"},\"keyWasDeleted\":{\"key3\":\"null\","
                + "\"setting\":true},\"keyWasAdded\":{\"numbers2\":[3,4,5],\"chars\":[\"a\",\"b\",\"c\",\"d\"]}}";
        String actual = Differ.generate("file7.json", "file8.json", "json");

        Assertions.assertEquals(expected, actual);
    }
}
