/*
 * LeetCode and GFG Medium Question
 * 
 * Time Complexity: O(4^N)
 * - where 4 stands for the longest string from the pad array which is "pqrs" raise to the total input length of the string
 * 
 * SC: O(4^N)
 */

package RecursionQuestions.Strings;

import java.util.ArrayList;
import java.util.List;

public class PhonePad2 {
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
    public static List<String> letterCombinations(String digits) {
        if(digits.isEmpty()){
            return new ArrayList<>();
        }
        List<String> ans = new ArrayList<>();
        String[] map = {"", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        helper(ans, digits, map, 0, new StringBuilder(""));

        return ans;
    }

    public static void helper(List<String> ans, String digits, String[] map, int index, StringBuilder combination){
        // base condition
        if(index == digits.length()){
            ans.add(combination.toString());
            return;
        }

        // function body
        int currDigit = digits.charAt(index) - '0';
        String mapValue = map[currDigit-1];

        for(int i = 0 ; i < mapValue.length(); i++){
            combination.append(mapValue.charAt(i));
            helper(ans, digits, map, index+1, combination);
            combination.deleteCharAt(combination.length()-1);
        }
    }
    public static void main(String[] args){
        String str = "23";

        System.out.println(letterCombinations(str));
    }
}
