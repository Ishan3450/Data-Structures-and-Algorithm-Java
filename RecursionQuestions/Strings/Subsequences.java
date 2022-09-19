/*
    * Approach:
    * - Take a character from the unprocessed string
    * - then one have to call two recursion calls
    * - in one call one have to add it
    * - and in another call one have to ignore it
    * - at the end we would have the subsequences
*/

package RecursionQuestions.Strings;

import java.util.ArrayList; 

public class Subsequences {
    public static void main(String[] args){
        String str = "abc";

        subseq("", str);

        System.out.println(subseqReturn("", str));
    }

    static ArrayList<String> subseqReturn(String processed, String unprocessed){
        // base condition
        if(unprocessed.isEmpty()){
            ArrayList<String> ans = new ArrayList<>();
            ans.add(processed);
            return ans;
        }

        // function body + recursive condition
        char ch = unprocessed.charAt(0);

        // adding the character
        ArrayList<String> leftPartFromBelowCalls = subseqReturn(processed+ch, unprocessed.substring(1));

        // ignoring the character
        ArrayList<String> rightPartFromBelowCalls = subseqReturn(processed, unprocessed.substring(1));

        // merging both the left and right part
        leftPartFromBelowCalls.addAll(rightPartFromBelowCalls);

        return leftPartFromBelowCalls;
    }

    static void subseq(String processed, String unprocessed){
        // base condition
        if(unprocessed.isEmpty()){
            System.out.println(processed);
            return;
        }

        // function body + recrusive condition

        char ch = unprocessed.charAt(0);
        // add it
        subseq(processed + ch, unprocessed.substring(1));

        // ignore it
        subseq(processed, unprocessed.substring(1));

    }
}
