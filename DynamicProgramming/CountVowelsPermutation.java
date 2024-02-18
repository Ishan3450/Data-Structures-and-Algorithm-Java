package DynamicProgramming;

public class CountVowelsPermutation {
    /*
     * Vowels followed by another vowels
     * a -> e
     * e -> a, i
     * i -> a, e, o, u
     * o -> i, u
     * u -> a
     * 
     * Mapping each character with a number
     * a -> 1
     * e -> 2
     * i -> 3
     * o -> 4
     * y -> 5
     * 
     * :
     * 1 -> 2
     * 2 -> 1,3
     * 3 -> 1,2,4,5
     * 4 -> 3,5
     * 5 -> 1
     * 
     * 
     * Approach:
     * 
     * - if 2, 3 or 5 is there then we can call 1
     * - if 1 or 3 is there can call 2
     * - if 2 or 4 is there we can call 3
     * - if 3 is there we can call 4
     * - if 3 or 4 is there we cal call 5
     * 
     */

    final int MOD = 1000000007;

    public int countVowelPermutation(int n) {
        // return recursive(n, 0);

        // int[][] dp = new int[n+1][6];
        // for(int[] row: dp) Arrays.fill(row, -1);
        // return memoization(n, 0, dp);

        // return tabulation(n);
        return spaceOptimized(n);
    }

    // space optimized
    public int spaceOptimized(int len) {
        int[] prev = new int[6];
        int[] curr = new int[6];

        // settingup base condition
        for (int col = 0; col < 6; col++) {
            prev[col] = 1;
        }

        for (int n = 1; n <= len; n++) {
            for (int vowel = 0; vowel <= 5; vowel++) {
                int total = 0;

                if (vowel == 0) {
                    for (int i = 1; i <= 5; i++) {
                        total = (total + (prev[i] % MOD)) % MOD;
                    }
                } else {
                    if (vowel == 2 || vowel == 3 || vowel == 5) {
                        total = (total + (prev[1] % MOD)) % MOD;
                    }

                    if (vowel == 1 || vowel == 3) {
                        total = (total + (prev[2] % MOD)) % MOD;
                    }

                    if (vowel == 2 || vowel == 4) {
                        total = (total + (prev[3] % MOD)) % MOD;
                    }

                    if (vowel == 3) {
                        total = (total + (prev[4] % MOD)) % MOD;
                    }

                    if (vowel == 3 || vowel == 4) {
                        total = (total + (prev[5] % MOD)) % MOD;
                    }
                }

                curr[vowel] = total;
            }
            // shifting
            prev = curr.clone();
        }
        return curr[0];
    }

    // tabulation
    public int tabulation(int len) {
        int[][] dp = new int[len + 1][6];

        // settingup base condition
        for (int col = 0; col < 6; col++) {
            dp[0][col] = 1;
        }

        for (int n = 1; n <= len; n++) {
            for (int vowel = 0; vowel <= 5; vowel++) {
                int total = 0;

                if (vowel == 0) {
                    for (int i = 1; i <= 5; i++) {
                        total = (total + (dp[n - 1][i] % MOD)) % MOD;
                    }
                } else {
                    if (vowel == 2 || vowel == 3 || vowel == 5) {
                        total = (total + (dp[n - 1][1] % MOD)) % MOD;
                    }

                    if (vowel == 1 || vowel == 3) {
                        total = (total + (dp[n - 1][2] % MOD)) % MOD;
                    }

                    if (vowel == 2 || vowel == 4) {
                        total = (total + (dp[n - 1][3] % MOD)) % MOD;
                    }

                    if (vowel == 3) {
                        total = (total + (dp[n - 1][4] % MOD)) % MOD;
                    }

                    if (vowel == 3 || vowel == 4) {
                        total = (total + (dp[n - 1][5] % MOD)) % MOD;
                    }
                }

                dp[n][vowel] = total;
            }
        }
        return dp[len][0];
    }

    // memoization
    public int memoization(int n, int vowel, int[][] dp) {
        // base condition
        if (n == 0) {
            return 1;
        }

        if (dp[n][vowel] != -1) {
            return dp[n][vowel];
        }

        // function body
        int total = 0;
        if (vowel == 0) {
            for (int i = 1; i <= 5; i++) {
                total = (total + (memoization(n - 1, i, dp) % MOD)) % MOD;
            }
        } else {
            if (vowel == 2 || vowel == 3 || vowel == 5) {
                total = (total + (memoization(n - 1, 1, dp) % MOD)) % MOD;
            }

            if (vowel == 1 || vowel == 3) {
                total = (total + (memoization(n - 1, 2, dp) % MOD)) % MOD;
            }

            if (vowel == 2 || vowel == 4) {
                total = (total + (memoization(n - 1, 3, dp) % MOD)) % MOD;
            }

            if (vowel == 3) {
                total = (total + (memoization(n - 1, 4, dp) % MOD)) % MOD;
            }

            if (vowel == 3 || vowel == 4) {
                total = (total + (memoization(n - 1, 5, dp) % MOD)) % MOD;
            }
        }

        return dp[n][vowel] = total;
    }

    // recursive
    public int recursive(int n, int vowel) {
        // base condition
        if (n == 0) {
            return 1;
        }

        // function body
        int total = 0;
        if (vowel == 0) {
            for (int i = 1; i <= 5; i++) {
                total += recursive(n - 1, i) % MOD;
            }
        } else {
            if (vowel == 2 || vowel == 3 || vowel == 5) {
                total += recursive(n - 1, 1) % MOD;
            }

            if (vowel == 1 || vowel == 3) {
                total += recursive(n - 1, 2) % MOD;
            }

            if (vowel == 2 || vowel == 4) {
                total += recursive(n - 1, 3) % MOD;
            }

            if (vowel == 3) {
                total += recursive(n - 1, 4) % MOD;
            }

            if (vowel == 3 || vowel == 4) {
                total += recursive(n - 1, 5) % MOD;
            }
        }

        return total;
    }
}
