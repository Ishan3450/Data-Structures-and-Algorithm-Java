/*
 * Lc: 40. Combination Sum II 
 * https://leetcode.com/problems/combination-sum-ii/description/
 * 
 * TC: O(N!)
 * SC: O(N)
 */

package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {
     public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();

        helper(ans, candidates, new ArrayList<>(), target, 0);

        return ans;
    }

    public void helper(List<List<Integer>> ans, int[] candidates, List<Integer> list, int target, int idx){
        // base condition
        if(target == 0){
            ans.add(new ArrayList<>(list));
            return;
        }

        if(target < 0){
            return;
        }

        // function body
        for(int i = idx; i < candidates.length; i++){
            // below condition prevents the duplication of list values as it will prevent same type of values to be called again and again
            if(i != idx && candidates[i] == candidates[i-1]){
                continue;
            }
            // below condition is just small optimization
            if(candidates[i] > target){
                break;
            }

            list.add(candidates[i]);

            // recursive call
            helper(ans, candidates, list, target - candidates[i], i+1);

            // backtracking
            list.remove(list.size()-1);
        }
    }
}
