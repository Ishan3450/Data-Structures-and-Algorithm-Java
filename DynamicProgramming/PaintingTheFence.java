package DynamicProgramming;

public class PaintingTheFence {
    /*
     * Remaining to do the tabulation and space optimization approaches
     */

    long topDownMemoization(int n, int k, long[] dp) {
        // base condition
        if (n == 1) {
            return k;
        }

        if (n == 2) {
            return (k * k);
        }

        // function body
        if (dp[n] != -1) {
            return dp[n];
        }

        long sameCase = topDownMemoization(n - 2, k, dp) % 1000000007;
        long differentCase = topDownMemoization(n - 1, k, dp) % 1000000007;

        dp[n] = (((sameCase + differentCase) % 1000000007) * (k - 1)) % 1000000007;
        return dp[n];

    }

    // recursive approach
    long recursive(int n, int k) {
        // base condition
        if (n == 1) {
            return k;
        }

        if (n == 2) {
            return (k * k);
        }

        // function body
        return (recursive(n - 1, k) % 1000000007 + recursive(n - 2, k) % 1000000007) * (k - 1);
    }
}