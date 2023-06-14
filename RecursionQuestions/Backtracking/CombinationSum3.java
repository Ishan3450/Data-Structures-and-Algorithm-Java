/*
 * GFG: https://practice.geeksforgeeks.org/problems/combination-sum-iii/1
 */
package RecursionQuestions.Backtracking;

import java.util.ArrayList;

public class CombinationSum3 {
     public static ArrayList<ArrayList<Integer>> combinationSum(int K, int N) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        
        helper(K, N, ans, new ArrayList<>(), 1);

        return ans;
    }
    
    public static void helper(int size, int target, ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> list, int idx){
        // base condition
        if(target == 0 && list.size() == size){
            ans.add(new ArrayList<>(list));
            return;
        }
        
        if(list.size() > size){
            return;
        }
        
        // function body
        for(int i = idx; i <= 9; i++){
            list.add(i);
            
            // recursive call
            helper(size, target - i, ans, list, i+1);
            
            // backtracking
            list.remove(list.size() - 1);
        }
    }
}
