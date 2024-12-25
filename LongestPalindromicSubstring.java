/*
 * LC: 5 Medium https://leetcode.com/problems/longest-palindromic-substring/
 * GFG: https://practice.geeksforgeeks.org/problems/longest-palindrome-in-a-string3411/1
 * 
 * TC: O(N^2) 
 *  - Loop in the longestPalindrome() method runs for the length of the string so N times.
 *  - Loop in the expandAroundIndex() method runs atmost in the worst case N times for the full given string.
 * SC: O(1)
 *  - No auxilary space declared.
 */

public class LongestPalindromicSubstring {
    static String longestPalin(String S){
        // code here
        String ans = "";
        
        for(int center = 0; center < S.length(); center ++){
            // even size substring
            ans = expandAroundIndex(S, center-1, center, ans);
            
            // odd size substring
            ans = expandAroundIndex(S, center, center, ans);
        }
        
        return ans;
    }
    
    public static String expandAroundIndex(String given, int start, int end, String ans){
        while(start >= 0 && end < given.length() && given.charAt(start) == given.charAt(end)){
            // if we found any substring greater than the curr ans substring which is palindrome we will update it
            ans = ((end-start) + 1) > ans.length() ? given.substring(start, end+1) : ans;
            start --;
            end ++;
        }
        
        return ans;
    }
}
