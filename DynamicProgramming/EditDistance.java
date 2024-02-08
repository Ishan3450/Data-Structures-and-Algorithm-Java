package DynamicProgramming;

import java.util.Arrays;

public class EditDistance {
    public int minDistance(String word1, String word2) {
        if (word1.length() == 0) {
            return word2.length();
        }

        if (word2.length() == 0) {
            return word1.length();
        }

        // int[][] dp = new int[word1.length()][word2.length()];
        // for(int[] row: dp){
        // Arrays.fill(row, -1);
        // }

        return spaceOptimized(word1, word2);
    }

    // space optimization
    public int spaceOptimized(String s1, String s2) {
        int[] curr = new int[s2.length() + 1];
        int[] next = new int[s2.length() + 1];

        /*
         * Important Part
         * ====================================================================
         */

        for (int j = 0; j <= s2.length(); j++) {
            next[j] = s2.length() - j;
        }

        /* ==================================================================== */

        for (int i = s1.length() - 1; i >= 0; i--) {
            /*
             * Important Part
             * ====================================================================
             */
            // below line is equivalen to --> dp[i][s2.length()] = s1.length() - i; in loop
            curr[s2.length()] = s1.length() - i;
            /* ==================================================================== */

            for (int j = s2.length() - 1; j >= 0; j--) {
                int ans = 0;

                if (Character.compare(s1.charAt(i), s2.charAt(j)) == 0) {
                    ans = next[j + 1];
                } else { // different characters found
                    // if different characters found then we will apply all the operations mentioned
                    // in the problem description

                    int opDelete = 1 + next[j];
                    int opInsert = 1 + curr[j + 1];
                    int opReplace = 1 + next[j + 1];

                    ans = Math.min(opDelete, Math.min(opInsert, opReplace));
                }

                curr[j] = ans;
            }
            // shifting is important
            next = Arrays.copyOf(curr, curr.length);
        }

        return curr[0];
    }

    // tabulation approach
    public int tabulation(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];

        /*
         * Important Part
         * ====================================================================
         */

        for (int j = 0; j <= s2.length(); j++) {
            dp[s1.length()][j] = s2.length() - j;
        }

        for (int i = 0; i <= s1.length(); i++) {
            dp[i][s2.length()] = s1.length() - i;
        }

        /*
         * Above 2 loops fills the matrix like:
         * [0, 0, 0, 0, 0, 5]
         * [0, 0, 0, 0, 0, 4]
         * [0, 0, 0, 0, 0, 3]
         * [0, 0, 0, 0, 0, 2]
         * [0, 0, 0, 0, 0, 1]
         * [5, 4, 3, 2, 1, 0]
         */

        for (int i = s1.length() - 1; i >= 0; i--) {
            for (int j = s2.length() - 1; j >= 0; j--) {
                int ans = 0;

                if (Character.compare(s1.charAt(i), s2.charAt(j)) == 0) {
                    ans = dp[i + 1][j + 1];
                } else { // different characters found
                    // if different characters found then we will apply all the operations mentioned
                    // in the problem description

                    int opDelete = 1 + dp[i + 1][j];
                    int opInsert = 1 + dp[i][j + 1];
                    int opReplace = 1 + dp[i + 1][j + 1];

                    ans = Math.min(opDelete, Math.min(opInsert, opReplace));
                }

                dp[i][j] = ans;
            }
        }

        return dp[0][0];
    }

    // memoization approach
    public int memoization(String s1, String s2, int i, int j, int[][] dp) {
        // base condition
        if (i >= s1.length()) {
            if (j < s2.length()) { // if j is in range
                return s2.length() - j;
            }
            return 0; // if j is out of range simply return 0
        }

        if (j >= s2.length()) { // same as above case
            if (i < s1.length()) {
                return s1.length() - i;
            }
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        // function body
        int ans = 0;
        if (Character.compare(s1.charAt(i), s2.charAt(j)) == 0) {
            ans = memoization(s1, s2, i + 1, j + 1, dp);
        } else { // different characters found

            // if different characters found then we will apply all the operations mentioned
            // in the problem description

            int opDelete = 1 + memoization(s1, s2, i + 1, j, dp);
            int opInsert = 1 + memoization(s1, s2, i, j + 1, dp);
            int opReplace = 1 + memoization(s1, s2, i + 1, j + 1, dp);

            ans = Math.min(opDelete, Math.min(opInsert, opReplace));
        }
        dp[i][j] = ans;
        return ans;
    }

    // recursive approach
    public int recursive(String s1, String s2, int i, int j) {
        // base condition
        if (i >= s1.length()) {
            if (j < s2.length()) { // if j is in range
                return s2.length() - j;
            }
            return 0; // if j is out of range simply return 0
        }

        if (j >= s2.length()) { // same as above case
            if (i < s1.length()) {
                return s1.length() - i;
            }
            return 0;
        }

        // function body
        int ans = 0;
        if (Character.compare(s1.charAt(i), s2.charAt(j)) == 0) {
            ans = recursive(s1, s2, i + 1, j + 1);
        } else { // different characters found

            // if different characters found then we will apply all the operations mentioned
            // in the problem description

            int opDelete = 1 + recursive(s1, s2, i + 1, j);
            int opInsert = 1 + recursive(s1, s2, i, j + 1);
            int opReplace = 1 + recursive(s1, s2, i + 1, j + 1);

            ans = Math.min(opDelete, Math.min(opInsert, opReplace));
        }
        return ans;
    }
}
