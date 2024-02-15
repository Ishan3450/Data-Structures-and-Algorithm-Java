package DynamicProgramming;

public class StoneGame1 {
    public boolean stoneGame(int[] piles) {
        // int totalStones = 0;
        // for (int pile : piles)
            // totalStones += pile;

        // int[][] dp = new int[piles.length][piles.length];
        // for(int[] row: dp) Arrays.fill(row, -1);

        // int maxPossibleStonesForAlice = maxStonesPossibleForAliceRecursive(piles, 0,
        // piles.length-1);
        // int maxPossibleStonesForAlice = maxStonesPossibleForAliceMemoization(piles,
        // 0, piles.length-1, dp);
        // int maxPossibleStonesForAlice = maxStonesPossibleForAliceTabulation(piles);
        // int maxPossibleStonesForAlice = maxStonesPossibleForAliceSpaceOptimized(piles);
        // int maxPossibleStonesForBob = totalStones - maxPossibleStonesForAlice;

        // return maxPossibleStonesForAlice > maxPossibleStonesForBob;
        
        return mostOptimal(); // alice will win in all the cases
    }

    // most optimal
    public boolean mostOptimal() { return true; }


    // space optimized
    public int maxStonesPossibleForAliceSpaceOptimized(int[] piles) {
        int[] curr = new int[piles.length + 2];
        int[] next = new int[piles.length + 2];
        int[] nextToNext = new int[piles.length + 2];

        /**
         * +2 Adjustment is made for the end variable
         */

        for (int start = piles.length - 1; start >= 0; start--) {
            for (int end = start; end < piles.length; end++) {
                int takingFirstPile = piles[start] + Math.min(nextToNext[end + 2], next[end - 1 + 2]);
                int takingLastPile = piles[end] + Math.min(curr[end - 2 + 2], next[end - 1 + 2]);

                curr[end + 2] = Math.max(takingFirstPile, takingLastPile);
            }
            // shifting
            nextToNext = next.clone();
            next = curr.clone();
        }

        return curr[piles.length - 1 + 2];
    }

    // tabulation
    public int maxStonesPossibleForAliceTabulation(int[] piles) {
        int[][] dp = new int[piles.length + 2][piles.length + 2];

        /**
         * +2 Adjustment is made for the end variable
         */

        for (int start = piles.length - 1; start >= 0; start--) {
            for (int end = start; end < piles.length; end++) {
                int takingFirstPile = piles[start] + Math.min(dp[start + 2][end + 2], dp[start + 1][end - 1 + 2]);
                int takingLastPile = piles[end] + Math.min(dp[start][end - 2 + 2], dp[start + 1][end - 1 + 2]);

                dp[start][end + 2] = Math.max(takingFirstPile, takingLastPile);
            }
        }

        return dp[0][piles.length - 1 + 2];
    }

    // memoization
    public int maxStonesPossibleForAliceMemoization(int[] piles, int start, int end, int[][] dp) {
        // base condition
        if (start > end) {
            return 0;
        }

        if (dp[start][end] != -1) {
            return dp[start][end];
        }

        // function body
        int takingFirstPile = piles[start] + Math.min(maxStonesPossibleForAliceMemoization(piles, start + 2, end, dp),
                maxStonesPossibleForAliceMemoization(piles, start + 1, end - 1, dp));
        int takingLastPile = piles[end] + Math.min(maxStonesPossibleForAliceMemoization(piles, start, end - 2, dp),
                maxStonesPossibleForAliceMemoization(piles, start + 1, end - 1, dp));

        return dp[start][end] = Math.max(takingFirstPile, takingLastPile);
    }

    // recursive
    public int maxStonesPossibleForAliceRecursive(int[] piles, int start, int end) {
        // base condition
        if (start > end) {
            return 0;
        }

        // function body
        int takingFirstPile = piles[start] + Math.min(maxStonesPossibleForAliceRecursive(piles, start + 2, end),
                maxStonesPossibleForAliceRecursive(piles, start + 1, end - 1));
        int takingLastPile = piles[end] + Math.min(maxStonesPossibleForAliceRecursive(piles, start, end - 2),
                maxStonesPossibleForAliceRecursive(piles, start + 1, end - 1));

        return Math.max(takingFirstPile, takingLastPile);
    }
}
