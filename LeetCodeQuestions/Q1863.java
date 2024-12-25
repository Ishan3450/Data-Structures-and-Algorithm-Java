package LeetCodeQuestions;

import java.util.ArrayList;

public class Q1863 {
    // * using include/exclude recursion approach
    public int subsetXORSum(int[] nums) {
        int[] sum = new int[1];
        helper(nums, 0, 0, sum);
        return sum[0];
    }

    public void helper(int[] nums, int idx, int curr, int[] sum) {
        // base condition
        if (idx == nums.length) {
            sum[0] += curr;
            return;
        }

        // function body
        helper(nums, idx + 1, curr ^ nums[idx], sum);
        helper(nums, idx + 1, curr, sum);
    }

    // * using recursion and backtracking appraoch
    public int subsetXORSum2(int[] nums) {
        int[] arr = new int[1];
        helper2(nums, 0, new ArrayList<>(), arr);
        return arr[0];
    }

    public void helper2(int[] nums, int idx, ArrayList<Integer> arr, int[] sum){
        // base condition
        if(idx == nums.length){
            int xorAns = 0;
            for(int elem: arr){
                xorAns ^= elem;
            }
            sum[0] += xorAns;
            return;
        }

        // function body
        arr.add(nums[idx]);
        helper2(nums, idx+1, arr, sum);
        arr.remove(arr.size()-1);
        helper2(nums, idx+1, arr, sum);
    }
}
