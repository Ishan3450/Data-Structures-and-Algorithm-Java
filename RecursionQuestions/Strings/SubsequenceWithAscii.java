/*
 * Approach:
 * 
 * - Take the unprocessed string
 * - now we have to make 3 recursion calls:
 * - 1. is to take the character
 * - 2. is to take the ascii value of that character
 * - 3. and the last one is to ignore that character
 * - outcomes will be the subsequences with ascii values
 * - suppose for example:
 *  String is abc
 *  output: ab99 -> 99 is the ascii of c
 *          a98c -> 98 is the ascii of b
 *          a9899 -> 98 for b and 99 for c
 *          likewise....
 */

package RecursionQuestions.Strings;

import java.util.ArrayList;

public class SubsequenceWithAscii {
    public static void main(String[] args){
        String str = "abc"; // outputs will be 27 (3*3*3)
        
        subSeqAscii("", str);

        System.out.println(subSeqAsciiReturn("", str));

    }

    static ArrayList<String> subSeqAsciiReturn(String p, String up){
        // base condition
        if(up.isEmpty()){
            ArrayList<String> ans = new ArrayList<>();
            ans.add(p);
            return ans;
        }

        // function body + recrusive call
        char ch = up.charAt(0);

        /*
         * ArrayLists:
         * firstPart - contains the character
         * secondPart - contains the ascii of the character
         * thirdPart - ignores the current character
         */
        ArrayList<String> firstPart = subSeqAsciiReturn(p + ch, up.substring(1));
        ArrayList<String> secondPart = subSeqAsciiReturn(p + (ch + 0), up.substring(1));
        ArrayList<String> thirdPart = subSeqAsciiReturn(p, up.substring(1));

        // adding all the parts into a single arraylist
        firstPart.addAll(secondPart);
        firstPart.addAll(thirdPart);

        // returning firstPart as it contains all the parts
        return firstPart;
    }

    static void subSeqAscii(String processed, String unprocessed){
        // base condition
        if(unprocessed.isEmpty()){
            System.out.println(processed);
            return;
        }

        // function body + recursive call

        char ch = unprocessed.charAt(0); // take the current character

        // take the character
        subSeqAscii(processed + ch, unprocessed.substring(1));

        // take the ascii of the char
        subSeqAscii(processed + (ch+0), unprocessed.substring(1));

        // ignore the character
        subSeqAscii(processed, unprocessed.substring(1));
    }
}
