package DynamicProgramming;

public class GuessNumberHigherOrLower2 {
    public int getMoneyAmount(int n) {
        // int[][] dp = new int[n+1][n+1];
        // return memoization(1, n, dp);
        return tabulation(n);
    }

    // no space optimization is possible

    // tabulation
    public int tabulation(int n) {
        int[][] dp = new int[n + 2][n + 2];

        for (int start = n; start >= 1; start--) {
            for (int end = 1; end <= n; end++) {
                if (start >= end) {
                    continue;
                }

                int minSum = Integer.MAX_VALUE;

                for (int i = start; i <= end; i++) {
                    minSum = Math.min(minSum, i + Math.max(dp[start][i - 1], dp[i + 1][end]));
                }
                dp[start][end] = minSum;
            }
        }
        return dp[1][n];
    }

    // memoization
    public int memoization(int start, int end, int[][] dp) {
        // base condition
        if (start >= end) {
            return 0;
        }

        if (dp[start][end] != 0) {
            return dp[start][end];
        }

        // function body
        int minSum = Integer.MAX_VALUE;
        for (int i = start; i <= end; i++) {
            minSum = Math.min(minSum, i + Math.max(memoization(start, i - 1, dp), memoization(i + 1, end, dp)));
        }
        dp[start][end] = minSum;
        return minSum;
    }

    // recursive
    public int recursive(int start, int end) {
        // base condition
        if (start >= end) {
            return 0;
        }

        // function body
        int minSum = Integer.MAX_VALUE;
        for (int i = start; i <= end; i++) {
            minSum = Math.min(minSum, i + Math.max(recursive(start, i - 1), recursive(i + 1, end)));
        }
        return minSum;
    }
}
