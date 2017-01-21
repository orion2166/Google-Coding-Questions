import org.junit.Assert;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.PriorityQueue;

import static org.junit.Assert.*;

/**
 * Created by orion2166 on 1/16/2017.
 */
public class StoreCreditTest {
    @org.junit.Before
    public void setUp() throws Exception {

    }
    PriorityQueue<String> Credit_info = new PriorityQueue<String>();
    int[] value1,value2;
    @Test
    public void testAueueFileandConvertString() throws Exception {
        PriorityQueue<String> Credit_info = new PriorityQueue<String>();
        try {
            BufferedReader reader = new BufferedReader (new FileReader ("C:\\Users\\orion2166\\Documents\\GitHub\\Google-Coding-Questions\\GoogleCodeChallenge\\src\\A-small-practice.in"));
            String line;
            while ((line = reader.readLine ()) != null) {
                Credit_info.add (line);
            }
            reader.close ();
        } catch (Exception e) {
            System.err.format ("Exception occurred trying to read '%s'.", "A-small-practice.in");
            e.printStackTrace ();
            Assert.fail ();
            return;
        }
        assertEquals(Credit_info.size (), 31);

        value1 = new int[Integer.parseInt(Credit_info.peek())];
        value2 = new int[Integer.parseInt(Credit_info.poll())];
        assertEquals(value1.length, 10);
        assertEquals(11, 10);
        assertEquals(value2.length, 10);
    }
  //  @Test
   // public void testParseList(String value)

}