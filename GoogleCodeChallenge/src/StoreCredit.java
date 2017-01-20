import org.junit.Assert;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

/**
 * Created by orion2166 on 1/16/2017.
 */
public class StoreCredit {
    PriorityQueue<String> Credit_info = new PriorityQueue<String>();
    int[] value1,value2;
    public StoreCredit(String filename){
        try {
            BufferedReader reader = new BufferedReader (new FileReader (filename));
            String line;
            while ((line = reader.readLine ()) != null) {
                Credit_info.add (line);
            }
            reader.close ();
        } catch (Exception e) {
            System.err.format ("Exception occurred trying to read '%s'.", filename);
            e.printStackTrace ();
            return;
        }

        value1 = new int[Integer.parseInt(Credit_info.peek())];
        value2 = new int[Integer.parseInt(Credit_info.poll())];

        while(!Credit_info.isEmpty()){
            int Store_Credit = Integer.parseInt(Credit_info.poll());
            int Number_Of_Items = Integer.parseInt(Credit_info.poll());
            char[] convert_list = Credit_info.poll().toCharArray();
            Vector <Integer> List = new Vector<>();
            String integer_value = "";
            for(int i = 0;i < convert_list.length;i++){
                if(convert_list[i] != ' ')
                    integer_value += convert_list[i];
                else {
                    List.add(Integer.parseInt(integer_value));
                    integer_value = "";
                }
            }
        }
    }
}
