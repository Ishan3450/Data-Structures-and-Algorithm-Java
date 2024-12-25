package DynamicProgramming;

import java.util.Arrays;

public class OutOfBoundaryPaths {
    final int MOD = 1000000007;

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        // return recursive(m, n, maxMove, startRow, startColumn);

        int[][][] dp = new int[maxMove + 1][m][n];
        for (int[][] mat : dp) {
            for (int[] row : mat) {
                Arrays.fill(row, -1);
            }
        }

        return memoization(m, n, maxMove, startRow, startColumn, dp);
    }

    // memoization
    public int memoization(int m, int n, int maxMove, int startRow, int startColumn, int[][][] dp) {
        // base condition
        if (startRow < 0 || startRow >= m || startColumn < 0 || startColumn >= n) {
            return 1;
        }

        if (maxMove == 0) {
            return 0;
        }

        if (dp[maxMove][startRow][startColumn] != -1) {
            return dp[maxMove][startRow][startColumn];
        }

        // function body

        // left
        int left = memoization(m, n, maxMove - 1, startRow, startColumn - 1, dp) % MOD;

        // down
        int down = memoization(m, n, maxMove - 1, startRow + 1, startColumn, dp) % MOD;

        // right
        int right = memoization(m, n, maxMove - 1, startRow, startColumn + 1, dp) % MOD;

        // up
        int up = memoization(m, n, maxMove - 1, startRow - 1, startColumn, dp) % MOD;

        return dp[maxMove][startRow][startColumn] = (((((left + down) % MOD) + right) % MOD) + up) % MOD;
    }

    // recursive
    public int recursive(int m, int n, int maxMove, int startRow, int startColumn) {
        // base condition
        if (startRow < 0 || startRow >= m || startColumn < 0 || startColumn >= n) {
            return 1;
        }

        if (maxMove == 0) {
            return 0;
        }

        // function body

        // left
        int left = recursive(m, n, maxMove - 1, startRow, startColumn - 1);

        // down
        int down = recursive(m, n, maxMove - 1, startRow + 1, startColumn);

        // right
        int right = recursive(m, n, maxMove - 1, startRow, startColumn + 1);

        // up
        int up = recursive(m, n, maxMove - 1, startRow - 1, startColumn);

        return left + down + right + up;
    }
}
