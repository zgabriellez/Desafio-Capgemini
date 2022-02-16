package Q3;
//import static org.junit.AssertEquals; 
import static org.junit.Assert.*;
import org.junit.Test; 

public class Q3_Test {
    @Test
    public void test()//teste da funcao de calculo de anagrama
    {
        assertEquals(2, Q3_Java.verificaAnag("ovo"));//caso < 6
        assertEquals(2, Q3_Java.verificaAnag("aloca"));
        assertEquals(0, Q3_Java.verificaAnag("a"));
        assertEquals(3, Q3_Java.verificaAnag("ifailuhkqq"));
        assertEquals(4, Q3_Java.verificaAnag("aleatorio")); // [a,a] [0,0], [ale, lea], [ori, rio]
    }
    public void test_fatorial()
    {
        assertEquals(2, Q3_Java.fatorial(2));//caso < 6
        assertEquals(24, Q3_Java.fatorial(4));
        assertEquals(720, Q3_Java.fatorial(6));
        assertEquals(3628800, Q3_Java.fatorial(10));
    }
    public void test_Sort()
    {
        assertEquals("ov", Q3_Java.Sort("ovo"));//caso < 6
        assertEquals("aloc", Q3_Java.Sort("aloca"));
        assertEquals("a", Q3_Java.Sort("a"));
        assertEquals("ifaluhkq", Q3_Java.Sort("ifailuhkqq"));
        assertEquals("aletori", Q3_Java.Sort("aleatorio"));
    }
}
