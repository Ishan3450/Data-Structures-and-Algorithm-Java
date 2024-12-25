/*
 * The code will be same as subsequences but the difference will be : we will be using HashSet to track uniqueness
 */

package Strings;

import java.util.HashSet;

public class UniqueSubsequences {
    static void subseq(String processed, String unprocessed, HashSet<String> set){
        // base condition
        if(unprocessed.isEmpty()){
            if(!set.contains(processed)){
                System.out.println(processed);
                set.add(processed);
            }
            return;
        }

        // function body + recrusive condition        
        char ch = unprocessed.charAt(0);
        // add it
        subseq(processed + ch, unprocessed.substring(1), set);

        // ignore it
        subseq(processed, unprocessed.substring(1), set);

    }

    public static void main(String[] args){
        HashSet<String> set = new HashSet<>();
        String str = "aaa";

        subseq("", str, set);
    }
}
