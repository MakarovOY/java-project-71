package hexlet.code;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ParserTest {
    Parser parser;
    private Map<String, Object> expected = new HashMap();

    @BeforeEach
    public void createMap() {
        expected.put("host", "hexlet.io");
        expected.put("timeout", "50");
        expected.put("proxy", "123.234.53.22");
        expected.put("follow", false);
    }
    @BeforeEach
    public void createParser() {
        parser = new Parser();
    }


    @Test
    public void testParseJSON() throws Exception {

        Map actual = parser.parseToJavaObject("src/test/resources/fixtures/file1.json");

        assertEquals(expected, actual);

    }
    @Test
    public void testParseYAML() throws Exception {

        Map actual = parser.parseToJavaObject("src/test/resources/fixtures/file1.yml");

        assertEquals(expected, actual);
    }

}
