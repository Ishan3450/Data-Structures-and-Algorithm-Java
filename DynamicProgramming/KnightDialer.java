package DynamicProgramming;

public class KnightDialer {
    final int MOD = 1000000007;

    public int knightDialer(int n) {
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

        // int[][][] dp = new int[n][4][3];

        // for(int[][] mat: dp)
        // for(int[] row: mat)
        // Arrays.fill(row, -1);

        int totalWays = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                if ((i == 3 && j == 0) || (i == 3 && j == 2)) {
                    continue;
                }

                // totalWays = (totalWays + (recursive(i, j, moves, n-1) % MOD)) % MOD; //
                // passing n-1 as in questions said we have to do n-1 moves
                // totalWays = (totalWays + (memoization(i, j, moves, n-1, dp) % MOD)) % MOD; //
                // passing n-1 as in questions said we have to do n-1 moves
                totalWays = (totalWays + (tabulation(i, j, moves, n - 1) % MOD)) % MOD; // passing n-1 as in questions
                                                                                        // said we have to do n-1 moves
            }
        }

        return totalWays;
    }

    // tabulation
    public int tabulation(int row, int col, int[][] moves, int n) {
        int[][][] dp = new int[n + 1][4 + 1][3 + 1];

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                dp[0][i][j] = 1;
            }
        }

        // resetting the non numerical case which was set in above condition setting
        dp[0][3][0] = 0;
        dp[0][3][2] = 0;

        for (int totalMoves = 1; totalMoves <= n; totalMoves++) {
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 3; j++) {
                    if ((i == 3 && j == 0) || (i == 3 && j == 2)) {
                        continue;
                    }
                    int totalWays = 0;

                    for (int[] move : moves) {
                        int nr = i + move[0];
                        int nc = j + move[1];

                        if (nr >= 0 && nr < 4 && nc >= 0 && nc < 4)
                            totalWays = (totalWays + (dp[totalMoves - 1][nr][nc] % MOD)) % MOD;
                    }

                    dp[totalMoves][i][j] = totalWays;
                }
            }
        }

        return dp[n][row][col];
    }

    // memoization
    public int memoization(int row, int col, int[][] moves, int totalMoves, int[][][] dp) {
        // base condition
        if (row < 0 || col < 0 || row >= 4 || col >= 3) {
            return 0;
        }

        if ((row == 3 && col == 0) || (row == 3 && col == 2)) { // non numerical case
            return 0;
        }

        if (dp[totalMoves][row][col] != -1) {
            return dp[totalMoves][row][col];
        }

        if (totalMoves == 0) {
            if (row >= 0 && col >= 0 && row < 4 && col < 3) {
                return 1;
            }

            return 0;
        }

        // function body
        int totalWays = 0;

        for (int[] move : moves) {
            totalWays = (totalWays + (memoization(row + move[0], col + move[1], moves, totalMoves - 1, dp) % MOD))
                    % MOD;
        }

        return dp[totalMoves][row][col] = totalWays;
    }

    // recursive
    public int recursive(int row, int col, int[][] moves, int totalMoves) {
        // base condition
        if (row < 0 || col < 0 || row >= 4 || col >= 3) {
            return 0;
        }

        if ((row == 3 && col == 0) || (row == 3 && col == 2)) { // non numerical case
            return 0;
        }

        if (totalMoves == 0) {
            if (row >= 0 && col >= 0 && row < 4 && col < 3) {
                return 1;
            }

            return 0;
        }

        // function body
        int totalWays = 0;

        for (int[] move : moves) {
            totalWays = (totalWays + (recursive(row + move[0], col + move[1], moves, totalMoves - 1) % MOD)) % MOD;
        }

        return totalWays;
    }
}
