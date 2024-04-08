package hexlet.code;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DifferTest {


    @Test
    public void testDifferJSON() throws Exception {

        String expected =
                "{\n -follow: false\n  host: hexlet.io\n -proxy:"
                        + " 123.234.53.22\n -timeout: 50\n +timeout: 20\n +verbose: true\n}";
        String actual =
                Differ.generate("file1.json", "file2.json");
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void testDifferYAML() throws Exception {

        String expected =
                "{\n -follow: false\n  host: hexlet.io\n -proxy: 123.234.53.22\n"
                        + " -timeout: 50\n +timeout: 20\n +verbose: true\n}";
        String actual =
                Differ.generate("file1.yml", "file2.yml");
        Assertions.assertEquals(expected, actual);
    }
}
