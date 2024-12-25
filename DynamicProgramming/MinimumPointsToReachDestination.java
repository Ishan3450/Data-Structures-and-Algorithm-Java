package DynamicProgramming;

public class MinimumPointsToReachDestination {
    public int minPoints(int points[][], int m, int n) {
        int initialPoints = 1;

        boolean[][] dp = new boolean[m][n];
        while (!reachDestination(points, m, n, 0, 0, initialPoints, dp)) {
            initialPoints++;
        }
        return initialPoints;
    }

    private boolean reachDestination(int[][] points, int rows, int cols, int row, int col, int initialPoints,
            boolean[][] dp) {
        // base condition
        if (initialPoints <= 0) {
            return false;
        }

        // below is an important base condition
        if (row == rows - 1 && col == cols - 1 && initialPoints + points[row][col] > 0) {
            return true;
        }
        if (row >= rows || col >= cols) {
            return false;
        }

        if (dp[row][col])
            return true;

        // function body

        // down call
        int updatedPoints = initialPoints + points[row][col];

        boolean resultFromDownCall = reachDestination(points, rows, cols, row + 1, col, updatedPoints, dp);
        if (resultFromDownCall)
            return dp[row][col] = true;

        // right call
        return dp[row][col] = reachDestination(points, rows, cols, row, col + 1, updatedPoints, dp);
    }
}
