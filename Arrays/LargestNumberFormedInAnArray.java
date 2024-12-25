package Arrays;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumberFormedInAnArray {
     String printLargest(int n, String[] arr) {
        Comparator<String> comp = new Comparator<String> () {
            public int compare(String a, String b){
                String s1 = a+b;
                String s2 = b+a;
                return s2.compareTo(s1);
            }
        };
        Arrays.sort(arr, comp);
        
        StringBuilder sb = new StringBuilder();
        for(String s: arr) sb.append(s);
        return sb.toString();
    }
}
