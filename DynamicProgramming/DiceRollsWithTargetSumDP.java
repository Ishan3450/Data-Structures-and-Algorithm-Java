package DynamicProgramming;

import java.util.Arrays;

public class DiceRollsWithTargetSumDP {
    final int MOD = 1000000007;

    // space optimization from n*target to target + target
    public int spaceOptimization(int n, int k, int target) {
        int[] prev = new int[target + 1];
        int[] curr = new int[target + 1];
        prev[0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int currTarget = 1; currTarget <= target; currTarget++) {
                int count = 0;
                int end = Math.min(currTarget, k);
                for (int diceNum = 1; diceNum <= end; diceNum++) {
                    int includeCurrDiceNum = prev[currTarget - diceNum];
                    count = (count + includeCurrDiceNum) % MOD;
                }
                curr[currTarget] = count;
            }
            // shifting
            prev = Arrays.copyOf(curr, target + 1);
        }
        return prev[target];
    }

    // tabulation
    public int bottomUpTabulation(int n, int k, int target) {
        int[][] dp = new int[n + 1][target + 1];

        dp[0][0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int currTarget = 1; currTarget <= target; currTarget++) {
                int count = 0;
                int end = Math.min(currTarget, k);
                for (int diceNum = 1; diceNum <= end; diceNum++) {
                    int includeCurrDiceNum = dp[i - 1][currTarget - diceNum];
                    count = (count + includeCurrDiceNum) % MOD;
                }
                dp[i][currTarget] = count;
            }
        }
        return dp[n][target];
    }

    // memoization
    public int topDownMemoization(int n, int k, int target, int[][] dp) {
        // base condition
        if (n == 0 && target == 0) {
            return 1;
        }

        if (n == 0 || target <= 0) {
            return 0;
        }

        // function body
        if (dp[n][target] != 0) {
            return dp[n][target];
        }

        int count = 0;
        for (int i = 1; i <= k; i++) {
            if (i > target)
                break;
            count = (count + (topDownMemoization(n - 1, k, target - i, dp) % MOD)) % MOD;
        }
        dp[n][target] = count;
        return dp[n][target];
    }

    // normal recursive appraoch
    public int recursive(int n, int k, int target) {
        // base condition
        if (n == 0 && target == 0) {
            return 1;
        }

        if (n == 0 || target <= 0) {
            return 0;
        }

        // function body
        int ans = 0;
        for (int i = 1; i <= k; i++) {
            ans += recursive(n - 1, k, target - i);
        }

        return ans;
    }
}
