package DynamicProgramming;

import java.util.Arrays;

// LC 322

public class CoinChange {
    // normal recursive approach, will give TLE
    private int recursive(int[] coins, int amount, int coinsUsed){
        // base condition
        if(amount == 0){
            return coinsUsed;
        }

        if(amount < 0){
            return Integer.MAX_VALUE;
        }

        // function body
        int minCoinUsed = Integer.MAX_VALUE;

        for(int i = 0 ; i < coins.length ; i ++){
            minCoinUsed = Math.min(minCoinUsed, recursive(coins, amount - coins[i], coinsUsed+1));
        }

        return minCoinUsed;
    }

    // Recursive top down memoization appraoch
    private int topDownMemoization(int[] coins, int amount, int[] dp){
        // base condition
        if(amount == 0){
            return 0;
        }

        if(amount < 0){
            return Integer.MAX_VALUE;
        }

        // function body
        if(dp[amount] != -1){
            return dp[amount];
        }

        int minimumCoins = Integer.MAX_VALUE;

        for(int i = 0; i < coins.length; i ++){
            int ans = topDownMemoization(coins, amount - coins[i], dp);

            if(ans != Integer.MAX_VALUE)
                minimumCoins = Math.min(minimumCoins, 1 + ans);
        }

        dp[amount] = minimumCoins;
        return minimumCoins;
    }

    // bottom-up tabulation approach
    public int bottomUpTabulation(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0] = 0;

        for(int target = 1; target <= amount; target ++){
            int minimumCoins = Integer.MAX_VALUE;

            for(int i = 0; i < coins.length; i ++){
                int currCoin = coins[i];

                if(target - currCoin >= 0){
                    int ans = dp[target - currCoin];

                    if(ans != Integer.MAX_VALUE){
                        dp[target] = Math.min(dp[target], 1 + ans);
                    }
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

    
}
