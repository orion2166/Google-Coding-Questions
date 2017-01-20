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

    @Test
    public void testAueueFileandConvertString() throws Exception {
        PriorityQueue<String> Credit_info = new PriorityQueue<String>();
        try {
            BufferedReader reader = new BufferedReader (new FileReader ("C:\\Users\\orion2166\\Documents\\GitHub\\GoogleCodeChallenge\\src\\A-small-practice.in"));
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
    }
    @Test
    public 


}