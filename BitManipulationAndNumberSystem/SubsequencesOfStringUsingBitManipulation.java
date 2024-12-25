package BitManipulationAndNumberSystem;

import java.util.ArrayList;
import java.util.Collections;

/*
 * Exponential complexity so this question is just to learn bit manipulation better way is to go with recursion
 */

public class SubsequencesOfStringUsingBitManipulation {
    public static void main(String[] args) {
        String s = "abc";
        subseq(s);
    }

    public static void subseq(String s) {
        int totalAns = 1 << s.length(); // 2^s.length()
        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < totalAns; i++) {
            StringBuilder sb = new StringBuilder();

            for (int j = 0; j < s.length(); j++) {
                // if bit is 1 we will include curr char
                // if bit is 0 we will exclude curr char

                if ((i & (1 << j)) != 0) { // if bit is 0 meaning all bits are 0 else the number will be non zero value
                                           // varies according to set bit position
                    sb.append(s.charAt(j));
                }
            }

            list.add(sb.toString());
        }

        System.out.println(list);
    }
}
