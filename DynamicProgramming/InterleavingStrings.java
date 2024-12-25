package DynamicProgramming;

public class InterleavingStrings {
    public boolean isInterleave(String s1, String s2, String s3) {
        // return recursive(s1, s2, s3, 0, 0, 0);

        Boolean[][][] dp = new Boolean[s1.length() + 1][s2.length() + 1][s3.length() + 1];
        return memoization(s1, s2, s3, 0, 0, 0, dp);
    }

    // memoization
    public boolean memoization(String s1, String s2, String s3, int i, int j, int k, Boolean[][][] dp) {
        // base condition
        if (i >= s1.length() && j >= s2.length() && k >= s3.length()) {
            return true;
        }

        if (k >= s3.length()) {
            return false;
        }

        if (dp[i][j][k] != null) {
            return dp[i][j][k];
        }

        // function body
        boolean isInterleaved = false;

        if (i < s1.length() && s1.charAt(i) == s3.charAt(k)) {
            isInterleaved = isInterleaved || memoization(s1, s2, s3, i + 1, j, k + 1, dp);
        }

        if (j < s2.length() && s2.charAt(j) == s3.charAt(k)) {
            isInterleaved = isInterleaved || memoization(s1, s2, s3, i, j + 1, k + 1, dp);
        }

        dp[i][j][k] = isInterleaved;
        return isInterleaved;
    }

    // recursive
    public boolean recursive(String s1, String s2, String s3, int i, int j, int k) {
        // base condition
        if (i >= s1.length() && j >= s2.length() && k >= s3.length()) {
            return true;
        }

        if (k >= s3.length()) {
            return false;
        }

        // function body
        boolean isInterleaved = false;

        if (i < s1.length() && s1.charAt(i) == s3.charAt(k)) {
            isInterleaved = isInterleaved || recursive(s1, s2, s3, i + 1, j, k + 1);
        }

        if (j < s2.length() && s2.charAt(j) == s3.charAt(k)) {
            isInterleaved = isInterleaved || recursive(s1, s2, s3, i, j + 1, k + 1);
        }

        return isInterleaved;
    }
}
