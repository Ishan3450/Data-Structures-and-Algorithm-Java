package DynamicProgramming;

import java.util.Arrays;

public class MinimumFallingPathSum {

    /*
     * There is a test case in the problem in which if you initialize dp with -1 it will not work and if initialized with Integer.MAX_VALUE it works, the values of the matrix in the test case are all 0s.
     */

    public int minFallingPathSum(int[][] matrix) {
        int minFallingPathSum = Integer.MAX_VALUE;

        // for(int col = 0 ; col < matrix.length ; col ++){
        // minFallingPathSum = Math.min(minFallingPathSum, recursive(matrix, 0, col));
        // }

        int[][] dp = new int[matrix.length][matrix.length];
        for (int[] row : dp)
            Arrays.fill(row, Integer.MAX_VALUE);

        for (int col = 0; col < matrix.length; col++) {
            minFallingPathSum = Math.min(minFallingPathSum, memoization(matrix, 0, col, dp));
        }

        return minFallingPathSum;
    }

    // memoization
    public int memoization(int[][] matrix, int row, int col, int[][] dp) {
        // base condition
        if (row >= matrix.length) {
            return 0;
        }

        if (col < 0 || col >= matrix.length) {
            return Integer.MAX_VALUE;
        }

        if (dp[row][col] != -1) {
            return dp[row][col];
        }

        // function body
        int leftDiagonal = memoization(matrix, row + 1, col - 1, dp);
        int justBelow = memoization(matrix, row + 1, col, dp);
        int rightDiagonal = memoization(matrix, row + 1, col + 1, dp);

        dp[row][col] = matrix[row][col] + Math.min(justBelow, Math.min(leftDiagonal, rightDiagonal));
        return dp[row][col];
    }

    // recursive
    public int recursive(int[][] matrix, int row, int col) {
        // base condition
        if (row >= matrix.length) {
            return 0;
        }

        if (col < 0 || col >= matrix.length) {
            return Integer.MAX_VALUE;
        }

        // function body
        int leftDiagonal = recursive(matrix, row + 1, col - 1);
        int justBelow = recursive(matrix, row + 1, col);
        int rightDiagonal = recursive(matrix, row + 1, col + 1);

        int minFromRecCalls = Math.min(justBelow, Math.min(leftDiagonal, rightDiagonal));
        return matrix[row][col] + minFromRecCalls;
    }
}
