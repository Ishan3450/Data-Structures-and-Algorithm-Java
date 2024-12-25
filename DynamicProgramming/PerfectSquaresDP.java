package DynamicProgramming;

public class PerfectSquaresDP {
    public int numSquares(int n) {
        // int[] dp = new int[n+1];
        // Arrays.fill(dp, -1);

        return tabulation(n);
    }

    // tabulation approach
    public int tabulation(int n) {
        int[] dp = new int[n + 1];

        for (int currN = 1; currN <= n; currN++) {
            int end = (int) Math.sqrt(currN);
            int leastSquares = Integer.MAX_VALUE;

            for (int i = 1; i <= end; i++) {
                int sqr = i * i;
                int ans = Integer.MAX_VALUE;

                if (currN - sqr >= 0) {
                    ans = dp[currN - sqr];
                }

                if (ans != Integer.MAX_VALUE) {
                    leastSquares = Math.min(leastSquares, 1 + ans);
                }
            }

            dp[currN] = leastSquares;
        }
        return dp[n];
    }

    // memoization appraoch
    public int memoization(int n, int[] dp) {
        // base condition
        if (n == 0) {
            return 0;
        }

        if (n < 0) {
            return Integer.MAX_VALUE;
        }

        if (dp[n] != -1)
            return dp[n];

        // function body
        int end = (int) Math.sqrt(n);
        int leastSquares = Integer.MAX_VALUE;

        for (int i = 1; i <= end; i++) {
            int ans = memoization(n - (i * i), dp);

            if (ans != Integer.MAX_VALUE) {
                leastSquares = Math.min(leastSquares, 1 + ans);
            }
        }

        dp[n] = leastSquares;
        return leastSquares;
    }

    // recursive approach
    public int recursive(int n) {
        // base condition
        if (n == 0) {
            return 0;
        }

        if (n < 0) {
            return Integer.MAX_VALUE;
        }

        // function body
        int end = (int) Math.sqrt(n);
        int leastSquares = Integer.MAX_VALUE;

        for (int i = 1; i <= end; i++) {
            int ans = recursive(n - (i * i));

            if (ans != Integer.MAX_VALUE) {
                leastSquares = Math.min(leastSquares, 1 + ans);
            }
        }
        return leastSquares;
    }
}
