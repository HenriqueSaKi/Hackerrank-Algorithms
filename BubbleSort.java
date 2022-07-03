import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'miniMaxSum' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void miniMaxSum(List<Integer> arr) {
        //Long value because the output can be greater than 32 bit integer.
        long min = 0;
        long max = 0;
        List<Integer> auxList = new ArrayList<Integer>();
        
        //BubbleSort Algorithm
        for(int i = 0; i < arr.size(); i++){
            int aux = 0;
            //Compare current 'i' with all next indexes
            for (int j = i + 1; j < arr.size(); j++){
                if(arr.get(j) < arr.get(i)){
                    aux = arr.get(j);
                    arr.set(j, arr.get(i));
                    arr.set(i, aux);
                }
            }
            auxList.add(arr.get(i));
        }
        
        //Min value
        for (int i = 0; i < auxList.size() - 1; i++){
            min = min + auxList.get(i);
        }
        
        //Max value
        for(int i = auxList.size() - 1; i > 0; i--){
            max = max + auxList.get(i);
        }
    
        //Output
        System.out.print(min + " " + max);

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        Result.miniMaxSum(arr);

        bufferedReader.close();
    }
}
