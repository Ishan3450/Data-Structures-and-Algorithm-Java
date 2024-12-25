package DynamicProgramming;

import java.util.Arrays;

public class ClimbingStairs {
    // space optimization is possible, so here is the appraoch
    public int spaceOptimized(int n) {
        // edge case
        if (n <= 1) {
            return n;
        }

        int waysFromPrevious = 1; // n == 0
        int waysFromPreviousToPrevious = 1; // n == 1

        int totalWays = 0;
        for (int i = 2; i <= n; i++) {
            totalWays = waysFromPrevious + waysFromPreviousToPrevious;
            waysFromPreviousToPrevious = waysFromPrevious;
            waysFromPrevious = totalWays;
        }
        return totalWays;
    }

    // bottom up tabulation approach
    public int bottomUpTabulation(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);

        dp[0] = 1; // what to put the value, check the memoization approach base condition

        for (int i = 1; i <= n; i++) {
            int nextStair = 0;
            int skippingNextStair = 0;

            if (i - 1 >= 0) {
                nextStair = dp[i - 1];
            }

            if (i - 2 >= 0) {
                skippingNextStair = dp[i - 2];
            }

            dp[i] = nextStair + skippingNextStair;
        }
        return dp[n];
    }

    // top down memoization approach
    public int topDownMemoization(int n, int[] dp) {
        // base condition
        if (n == 0) {
            return 1;
        }

        if (n < 0) {
            return 0;
        }

        // function body
        if (dp[n] != -1) {
            return dp[n];
        }

        int nextStair = topDownMemoization(n - 1, dp);
        int skippingNextStair = topDownMemoization(n - 2, dp);

        dp[n] = nextStair + skippingNextStair;

        return dp[n];
    }

    // normal recursive way
    public int climbStairs(int n) {
        // base condition
        if (n == 0) {
            return 1;
        }

        if (n < 0) {
            return 0;
        }

        // function body
        return climbStairs(n - 1) + climbStairs(n - 2);
    }
}
