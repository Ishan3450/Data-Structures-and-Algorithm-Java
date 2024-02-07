package DynamicProgramming;

import java.util.Arrays;

public class OnesAndZeroes3DDP {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][][] dp = new int[strs.length][m + 1][n + 1];

        for (int[][] mat : dp) {
            for (int[] row : mat) {
                Arrays.fill(row, -1);
            }
        }

        return memoization(strs, 0, m, n, dp);
    }

    // memoization
    private int memoization(String[] strs, int idx, int m, int n, int[][][] dp) {
        // base condition
        if (idx >= strs.length || (m == 0 && n == 0)) {
            return 0;
        }

        if (dp[idx][m][n] != -1) {
            return dp[idx][m][n];
        }

        // function body
        String curr = strs[idx];

        int ones = 0;
        int zeroes = 0;

        for (int i = 0; i < curr.length(); i++) {
            if (curr.charAt(i) == '0')
                zeroes++;
            else
                ones++;
        }

        // including
        int exclude = memoization(strs, idx + 1, m, n, dp);

        // not including
        int include = 0;
        if (m - zeroes >= 0 && n - ones >= 0) {
            include = 1 + memoization(strs, idx + 1, m - zeroes, n - ones, dp);
        }

        dp[idx][m][n] = Math.max(include, exclude);
        return dp[idx][m][n];
    }

    // recursive approach
    private int recursive(String[] strs, int idx, int m, int n) {
        // base condition
        if (idx >= strs.length || (m == 0 && n == 0)) {
            return 0;
        }

        // function body
        String curr = strs[idx];

        int ones = 0;
        int zeroes = 0;

        for (int i = 0; i < curr.length(); i++) {
            if (curr.charAt(i) == '0')
                zeroes++;
            else
                ones++;
        }

        // including
        int exclude = recursive(strs, idx + 1, m, n);

        // not including
        int include = 0;
        if (m - zeroes >= 0 && n - ones >= 0) {
            include = 1 + recursive(strs, idx + 1, m - zeroes, n - ones);
        }

        return Math.max(include, exclude);
    }
}
