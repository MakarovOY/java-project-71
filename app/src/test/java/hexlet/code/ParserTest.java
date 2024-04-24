package hexlet.code;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ParserTest {
    Map expected = new HashMap();

    @BeforeEach
            public void createMap() {
        expected.put("host", "hexlet.io");
        expected.put("timeout", 50);
        expected.put("proxy", "123.234.53.22");
        expected.put("follow", false);
    }

    @Test
    public void testParseJSON() throws Exception {

        Map actual =
            Parser.parseToJavaObject("file1.json");

        assertEquals(expected, actual);

    }
    @Test
    public void testParseYAML() throws Exception {

        Map actual =
                Parser.parseToJavaObject("file1.yml");

        assertEquals(expected, actual);
    }

}
