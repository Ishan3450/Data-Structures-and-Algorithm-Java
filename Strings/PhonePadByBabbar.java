/*
 * LeetCode and GFG Medium Question
 * 
 * Time Complexity: O(4^N)
 * - where 4 stands for the longest string from the pad array which is "pqrs" raise to the total input length of the string
 * 
 * SC: O(4^N)
 *  - SC is O(4^N) because storing all the 4^N strings in the list at worst case, that's why.
 */

package Strings;

import java.util.ArrayList;
import java.util.List;

public class PhonePadByBabbar {
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
    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return new ArrayList<>();
        }
        String[] combinations = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
        List<String> ans = new ArrayList<>();
        helper(digits, combinations, ans, 0, new StringBuilder(""));
        return ans;
    }

    public void helper(String digits, String[] combinations, List<String> ans, int idx, StringBuilder processed) {
        // base condition
        if (idx == digits.length()) {
            ans.add(new String(processed));
            return;
        }

        // function body
        int currDigit = digits.charAt(idx) - '0';
        String mappedString = combinations[currDigit];

        for (int i = 0; i < mappedString.length(); i++) {
            processed.append(mappedString.charAt(i));
            helper(digits, combinations, ans, idx + 1, processed);
            processed.deleteCharAt(processed.length() - 1);
        }
    }
}
