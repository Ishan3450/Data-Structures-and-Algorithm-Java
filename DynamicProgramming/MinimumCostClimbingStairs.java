package DynamicProgramming;

import java.util.Arrays;

public class MinimumCostClimbingStairs {
    // space optimization is possible
    public int spaceOptimized(int[] cost, int start) {
        int next = 0;
        int nextToNext = 0;

        int min = 0;

        for (int i = cost.length - 1; i >= start; i--) {
            min = cost[i] + Math.min(next, nextToNext);
            nextToNext = next;
            next = min;
        }
        return min;
    }

    // bottom up tabulation method
    public int bottomUpTabulation(int[] cost, int start) {
        int[] dp = new int[cost.length];
        Arrays.fill(dp, -1);

        for (int i = cost.length - 1; i >= start; i--) {
            int next = 0;
            int nextToNext = 0;

            if (i + 1 < cost.length) {
                next = dp[i + 1];
            }

            if (i + 2 < cost.length) {
                nextToNext = dp[i + 2];
            }

            dp[i] = cost[i] + Math.min(next, nextToNext);
        }
        return dp[start];
    }

    /*
     * Top down memoization approach
     * 
     * The dp array passed in the arguement will be same for because when for i = 0
     * will be called the overlapping subproblems will be generated and when for i =
     * 1 will be called that pre-generated thing will be used again.
     */
    public int topDownMemoization(int[] cost, int idx, int[] dp) {
        // base condition
        if (idx >= cost.length) {
            return 0;
        }

        // function body
        if (dp[idx] != -1) {
            return dp[idx];
        }

        int oneStep = topDownMemoization(cost, idx + 1, dp);
        int twoStep = topDownMemoization(cost, idx + 2, dp);

        dp[idx] = cost[idx] + Math.min(oneStep, twoStep);
        return dp[idx];
    }

    public int recursive(int[] cost, int i) {
        // base condition
        if (i >= cost.length) {
            return 0;
        }

        // function body
        int oneStep = recursive(cost, i + 2);
        int twoStep = recursive(cost, i + 1);

        return cost[i] + Math.min(oneStep, twoStep);
    }
}
