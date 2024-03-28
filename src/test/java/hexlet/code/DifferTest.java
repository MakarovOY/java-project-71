package hexlet.code;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class DifferTest {


   @Test
   public void testDifferJSON () throws Exception {

   String expected =  "{ \n-follow : false\n host : hexlet.io\n-proxy : 123.234.53.22\n-timeout : 50\n+timeout : 20\n+verbose : true\n}";
   String actual = Differ.generate("C:\\Users\\PC SAN\\IdeaProjects\\java-project-71\\app\\src\\test\\resources\\file1.json",
           "C:\\Users\\PC SAN\\IdeaProjects\\java-project-71\\app\\src\\test\\resources\\file2.json");
      assertEquals(expected,actual);

}
}