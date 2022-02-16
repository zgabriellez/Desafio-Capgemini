package Q1;
//import static org.junit.AssertEquals; 
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Q1_Test {
    //pega o conteudo da saida dos prints
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream(); 
    private final PrintStream originalOut = System.out; 
    
    @Before
    public void setUpStreams()
    {
        System.setOut(new PrintStream(outContent));
    }
    @After
    public void restoreStreams()
    {
        System.setOut(originalOut); 
    }

    @Test
    public void test()
    {
        String[] x = {"*", " *\n**", "  *\n **\n***","   *\n  **\n ***\n****"};
        for(int i=0; i<x.length; i++)
        {
            Q1_Java.escada(i+1);
            assertEquals(x[i], outContent.toString());
            outContent.reset();
        }
    }
}
