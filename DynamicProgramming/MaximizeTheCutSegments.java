package DynamicProgramming;

import java.util.Arrays;

public class MaximizeTheCutSegments {
    // space optimization not possible

    // bottom up tabulation approach
    public int bottomUpTabulation(int n, int x, int y, int z) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            int xCut = -1;
            int yCut = -1;
            int zCut = -1;

            if (i - x >= 0) {
                xCut = dp[i - x];
            }

            if (i - y >= 0) {
                yCut = dp[i - y];
            }

            if (i - z >= 0) {
                zCut = dp[i - z];
            }

            int max = Math.max(xCut, Math.max(yCut, zCut));

            if (max != -1) {
                dp[i] = 1 + max;
            }
        }

        return dp[n] == -1 ? 0 : dp[n];
    }

    // top down memoization approach
    public int topDownMemoization(int n, int x, int y, int z, int[] dp) {
        // base condition
        if (n == 0) {
            return 0;
        }

        if (n < 0) {
            return -1;
        }

        // function body
        if (dp[n] != -1) {
            return dp[n];
        }

        int xCut = topDownMemoization(n - x, x, y, z, dp);
        int yCut = topDownMemoization(n - y, x, y, z, dp);
        int zCut = topDownMemoization(n - z, x, y, z, dp);

        int max = Math.max(xCut, Math.max(yCut, zCut));

        if (max != -1) {
            dp[n] = 1 + max;
        }

        return dp[n];
    }

    // recursive approach
    public int recursive(int n, int x, int y, int z) {
        // base condition
        if (n == 0) {
            return 0;
        }

        if (n < 0) {
            return -1;
        }

        // function body
        int xCut = recursive(n - x, x, y, z);
        int yCut = recursive(n - y, x, y, z);
        int zCut = recursive(n - z, x, y, z);

        return 1 + Math.max(xCut, Math.max(yCut, zCut));
    }

}
