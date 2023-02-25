import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CodeTest {

    @Test
    public void testSayHello(){
        //create new instance of class Code
        Code code = new Code();

        assertEquals("Hello world!", code.sayHello());
        assertEquals(20, code.plusNumber(10, 10));
    }
}
