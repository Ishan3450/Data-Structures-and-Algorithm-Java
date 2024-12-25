package DynamicProgramming;

import java.util.Arrays;

// * All 8 moves from (row, col) :

// * r-2, c+1
// * r-1, c+2
// * r+1, c+2
// * r+2, c+1
// * r+2, c-1
// * r+1, c-2
// * r-1, c-2
// * r-2, c-1

public class KnightProbabilityInChessboard {
    public double knightProbability(int n, int k, int row, int column) {
        int[][] moves = {
                { -2, 1 },
                { -1, 2 },
                { 1, 2 },
                { 2, 1 },
                { 2, -1 },
                { 1, -2 },
                { -1, -2 },
                { -2, -1 }
        };

        // return recursive(n, k, row, column, moves) / Math.pow(8, k);

        double[][][] dp = new double[k + 1][n][n];
        for (double[][] mat : dp) {
            for (double[] r : mat) {
                Arrays.fill(r, -1);
            }
        }

        return memoization(n, k, row, column, moves, dp) / Math.pow(8, k);
    }

    // memoization
    public double memoization(int n, int k, int row, int column, int[][] moves, double[][][] dp) {
        // base condition
        if (row < 0 || row >= n || column < 0 || column >= n) {
            return 0;
        }

        if (k == 0) { // if all moves are used
            if (row >= 0 && row < n && column >= 0 && column < n) {
                return 1;
            }
            return 0;
        }

        if (dp[k][row][column] != -1) {
            return dp[k][row][column];
        }

        // function body
        double waysToStayInBoard = 0;

        for (int[] move : moves) {
            waysToStayInBoard += memoization(n, k - 1, row + move[0], column + move[1], moves, dp);
        }

        return dp[k][row][column] = waysToStayInBoard;
    }

    // recursive
    public double recursive(int n, int k, int row, int column, int[][] moves) {
        // base condition
        if (row < 0 || row >= n || column < 0 || column >= n) {
            return 0;
        }

        if (k == 0) { // if all moves are used
            if (row >= 0 && row < n && column >= 0 && column < n) {
                return 1;
            }
            return 0;
        }

        // function body
        double waysToStayInBoard = 0;

        for (int[] move : moves) {
            waysToStayInBoard += recursive(n, k - 1, row + move[0], column + move[1], moves);
        }

        return waysToStayInBoard;
    }
}
