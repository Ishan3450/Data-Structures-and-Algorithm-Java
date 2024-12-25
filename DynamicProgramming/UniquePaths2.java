package DynamicProgramming;

public class UniquePaths2 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // edge case
        if (obstacleGrid[0][0] == 1 || obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1] == 1) {
            return 0;
        }

        // return recursive(obstacleGrid, 0, 0);

        // int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        // for(int[] row: dp) Arrays.fill(row, -1);
        // return memoization(obstacleGrid, 0, 0, dp);

        return tabulation(obstacleGrid);
    }

    // tabulation
    public int tabulation(int[][] grid) {
        int[][] dp = new int[grid.length + 1][grid[0].length + 1];
        dp[grid.length - 1][grid[0].length - 1] = 1;

        for (int row = grid.length - 1; row >= 0; row--) {
            for (int col = grid[0].length - 1; col >= 0; col--) {
                if (row == grid.length - 1 && col == grid[0].length - 1)
                    continue;
                if (grid[row][col] == 1)
                    continue;

                int down = dp[row + 1][col];
                int right = dp[row][col + 1];

                dp[row][col] = down + right;
            }
        }
        return dp[0][0];
    }

    // memoization
    public int memoization(int[][] grid, int row, int col, int[][] dp) {
        // base condition
        if (row == grid.length - 1 && col == grid[0].length - 1) {
            return 1;
        }

        if (row >= grid.length || col >= grid[0].length) {
            return 0;
        }

        if (grid[row][col] == 1) { // obstacle found
            return 0;
        }

        if (dp[row][col] != -1) {
            return dp[row][col];
        }

        // function body
        int down = memoization(grid, row + 1, col, dp);
        int right = memoization(grid, row, col + 1, dp);

        return dp[row][col] = down + right;
    }

    // recursive
    public int recursive(int[][] grid, int row, int col) {
        // base condition
        if (row == grid.length - 1 && col == grid[0].length - 1) {
            return 1;
        }

        if (row >= grid.length || col >= grid[0].length) {
            return 0;
        }

        if (grid[row][col] == 1) { // obstacle found
            return 0;
        }

        // function body
        int down = recursive(grid, row + 1, col);
        int right = recursive(grid, row, col + 1);

        return down + right;
    }
}
