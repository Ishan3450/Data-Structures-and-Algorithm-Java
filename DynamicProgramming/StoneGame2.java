package DynamicProgramming;

public class StoneGame2 {
     /**
     * Game Strategy Rule:
     * - When it's your turn get the best result possible
     * - When it's your opponent's turn expect the worst possible
     * 
     * Initially M = 1 means X lies between [1, 2] (X always starts with 1)
     * X is the number of piles picked
     * 
     * Approach:
     * 
     * - What question asked is to pick the maximum possible coins for Alice
     * - What we will do is we will keep track a turn and only add the piles value
     * when turn is of Alice
     * - When turn is of Bob just changing of the parameters values will be there
     */

     public int stoneGameII(int[] piles) {
        // edge case
        if(piles.length == 1){
            return piles[0];
        }

        // return getMaximumPossibleStonesForAliceRecursive(piles, 0, 1, true);

        // int[][][] dp = new int[piles.length][piles.length+1][2];
        // for (int[][] mat : dp) {
        //     for (int[] row : mat) {
        //         Arrays.fill(row, -1);
        //     }
        // }
        // return getMaximumPossibleStonesForAliceMemoization(piles, 0, 1, true, dp);

        return getMaximumPossibleStonesForAliceTabulation(piles);
    }

    // tabulation
    public int getMaximumPossibleStonesForAliceTabulation(int[] piles){
        int[][][] dp = new int[piles.length+1][piles.length+1][2];

        for(int start=piles.length-1; start >= 0; start --){
            for(int M = piles.length-1; M >= 0; M --){
                for(int alice = 0; alice <= 1; alice ++){
                    int maximumStonesPossible = alice == 1 ? Integer.MIN_VALUE : Integer.MAX_VALUE; // becuase we are maximizing on alice's turn and minimizing on bob
                    int stones = 0;

                    for (int X = 1; X <= 2 * M; X++) {
                        if (start + X - 1 >= piles.length) {
                            break;
                        }

                        stones += piles[start + X - 1];

                        /**
                        * We are writing this method for Alice so we will maximize the stones on
                        * Alice's turn and minimize the stones on Bob's turn with respect to Game
                        * Strategy's rule.
                        */
                        if (alice == 1) {
                            // maximizing stones
                            maximumStonesPossible = Math.max(maximumStonesPossible, stones
                                    + dp[start+X][Math.max(X, M)][0]);
                        } else { // bob's turn
                            // minimizing stones
                            // notice here we are not adding stones becuase we want score for Alice only
                            maximumStonesPossible = Math.min(maximumStonesPossible, dp[start+X][Math.max(X, M)][1]);
                        }
                    }

                    dp[start][M][alice] = maximumStonesPossible;
                }
            }
        }

        return dp[0][1][1];
    }

    // memoization
    public int getMaximumPossibleStonesForAliceMemoization(int[] piles, int start, int M, boolean alice, int[][][] dp) {
        // base condition
        if (start >= piles.length) {
            return 0;
        }

        if (dp[start][M][alice ? 1 : 0] != -1) {
            return dp[start][M][alice ? 1 : 0];
        }

        // function body
        int maximumStonesPossible = alice ? Integer.MIN_VALUE : Integer.MAX_VALUE; // becuase we are maximizing on alice's turn and minimizing on bob
        int stones = 0;

        for (int X = 1; X <= 2 * M; X++) {
            if (start + X - 1 >= piles.length) {
                break;
            }

            stones += piles[start + X - 1];

            /**
             * We are writing this method for Alice so we will maximize the stones on
             * Alice's turn and minimize the stones on Bob's turn with respect to Game
             * Strategy's rule.
             */
            if (alice) {
                // maximizing stones
                maximumStonesPossible = Math.max(maximumStonesPossible, stones
                        + getMaximumPossibleStonesForAliceMemoization(piles, start + X, Math.max(X, M), false, dp));
            } else { // bob's turn
                // minimizing stones
                // notice here we are not adding stones becuase we want score for Alice only
                maximumStonesPossible = Math.min(maximumStonesPossible,
                        getMaximumPossibleStonesForAliceMemoization(piles, start + X, Math.max(X, M), true, dp));
            }
        }

        return dp[start][M][alice ? 1 : 0] = maximumStonesPossible;
    }

    // recursive
    public int getMaximumPossibleStonesForAliceRecursive(int[] piles, int start, int M, boolean alice) {
        // base condition
        if (start >= piles.length) {
            return 0;
        }

        // function body
        int maximumStonesPossible = alice ? Integer.MIN_VALUE : Integer.MAX_VALUE; // becuase we are maximizing on alice's turn and minimizing on bob
        int stones = 0;

        for (int X = 1; X <= 2 * M; X++) {
            if (start + X - 1 >= piles.length) {
                break;
            }

            stones += piles[start + X - 1];

            /**
             * We are writing this method for Alice so we will maximize the stones on
             * Alice's turn and minimize the stones on Bob's turn with respect to Game
             * Strategy's rule.
             */
            if (alice) {
                // maximizing stones
                maximumStonesPossible = Math.max(maximumStonesPossible,
                        stones + getMaximumPossibleStonesForAliceRecursive(piles, start + X, Math.max(X, M), false));
            } else { // bob's turn
                // minimizing stones
                // notice here we are not adding stones becuase we want score for Alice only
                maximumStonesPossible = Math.min(maximumStonesPossible,
                        getMaximumPossibleStonesForAliceRecursive(piles, start + X, Math.max(X, M), true));
            }
        }

        return maximumStonesPossible;
    }
}
