package DynamicProgramming;

import java.util.Arrays;

public class SubsetSumProblem {
    // reducing sum + sum space to sum space
    static boolean spaceOptimized2(int N, int[] arr, int sum) {
        boolean[] curr = new boolean[sum + 1];

        curr[0] = true;

        if (arr[0] <= sum) {
            curr[arr[0]] = true;
        }

        for (int i = 1; i < N; i++) {
            for (int currSum = sum; currSum >= 1; currSum--) {
                boolean include = false;
                boolean exclude = false;

                if (arr[i] <= currSum) {
                    include = curr[currSum - arr[i]];
                }

                exclude = curr[currSum];

                curr[currSum] = include || exclude;
            }
        }
        return curr[sum];
    }

    // reducing N*sum space to sum + sum space
    static boolean spaceOptimized1(int N, int[] arr, int sum) {
        boolean[] prev = new boolean[sum + 1];
        boolean[] curr = new boolean[sum + 1];

        prev[0] = true;
        curr[0] = true;

        if (arr[0] <= sum) {
            prev[arr[0]] = true;
        }

        for (int i = 1; i < N; i++) {
            for (int currSum = 1; currSum <= sum; currSum++) {
                boolean include = false;
                boolean exclude = false;

                if (arr[i] <= currSum) {
                    include = prev[currSum - arr[i]];
                }

                exclude = prev[currSum];

                curr[currSum] = include || exclude;
            }
            // shifting
            prev = Arrays.copyOf(curr, sum + 1);
        }
        return prev[sum];

    }

    // bottom up tabulation approach
    static boolean bottomUpTabulation(int N, int[] arr, int sum) {
        boolean[][] dp = new boolean[N][sum + 1];

        for (int i = 0; i < N; i++) {
            dp[i][0] = true;
        }

        if (arr[0] <= sum) {
            dp[0][arr[0]] = true;
        }

        for (int i = 1; i < N; i++) {
            for (int currSum = 1; currSum <= sum; currSum++) {
                boolean include = false;
                boolean exclude = false;

                if (arr[i] <= currSum) {
                    include = dp[i - 1][currSum - arr[i]];
                }

                exclude = dp[i - 1][currSum];

                dp[i][currSum] = include || exclude;
            }
        }
        return dp[N - 1][sum];
    }

    // top down memoization
    static boolean topDownMemoization(int N, int[] arr, int sum, boolean[][] dp) {
        // base condition
        if (sum == 0) {
            return true;
        }

        if (N < 0 || sum < 0) {
            return false;
        }

        // function body
        if (dp[N][sum]) {
            return true;
        }

        boolean include = topDownMemoization(N - 1, arr, sum - arr[N], dp);

        if (include) {
            dp[N][sum] = true;
            return true;
        }

        boolean exclude = topDownMemoization(N - 1, arr, sum, dp);

        if (exclude) {
            dp[N][sum] = true;
        }

        return exclude;
    }

    // normal recursive approach
    static boolean recursive(int N, int[] arr, int sum, int idx) {
        // base condition
        if (sum == 0) {
            return true;
        }

        if (idx >= N || sum < 0) {
            return false;
        }

        // function body
        boolean include = recursive(N, arr, sum - arr[idx], idx + 1);

        if (include) {
            return true;
        }

        return recursive(N, arr, sum, idx + 1);
    }
}
