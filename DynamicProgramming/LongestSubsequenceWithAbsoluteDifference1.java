package DynamicProgramming;

public class LongestSubsequenceWithAbsoluteDifference1 {
    static int longestSubsequence(int N, int A[]) {
        // int[][] dp = new int[N+1][N+1];
        // for(int[] row: dp) Arrays.fill(row, -1);
        // return memoization(A, 0, -1, dp);
        return tabulation(A, N);
    }

    // tabulation appraoch
    public static int tabulation(int[] arr, int N) {
        int[][] dp = new int[N + 1][N + 1];

        for (int currIdx = arr.length - 1; currIdx >= 0; currIdx--) {
            for (int prevIdx = arr.length - 1; prevIdx >= -1; prevIdx--) {
                int include = 0;

                if (prevIdx == -1 || Math.abs(arr[currIdx] - arr[prevIdx]) == 1) {
                    include = 1 + dp[currIdx + 1][currIdx + 1];
                }

                int exclude = dp[currIdx + 1][prevIdx + 1];

                dp[currIdx][prevIdx + 1] = Math.max(include, exclude);
            }
        }
        return dp[0][0];
    }

    // meomization approach
    public static int memoization(int[] arr, int currIdx, int prevIdx, int[][] dp) {
        // base condition
        if (currIdx >= arr.length) {
            return 0;
        }

        if (dp[currIdx][prevIdx + 1] != -1) {
            return dp[currIdx][prevIdx + 1];
        }

        // function body
        int include = 0;
        if (prevIdx == -1 || Math.abs(arr[currIdx] - arr[prevIdx]) == 1) {
            include = 1 + memoization(arr, currIdx + 1, currIdx, dp);
        }

        int exclude = memoization(arr, currIdx + 1, prevIdx, dp);

        dp[currIdx][prevIdx + 1] = Math.max(include, exclude);
        return dp[currIdx][prevIdx + 1];
    }

    // recursive approach
    public static int recursive(int[] arr, int currIdx, int prevIdx) {
        // base condition
        if (currIdx >= arr.length) {
            return 0;
        }

        // function body
        int include = 0;
        if (prevIdx == -1 || Math.abs(arr[currIdx] - arr[prevIdx]) == 1) {
            include = 1 + recursive(arr, currIdx + 1, currIdx);
        }

        int exclude = recursive(arr, currIdx + 1, prevIdx);

        return Math.max(include, exclude);
    }
}
