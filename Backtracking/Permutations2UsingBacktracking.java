/*
 * LC 47. Permutations II
 * https://leetcode.com/problems/permutations-ii/description/
 */

package Backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Permutations2UsingBacktracking {
    public List<List<Integer>> permuteUnique(int[] nums) {
        // converting int[] nums array to ArrayList
        List<Integer> numsList = new ArrayList<>();
        for (int elem : nums) {
            numsList.add(elem);
        }

        List<List<Integer>> list = new ArrayList<>();

        helper(numsList, list, 0);

        return list;
    }

    public void helper(List<Integer> nums, List<List<Integer>> list, int idx) {
        // base condition
        if (idx == nums.size()) {
            list.add(new ArrayList<>(nums));
            return;
        }

        // function body
        HashMap<Integer, Boolean> track = new HashMap<>();

        for (int i = idx; i < nums.size(); i++) {
            // checking if current element of nums been already there, if it is then we will
            // skip current iteration as of to prevent the duplication
            if (track.containsKey(nums.get(i)) && track.get(nums.get(i))) {
                continue;
            }

            // marking curr element true, so further calls with same values will be
            // prevented and duplication of permutations can be prevented
            track.put(nums.get(i), true);

            Collections.swap(nums, idx, i);

            // recursive call
            helper(nums, list, idx + 1);

            // backtracking
            Collections.swap(nums, idx, i);
        }

    }
}
