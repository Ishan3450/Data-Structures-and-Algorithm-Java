/*
 * TC: O(2^N)
 * SC: O(N)
 */

package RecursionQuestions.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }
    
    public static List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        helper(ans, "", n, n);
        return ans;
    }

    public static void helper(List<String> ans, String s, int openingBrackets, int closingBrackets){
        // base condition
        if(openingBrackets == 0 && closingBrackets == 0){
            ans.add(s);
            return;
        }

        // function body
        if(openingBrackets > 0){
            helper(ans, s + '(', openingBrackets - 1, closingBrackets);
            // no backtracking needed as s will have the same value because we are not adding it we are just adding the bracket and passing it to the next function call
        }

        if(openingBrackets < closingBrackets){
            helper(ans, s + ')', openingBrackets, closingBrackets - 1);
            // no backtracking needed as s will have the same value because we are not adding it we are just adding the bracket and passing it to the next function call
        }
    }
}
