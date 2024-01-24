package DynamicProgramming;

import java.util.Arrays;

public class FibonacciUsingDP {
    public int fib(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);

        return topDownDP(n, dp);
        // return bottomUpDP(n);
    }

    // top down approach or recursion + memoization
    // TC: O(N) SC: O(N+N)
    private int topDownDP(int n, int[] dp) {
        // base condition
        if (n <= 1) {
            return n;
        }

        // DP ans checking
        if (dp[n] != -1) {
            return dp[n];
        }

        dp[n] = topDownDP(n - 1, dp) + topDownDP(n - 2, dp);
        return dp[n];
    }

    // bottom up tabulation method
    // TC: O(N) SC: O(N)
    private int bottomUpDP(int n){
        int[] dp = new int[n+1];
        
        // checking if input is base condition or not
        if(n <= 1){
            return n;
        }

        // base conditions
        dp[0] = 0;
        dp[1] = 1;


        for(int i = 2; i <= n; i ++){
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }

    // Space Optimization:
    // In the solution we can see that the curr ans only depends on the curr - 1 and curr - 2 and not depends on whole dp array, so what we can do is just take 2 variables prev1 and prev2 and after calculating the curr we can shift the prev2 to prev1 and prev1 to curr
    // TC: O(N) SC: O(1)
    private int bottomUpDPSpaceOptimized(int n){
        int prev1 = 1;
        int prev2 = 0;

        int curr = 0;
        for(int i = 2; i <= n; i++){
            curr = prev1 + prev2;
            prev2 = prev1;
            prev1 = curr;
        }

        return curr;
    }
}
