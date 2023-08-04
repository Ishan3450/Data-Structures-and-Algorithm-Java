/*
 * LC: 39 https://leetcode.com/problems/combination-sum/description/
 * TC: O(N^target)
 * SC: O(N)
 */
package RecursionQuestions.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();

        helper(ans, new ArrayList<>(), candidates, target, 0);

        return ans;
    }

    public void helper(List<List<Integer>> ans, List<Integer> list, int[] candidates, int target, int idx){
        // base condition
        if(target == 0){
            ans.add(new ArrayList<>(list));
            return;
        }

        if(target < 0){
            return;
        }

        // function body
        for(int i=idx; i < candidates.length; i++){
            list.add(candidates[i]);

            // recursive call
            helper(ans, list, candidates, target-candidates[i], i);

            // backtracking
            list.remove(list.size()-1);
        }
    }
}
