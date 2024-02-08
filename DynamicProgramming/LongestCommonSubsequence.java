package DynamicProgramming;

import java.util.Arrays;

public class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        // int[][] dp = new int[text1.length()][text2.length()];
        // for(int[] row: dp) Arrays.fill(row, -1);

        return spaceOptimized(text1, text2);
    }

    // sapce optimized approach
    public int spaceOptimized(String s1, String s2) {
        int sizeOfS1 = s1.length();
        int sizeOfS2 = s2.length();

        // size of the arrays will be of string s2 length because inner loop runs for s2
        // string
        int[] curr = new int[sizeOfS2 + 1];
        int[] next = new int[sizeOfS2 + 1];
        // here created curr and next array not curr and prev array because we are
        // filling the table from sizeofstring to 0 basically from bottom to top

        for (int i = sizeOfS1 - 1; i >= 0; i--) {
            for (int j = sizeOfS2 - 1; j >= 0; j--) {
                int ans = 0;

                if (Character.compare(s1.charAt(i), s2.charAt(j)) == 0) {
                    // same characters encountered, so include it in the subsequence string
                    ans = 1 + next[j + 1];
                } else {
                    // different characters encountered, so search for same ones
                    ans = Math.max(curr[j + 1], next[j]);
                }

                curr[j] = ans;
            }
            // copying because arrays are of reference types
            next = Arrays.copyOf(curr, curr.length);
        }
        return curr[0];
    }

    // tabulation approach
    public int tabulation(String s1, String s2) {
        int sizeOfS1 = s1.length();
        int sizeOfS2 = s2.length();

        int[][] dp = new int[sizeOfS1 + 1][sizeOfS2 + 1];

        for (int i = sizeOfS1 - 1; i >= 0; i--) {
            for (int j = sizeOfS2 - 1; j >= 0; j--) {
                int ans = 0;

                if (Character.compare(s1.charAt(i), s2.charAt(j)) == 0) {
                    // same characters encountered, so include it in the subsequence string
                    ans = 1 + dp[i + 1][j + 1];
                } else {
                    // different characters encountered, so search for same ones
                    ans = Math.max(dp[i][j + 1], dp[i + 1][j]);
                }

                dp[i][j] = ans;
            }
        }
        return dp[0][0];
    }

    // memoization approach
    public int memoization(String s1, String s2, int i, int j, int[][] dp) {
        // base condition
        if (i >= s1.length() || j >= s2.length()) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        // function body
        int ans = 0;
        if (Character.compare(s1.charAt(i), s2.charAt(j)) == 0) {
            // same characters encountered, so include it in the subsequence string
            ans = 1 + memoization(s1, s2, i + 1, j + 1, dp);
        } else {
            // different characters encountered, so search for same ones
            ans = Math.max(memoization(s1, s2, i, j + 1, dp), memoization(s1, s2, i + 1, j, dp));
        }

        dp[i][j] = ans;
        return ans;
    }

    // recursive approach
    public int recursive(String s1, String s2, int i, int j) {
        // base condition
        if (i >= s1.length() || j >= s2.length()) {
            return 0;
        }

        // function body

        if (Character.compare(s1.charAt(i), s2.charAt(j)) == 0) {
            // same characters encountered, so include it in the subsequence string
            return 1 + recursive(s1, s2, i + 1, j + 1);
        }

        // different characters encountered, so search for same ones
        return Math.max(recursive(s1, s2, i, j + 1), recursive(s1, s2, i + 1, j));
    }
}
