package DynamicProgramming;

import java.util.List;

public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        // return recursive(triangle, 0, 0);

        // int[][] dp = new
        // int[triangle.size()][triangle.get(triangle.size()-1).size()];
        // for(int[] row: dp) Arrays.fill(row, -1);
        // return memoization(triangle, 0, 0, dp);

        // return tabulation(triangle);
        return spaceOptimized(triangle);
    }

    // space optimization
    public int spaceOptimized(List<List<Integer>> triangle) {
        int n = triangle.size();
        int m = triangle.get(triangle.size() - 1).size();

        int[] curr = new int[m + 1];
        int[] next = new int[m + 1];

        for (int row = n - 1; row >= 0; row--) {

            // important to get current size of the list otherwise out of bound exception
            // will be there
            int currSize = triangle.get(row).size();

            for (int col = currSize - 1; col >= 0; col--) {
                int left = next[col];
                int right = next[col + 1];

                curr[col] = triangle.get(row).get(col) + Math.min(left, right);
            }
            // shifting
            next = curr.clone();
        }

        return curr[0];
    }

    // tabulation
    public int tabulation(List<List<Integer>> triangle) {
        int n = triangle.size();
        int m = triangle.get(triangle.size() - 1).size();

        int[][] dp = new int[n + 1][m + 1];

        for (int row = n - 1; row >= 0; row--) {

            // important to get current size of the list otherwise out of bound exception
            // will be there
            int curr = triangle.get(row).size();

            for (int col = curr - 1; col >= 0; col--) {
                int left = dp[row + 1][col];
                int right = dp[row + 1][col + 1];

                dp[row][col] = triangle.get(row).get(col) + Math.min(left, right);
            }
        }

        return dp[0][0];
    }

    // memoization
    public int memoization(List<List<Integer>> triangle, int row, int col, int[][] dp) {
        // base condition
        if (row >= triangle.size()) {
            return 0;
        }

        if (dp[row][col] != -1) {
            return dp[row][col];
        }

        // function body
        int left = memoization(triangle, row + 1, col, dp);
        int right = memoization(triangle, row + 1, col + 1, dp);

        return dp[row][col] = triangle.get(row).get(col) + Math.min(left, right);
    }

    // recursive
    public int recursive(List<List<Integer>> triangle, int row, int col) {
        // base condition
        if (row >= triangle.size()) {
            return 0;
        }

        // function body
        int left = recursive(triangle, row + 1, col);
        int right = recursive(triangle, row + 1, col + 1);

        return triangle.get(row).get(col) + Math.min(left, right);
    }
}
