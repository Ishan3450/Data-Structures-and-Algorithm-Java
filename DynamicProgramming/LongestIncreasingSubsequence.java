package DynamicProgramming;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    /*
     * In this problem we will be adjusting prev value with prev + 1
     * So, when prev is -1 ans will be stored in 0
     * for 0 it will be 1, for 1 it will be 2, so for every ith element answer will
     * be stored in i+1th index
     */

    public int lengthOfLIS(int[] nums) {
        // int[][] dp = new int[nums.length][nums.length];
        // for(int[] row: dp) Arrays.fill(row, -1);

        // return memoization(nums, 0, -1, dp);
        return spaceOptimized(nums);
    }

    // space optimization is possible
    public int spaceOptimized(int[] nums) {
        int[] curr = new int[nums.length + 1];
        int[] next = new int[nums.length + 1];

        for (int currIdx = nums.length - 1; currIdx >= 0; currIdx--) {
            for (int prevIdx = nums.length - 1; prevIdx >= -1; prevIdx--) {

                int include = 0;
                if (prevIdx == -1 || nums[currIdx] > nums[prevIdx]) {
                    // Important: here we are accessing value from dp[currIdx+1][currIdx+1], in the
                    // second bracket we have used currIdx+1 instead of currIdx because of
                    // previously I told that we will be adjusting the value of prev, so ith value
                    // will be at i+1th index that's why currIdx+1 is used
                    include = 1 + next[currIdx + 1];
                }

                // exclude call
                int exclude = next[prevIdx + 1];

                curr[prevIdx + 1] = Math.max(include, exclude);

            }
            // shifting is important :)
            next = Arrays.copyOf(curr, curr.length);
        }
        return curr[0]; // or curr[-1+1];
    }

    // tabulation appraoch
    public int tabulation(int[] nums) {
        int[][] dp = new int[nums.length + 1][nums.length + 1];

        for (int currIdx = nums.length - 1; currIdx >= 0; currIdx--) {
            for (int prevIdx = nums.length - 1; prevIdx >= -1; prevIdx--) {

                int include = 0;
                if (prevIdx == -1 || nums[currIdx] > nums[prevIdx]) {
                    // Important: here we are accessing value from dp[currIdx+1][currIdx+1], in the
                    // second bracket we have used currIdx+1 instead of currIdx because of
                    // previously I told that we will be adjusting the value of prev, so ith value
                    // will be at i+1th index that's why currIdx+1 is used
                    include = 1 + dp[currIdx + 1][currIdx + 1];
                }

                // exclude call
                int exclude = dp[currIdx + 1][prevIdx + 1];

                dp[currIdx][prevIdx + 1] = Math.max(include, exclude);

            }
        }
        return dp[0][0]; // or dp[0][-1+1];
    }

    // memoization approach
    public int memoization(int[] nums, int currIdx, int prevIdx, int[][] dp) {
        // base condition
        if (currIdx >= nums.length) {
            return 0;
        }

        if (dp[currIdx][prevIdx + 1] != -1) {
            return dp[currIdx][prevIdx + 1];
        }

        // function body

        // include call
        int include = 0;
        if (prevIdx == -1 || nums[currIdx] > nums[prevIdx]) {
            include = 1 + memoization(nums, currIdx + 1, currIdx, dp);
        }

        // exclude call
        int exclude = memoization(nums, currIdx + 1, prevIdx, dp);

        dp[currIdx][prevIdx + 1] = Math.max(include, exclude);
        return dp[currIdx][prevIdx + 1];
    }

    // recursive approach
    public int recursive(int[] nums, int currIdx, int prevIdx) {
        // base condition
        if (currIdx >= nums.length) {
            return 0;
        }

        // function body

        // include call
        int include = 0;
        if (prevIdx == -1 || nums[currIdx] > nums[prevIdx]) {
            include = 1 + recursive(nums, currIdx + 1, currIdx);
        }

        // exclude call
        int exclude = recursive(nums, currIdx + 1, prevIdx);

        return Math.max(include, exclude);
    }
}
