package Q2;
//import static org.junit.AssertEquals; 
import static org.junit.Assert.*;
import org.junit.Test; 

public class Q2_Java_Test {
    @Test
    public void test()
    {
        assertEquals(3, Q2_Java.verifica("Ya3"));//caso < 6
        assertEquals(4, Q2_Java.verifica("aB"));
        assertEquals(5, Q2_Java.verifica("a"));
        assertEquals(0, Q2_Java.verifica("Ya3&bb"));
        assertEquals(3, Q2_Java.verifica("111111"));
        assertEquals(3, Q2_Java.verifica("aaaaaa"));
        assertEquals(3, Q2_Java.verifica("AAAAAA"));
        assertEquals(3, Q2_Java.verifica("&&&&&&"));
    }
}
