package hexlet.code;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DifferTest {

    private String resultStringForTest;
    private String resultStringFonTestPlain;


    @BeforeEach
    public void createStringForTestStylish() {
        resultStringForTest =
                "{\n  + chars: [a, b, c, d]\n    key1: Some text\n  - key3: null\n"
                        + "  - numbers1: [1, 2, 3, 4]\n  "
                        + "+ numbers1: [1, 2]\n  + numbers2: [3, 4, 5]\n  - setting: true\n}";
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


        String actual = Differ.generate("src/test/resources/fixtures/file7.json",
                "src/test/resources/fixtures/file8.json");
        Assertions.assertEquals(resultStringForTest, actual);

    }

    @Test
    public void testDifferYAMLStylish() throws Exception {

        String  expected =
                "{\n -follow: false\n"
                        + "  host: hexlet.io\n -proxy: 123.234.53.22\n -timeout: 50\n +timeout: 20\n +verbose: true\n}";


        String actual =
                Differ.generate("src/test/resources/fixtures/file7.yml", "src/test/resources/fixtures/file8.yml");
        Assertions.assertEquals(resultStringForTest, actual);
    }
    @Test
    public void testDifferFormatPlain() throws Exception {
        String actual = Differ.generate("src/test/resources/fixtures/file7.json",
                "src/test/resources/fixtures/file8.json", "plain");
        Assertions.assertEquals(resultStringFonTestPlain, actual);
    }
    @Test
    public void testDifferJsonFormat() throws Exception {
        String expected =
                "{\"chars\":{\"keyChangeStatus\":\"KEY_WAS_ADDED\",\"keyPreviousValue\":\"null\","
                        + "\"KeyActualValue\":[\"a\",\"b\",\"c\",\"d\"]},\"key1\":{\"keyChangeStatus\":"
                        + "\"VALUE_OF_KEY_DOESNT_CHANGE\",\"keyPreviousValue\":\"Some text\",\"KeyActualValue\""
                        + ":\"Some text\"},\"key3\":{\"keyChangeStatus\":\"KEY_WAS_DELETED\",\"keyPreviousValue\""
                        + ":\"null\",\"KeyActualValue\":\"null\"},\"numbers1\":{\"keyChangeStatus\""
                        + ":\"VALUE_OF_KEY_WAS_CHANGED\",\"keyPreviousValue\":[1,2,3,4],\"KeyActualValue\""
                        + ":[1,2]},\"numbers2\":{\"keyChangeStatus\":\"KEY_WAS_ADDED\",\"keyPreviousValue\":\""
                        + "null\",\"KeyActualValue\":[3,4,5]},\"setting\":{\"keyChangeStatus\":\"KEY_WAS_DELETED\""
                        + ",\"keyPreviousValue\":true,\"KeyActualValue\":\"null\"}}";
        String actual = Differ.generate("src/test/resources/fixtures/file7.json",
                "src/test/resources/fixtures/file8.json", "json");

        Assertions.assertEquals(expected, actual);
    }
}
