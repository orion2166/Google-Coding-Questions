import org.junit.Assert;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Vector;

import static org.junit.Assert.*;

/**
 * Created by orion2166 on 1/16/2017.
 */
public class StoreCreditTest {
    @org.junit.Before
    public void setUp() throws Exception {

    }
    Vector<String> Credit_info = new Vector<>();
    int[] value1,value2;
    @Test
    public void testAueueFileandConvertString() throws Exception {
        try {
            BufferedReader reader = new BufferedReader (new FileReader ("C:\\Users\\orion_000\\Documents\\GitHub\\Google-Coding-Questions\\GoogleCodeChallenge\\src\\A-small-practice.in"));
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

        value1 = new int[Integer.parseInt(Credit_info.firstElement())];
        value2 = new int[Integer.parseInt(Credit_info.firstElement())];
        assertEquals(value1.length, 10);
        assertEquals(value2.length, 10);
        Credit_info.remove(0);
        int location = 0;
        while(!Credit_info.isEmpty()){
            int Store_Credit = Integer.parseInt(Credit_info.firstElement());
            Credit_info.remove(0);
            int Number_Of_Items = Integer.parseInt(Credit_info.firstElement());
            Credit_info.remove(0);
            char[] convert_list = Credit_info.firstElement().toCharArray();
            Credit_info.remove(0);
            Vector<Integer> List = new Vector<>();
            String integer_value = "";
            for(int i = 0;i < convert_list.length;i++){
                if((int)convert_list[i] != 32)
                    integer_value += convert_list[i];
                else {
                    List.add(Integer.parseInt(integer_value));
                    integer_value = "";
                }
            }
            List.add(Integer.parseInt(integer_value));
            merge_sort_vector(List);
            boolean finished = false;
            for(int i = Number_Of_Items-1;i > 0 && finished == false;i--){
                if(Store_Credit - List.get(i) > 0){
                    int first = Store_Credit-List.get(i);
                    for(int j = i - 1;j > 0;j--){
                        if(first-List.get(j) == 0){
                            value1[location] = List.get(i);
                            value2[location] = List.get(j);
                            location += 1;
                            finished = true;
                            break;
                        }
                    }
                }
            }


        }
    }
    @Test
    public void textParseList(){

        Vector<Integer> vector = new Vector<Integer>(Arrays.asList(new Integer[]{150,24,79,50,88,345,3,400}));
        merge_sort_vector(vector);
        assertEquals(vector.toArray(), new Integer[]{3,24,50,79,88,150,345,400});

    }
    public void merge_sort_vector(Vector list_value){
        int n = list_value.size() - 1;
        for(int i = n/2;i >= 0;i--){
            sink(list_value,i,n);
        }
        for(int i = 1; i <= n;i++){
            swap_vector(list_value,0,n-i+1);
            sink(list_value,0, n-i);
        }
    }
    public void sink(Vector list_value,int i, int n){
        int lc = 2*i;
        if(lc > n)
            return;
        int rc = lc+1;
        int mc = (rc > n) ? lc : ((int)list_value.get(lc) > (int)list_value.get(rc)) ? lc : rc;
        if ((int)list_value.get(i) >= (int)list_value.get(mc))
            return;
        swap_vector(list_value,i,mc);
        sink(list_value,mc,n);
    }

    public void swap_vector(Vector list_value, int i, int mc) {
        int value1 = (int) list_value.get(i);
        list_value.set(i,(int)list_value.get(mc));
        list_value.set(mc,value1);
    }

}