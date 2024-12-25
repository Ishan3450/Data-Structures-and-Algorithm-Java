package DynamicProgramming;

public class UniqueBinarySearchTrees {
    public int numTrees(int n) {
        // int[] dp = new int[n+1];
        // Arrays.fill(dp, -1);
        return tabulation(n);
    }

    // tabulation approach
    public int tabulation(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int currN = 2; currN <= n; currN++) {
            int ways = 0;
            for (int i = 1; i <= currN; i++) {
                ways += dp[i - 1] * dp[currN - i];
            }
            dp[currN] = ways;
        }
        return dp[n];
    }

    // memoization approach
    public int memoization(int n, int[] dp) {
        // base condition
        if (n <= 1) {
            return 1;
        }

        if (dp[n] != -1) {
            return dp[n];
        }

        // function body
        int ways = 0;
        for (int i = 1; i <= n; i++) {
            ways += memoization(i - 1, dp) * memoization(n - i, dp);
        }
        dp[n] = ways;
        return ways;
    }

    // recursive approach
    public int recursive(int n) {
        // base condition
        if (n <= 1) {
            return 1;
        }

        // function body
        int ways = 0;
        for (int i = 1; i <= n; i++) {
            ways += recursive(i - 1) * recursive(n - i);
        }
        return ways;
    }
}
