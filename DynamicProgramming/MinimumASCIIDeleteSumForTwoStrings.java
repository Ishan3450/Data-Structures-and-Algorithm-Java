package DynamicProgramming;


// when both chars are equal i ++ j ++
// when chars are not equal min(i ++, j ++)

public class MinimumASCIIDeleteSumForTwoStrings {
    public int minimumDeleteSum(String s1, String s2) {
        // int[][] dp = new int[s1.length()][s2.length()];
        // for(int[] row: dp) Arrays.fill(row, -1);

        // return memoization(s1, s2, 0, 0, dp);
        return spaceOptimized(s1, s2);
    }

    // space optimized approach
    public int spaceOptimized(String s1, String s2){
        int[] curr = new int[s2.length()+1];
        int[] next = new int[s2.length()+1];

        /* Important Part (Based on base condition in memoization approach) ========================*/
        for(int j = s2.length()-1; j >= 0; j--){
            next[j] = next[j+1] + ((int) s2.charAt(j));
        }
        /* ======================================================================================== */


        for(int i = s1.length()-1; i >= 0; i--){
            /* Important Part (Based on base condition in memoization approach) ========================*/            
            curr[s2.length()] = next[s2.length()] + ((int) s1.charAt(i));
            /* ======================================================================================== */

            for(int j = s2.length()-1; j >= 0; j--){
                char s1char = s1.charAt(i);
                char s2char = s2.charAt(j);

                if (s1char == s2char) {
                    curr[j] = next[j+1];
                } else {
                    int deletingS1Char = ((int) s1char) + next[j];
                    int deletingS2Char = ((int) s2char) + curr[j+1];

                    curr[j] = Math.min(deletingS1Char, deletingS2Char);
                }
            }
            // shifting
            next = curr.clone();
        }

        return curr[0];
    }


    // tabulation approach
    public int tabulation(String s1, String s2){
        int[][] dp = new int[s1.length()+1][s2.length()+1];

        /* Important Part (Based on base condition in memoization approach) ========================*/
        for(int j = s2.length()-1; j >= 0; j--){
            dp[s1.length()][j] = dp[s1.length()][j+1] + ((int) s2.charAt(j));
        }

        for(int i = s1.length()-1; i >= 0 ; i --){
            dp[i][s2.length()] = dp[i+1][s2.length()] + ((int) s1.charAt(i));
        }
        /* ======================================================================================== */


        for(int i = s1.length()-1; i >= 0; i--){
            for(int j = s2.length()-1; j >= 0; j--){
                char s1char = s1.charAt(i);
                char s2char = s2.charAt(j);

                if (s1char == s2char) {
                    dp[i][j] = dp[i+1][j+1];
                } else {
                    int deletingS1Char = ((int) s1char) + dp[i+1][j];
                    int deletingS2Char = ((int) s2char) + dp[i][j+1];

                    dp[i][j] = Math.min(deletingS1Char, deletingS2Char);
                }
            }
        }

        return dp[0][0];
    }

    // memoization approach
    public int memoization(String s1, String s2, int i, int j, int[][] dp) {
        // base condition
        if (i >= s1.length() && j >= s2.length()) {
            return 0;
        }

        if (i >= s1.length()) {
            int remainingAsciiScore = 0;
            while (j < s2.length()) {
                remainingAsciiScore += (int) s2.charAt(j);
                j++;
            }
            return remainingAsciiScore;
        }

        if (j >= s2.length()) {
            int remainingAsciiScore = 0;
            while (i < s1.length()) {
                remainingAsciiScore += (int) s1.charAt(i);
                i++;
            }
            return remainingAsciiScore;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        // function body
        char s1char = s1.charAt(i);
        char s2char = s2.charAt(j);

        if (s1char == s2char) {
            dp[i][j] = memoization(s1, s2, i + 1, j + 1, dp);
        } else {
            int deletingS1Char = ((int) s1char) + memoization(s1, s2, i + 1, j, dp);
            int deletingS2Char = ((int) s2char) + memoization(s1, s2, i, j + 1, dp);

            dp[i][j] = Math.min(deletingS1Char, deletingS2Char);
        }
        return dp[i][j];
    }   

    // recursive appraoch
    public int recursive(String s1, String s2, int i, int j) {
        // base condition
        if (i >= s1.length() && j >= s2.length()) {
            return 0;
        }

        if (i >= s1.length()) {
            int remainingAsciiScore = 0;
            while (j < s2.length()) {
                remainingAsciiScore += (int) s2.charAt(j);
                j++;
            }
            return remainingAsciiScore;
        }

        if (j >= s2.length()) {
            int remainingAsciiScore = 0;
            while (i < s1.length()) {
                remainingAsciiScore += (int) s1.charAt(i);
                i++;
            }
            return remainingAsciiScore;
        }

        // function body
        char s1char = s1.charAt(i);
        char s2char = s2.charAt(j);

        if (s1char == s2char) {
            return recursive(s1, s2, i + 1, j + 1);
        }

        int deletingS1Char = ((int) s1char) + recursive(s1, s2, i + 1, j);
        int deletingS2Char = ((int) s2char) + recursive(s1, s2, i, j + 1);

        return Math.min(deletingS1Char, deletingS2Char);
    }
}
