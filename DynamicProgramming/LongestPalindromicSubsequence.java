package DynamicProgramming;

import java.util.Arrays;

public class LongestPalindromicSubsequence {
    public int longestPalindromeSubseq(String s) {
        // if(s.length() == 1) return 1;

        // return recursive(s, 0, s.length()-1);

        int[][] dp = new int[s.length()][s.length()];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        return memoization(s, 0, s.length() - 1, dp);

    }

    // memoization
    public int memoization(String s, int left, int right, int[][] dp) {
        // base condition
        if (left == right) {
            return 1;
        }

        if (left > right)
            return 0;

        if (dp[left][right] != -1) {
            return dp[left][right];
        }

        // function body
        if (s.charAt(left) == s.charAt(right)) {
            return dp[left][right] = 2 + memoization(s, left + 1, right - 1, dp);
        } else {
            int movingLeft = memoization(s, left + 1, right, dp);
            int movingRight = memoization(s, left, right - 1, dp);

            return dp[left][right] = Math.max(movingLeft, movingRight);
        }
    }

    // recursive
    public int recursive(String s, int left, int right) {
        // base condition
        if (left == right) {
            return 1;
        }

        if (left > right)
            return 0;

        // function body
        if (s.charAt(left) == s.charAt(right)) {
            return 2 + recursive(s, left + 1, right - 1);
        } else {
            int movingLeft = recursive(s, left + 1, right);
            int movingRight = recursive(s, left, right - 1);

            return Math.max(movingLeft, movingRight);
        }

    }
}
