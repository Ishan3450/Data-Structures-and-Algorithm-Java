/*
 * LeetCode and GFG Medium Question
 * 
 * Time Complexity: O(4^N)
 * - where 4 stands for the longest string from the pad array which is "pqrs" raise to the total input length of the string
 */

package RecursionQuestions.Strings;

import java.util.List;

public class PhonePad2 {
    public static String[] pad = {".", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    
    // public List<String> letterCombinations(String digits) {
        
    // }


    /*
     * Approach:
     * 
     * for 23:
     * 
     * - first 2 will be obtained from the string
     * - then mapped string at index 2 will be stored which is abc
     * - then loop will run for each char of the mappedstring:
     * - For 1st iteration: a then another recursion call be will there
     * - in that mapped string at 3 will be stored which will be def
     * - then with a all the d,e and f will be combined and print
     * - then for 2nd iteration: b and same d,e,f will be printed
     * - at last for c same procedure will be there
     * - at last we will get all the combinations we can make from the given string
     */
    public static void letterCombinations(String digits){
        helper(digits, 0, "");
    }

    public static void helper(String digits, int index, String combination){
        // base condition
        if(index == digits.length()){
            System.out.println(combination);
            return;
        }

        // function body
        char curr = digits.charAt(index);
        String mappedString = pad[curr - '0'];

        for(int i=0; i<mappedString.length(); i++){
            helper(digits, index+1, combination + mappedString.charAt(i));
        }

    }

    public static void main(String[] args){
        String str = "23";

        letterCombinations(str);
    }
}
