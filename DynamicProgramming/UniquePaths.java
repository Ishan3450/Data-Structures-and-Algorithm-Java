package DynamicProgramming;

public class UniquePaths {
    public int uniquePaths(int m, int n) {
        // return recursive(m, n);

        // int[][] dp = new int[m+1][n+1];
        // for(int[] row: dp) Arrays.fill(row, -1);
        // return memoization(m, n, dp);

        // return tabulation(m, n);
        return spaceOptimized(m, n);
    }

    // space optimized
    public int spaceOptimized(int m, int n) {
        int[] prev = new int[n + 1];
        int[] curr = new int[n + 1];

        // did mistake last time set 1 to the prev[1]
        curr[1] = 1;

        for (int row = 1; row <= m; row++) {
            for (int col = 1; col <= n; col++) {
                // important line
                if (row == 1 && col == 1)
                    continue;
                //

                int left = curr[col - 1];
                int up = prev[col];

                curr[col] = left + up;
            }
            prev = curr.clone();
        }

        return curr[n];
    }

    // tabulation
    public int tabulation(int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        dp[1][1] = 1;

        for (int row = 1; row <= m; row++) {
            for (int col = 1; col <= n; col++) {
                // important line
                if (row == 1 && col == 1)
                    continue;
                //

                int left = dp[row][col - 1];
                int up = dp[row - 1][col];

                dp[row][col] = left + up;
            }
        }

        return dp[m][n];
    }

    // memoization
    public int memoization(int m, int n, int[][] dp) {
        // base condition
        if (m == 1 && n == 1) {
            return 1;
        }

        if (m < 1 || n < 1) {
            return 0;
        }

        if (dp[m][n] != -1) {
            return dp[m][n];
        }

        // base condition
        int left = memoization(m, n - 1, dp);
        int up = memoization(m - 1, n, dp);

        return dp[m][n] = left + up;
    }

    // recursive
    public int recursive(int m, int n) {
        // base condition
        if (m == 1 && n == 1) {
            return 1;
        }

        if (m < 1 || n < 1) {
            return 0;
        }

        // base condition
        int left = recursive(m, n - 1);
        int up = recursive(m - 1, n);

        return left + up;
    }
}
