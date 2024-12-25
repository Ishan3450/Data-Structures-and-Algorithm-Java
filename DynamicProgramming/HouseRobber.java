package DynamicProgramming;

import java.util.Arrays;

public class HouseRobber {
    // normal recursive TLE approach
    private int recursive(int[] nums, int idx) {
        // base condition
        if (idx >= nums.length) {
            return 0;
        }

        // function body
        int include = nums[idx] + recursive(nums, idx + 2);
        int exclude = recursive(nums, idx + 1);

        return Math.max(include, exclude);
    }

    // bottom up tabulation approach
    private int bottomUpTabulation(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);

        for (int i = nums.length - 1; i >= 0; i--) {

            int include = 0;
            int exclude = 0;

            if (i + 1 < dp.length) { // exclude call
                exclude = dp[i + 1];
            }

            if (i + 2 < dp.length) { // include call
                include = dp[i + 2];
            }

            dp[i] = Math.max(exclude, nums[i] + include);
        }

        return dp[0];
    }

    // using top down memoization
    private int topDownMemoization(int[] nums, int idx, int[] dp) {
        // base condition
        if (idx >= nums.length) {
            return 0;
        }

        if (dp[idx] != -1) {
            return dp[idx];
        }

        // function body
        int include = nums[idx] + topDownMemoization(nums, idx + 2, dp);
        int exclude = topDownMemoization(nums, idx + 1, dp);

        dp[idx] = Math.max(include, exclude);
        return dp[idx];
    }

    // space optimization is possible in this problem because dp[i] depends only on dp[i+1] and dp[i+2]
    private int spaceOptimized(int[] nums){
        int justNext = 0;
        int nextToNext = 0;

        int curr = 0;

        for(int i = nums.length-1; i >= 0; i--){
            int exclude = 0;
            int include = 0;

            exclude = justNext;
            include = nextToNext + nums[i];

            curr = Math.max(exclude, include);
            nextToNext = justNext;
            justNext = curr;
        }

        return curr;
    }
}
