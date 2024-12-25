package DynamicProgramming;

public class DistinctSubsequences {
    public int numDistinct(String s, String t) {
        // return recursive(s, t, 0, 0);

        // int[][] dp = new int[s.length()][t.length()];
        // for(int[] row: dp) Arrays.fill(row, -1);
        // return memoization(s, t, 0, 0, dp);

        return spaceOptimized(s, t);
    }

    // space optimized
    public int spaceOptimized(String s, String t) {
        int[] curr = new int[t.length() + 1];
        int[] next = new int[t.length() + 1];

        // initial base case setting
        next[t.length()] = 1;
        curr[t.length()] = 1;

        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = t.length() - 1; j >= 0; j--) {
                int include = 0;
                if (s.charAt(i) == t.charAt(j)) {
                    include = next[j + 1];
                }

                // exclude
                int exclude = next[j];

                curr[j] = include + exclude;
            }
            // shifting
            next = curr.clone();
        }
        return curr[0];
    }

    // tabulation approach
    public int tabulation(String s, String t) {
        int[][] dp = new int[s.length() + 1][t.length() + 1];

        // initial base case setting
        dp[s.length()][t.length()] = 1;

        for (int i = 0; i < s.length(); i++) {
            dp[i][t.length()] = 1;
        }
        //

        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = t.length() - 1; j >= 0; j--) {
                int include = 0;
                if (s.charAt(i) == t.charAt(j)) {
                    include = dp[i + 1][j + 1];
                }

                // exclude
                int exclude = dp[i + 1][j];

                dp[i][j] = include + exclude;
            }
        }
        return dp[0][0];
    }

    // memoization approach
    public int memoization(String s, String t, int i, int j, int[][] dp) {
        // base condition
        if (i >= s.length() && j >= t.length()) {
            return 1;
        }

        if (j >= t.length()) {
            return 1;
        }

        if (i >= s.length()) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        // function body

        // include only when both characters matches
        int include = 0;
        if (s.charAt(i) == t.charAt(j)) {
            include = memoization(s, t, i + 1, j + 1, dp);
        }

        // exclude
        int exclude = memoization(s, t, i + 1, j, dp);

        return dp[i][j] = include + exclude;
    }

    // recursive approach
    public int recursive(String s, String t, int i, int j) {
        // base condition
        if (i >= s.length() && j >= t.length()) {
            return 1;
        }

        if (j >= t.length()) {
            return 1;
        }

        if (i >= s.length()) {
            return 0;
        }

        // function body

        // include only when both characters matches
        int include = 0;
        if (s.charAt(i) == t.charAt(j)) {
            include = recursive(s, t, i + 1, j + 1);
        }

        // exclude
        int exclude = recursive(s, t, i + 1, j);

        return include + exclude;
    }
}
