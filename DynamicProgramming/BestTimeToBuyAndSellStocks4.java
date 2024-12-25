package DynamicProgramming;

import java.util.Arrays;

public class BestTimeToBuyAndSellStocks4 {
    /*
        100% same code of best time to buy and sell stock 3 problem
    */
    public int maxProfit(int k, int[] prices) {
        // int[][][] dp = new int[prices.length][k+1][2];
        
        // for(int[][] mat: dp){
        //     for(int[] row: mat){
        //         Arrays.fill(row, -1);
        //     }
        // }
        // return memoization(prices, 0, false, k, dp);

        return spaceOptimization(prices, k);
    }

    // space optimized
    public int spaceOptimization(int[] prices, int k){
        int[][] curr = new int[k+1][2];
        int[][] next = new int[k+1][2];

        for(int currDay = prices.length-1; currDay >= 0; currDay --){
            for(int transactionsLeft = 1; transactionsLeft <= k; transactionsLeft ++){
                for(int isStockBought = 1; isStockBought >= 0; isStockBought --){
                    int profit = 0;

                    if(isStockBought == 1){ // we are ready to book some profit :)
                        int selling = prices[currDay] + next[transactionsLeft-1][0]; // A transaction starts after buying and completes after selling, so at this point we are completing a single transaction that's why only at this call we are subtracting a transaction not at any other calls
                        int notSelling = next[transactionsLeft][1];

                        profit = Math.max(selling, notSelling);
                    } else { // get ready to buy on best price
                        int buying = next[transactionsLeft][1] - prices[currDay];
                        int notBuying = next[transactionsLeft][0];

                        profit = Math.max(buying, notBuying);
                    }

                    curr[transactionsLeft][isStockBought] = profit;                
                }
            }
            // shifting
            next = Arrays.copyOf(curr, curr.length);
        }

        return curr[k][0];
    }

    // tabulation 
    public int tabulation(int[] prices, int k){
        int[][][] dp = new int[prices.length+1][k+1][2];

        for(int currDay = prices.length-1; currDay >= 0; currDay --){
            for(int transactionsLeft = 1; transactionsLeft <= k; transactionsLeft ++){
                for(int isStockBought = 1; isStockBought >= 0; isStockBought --){
                    int profit = 0;

                    if(isStockBought == 1){ // we are ready to book some profit :)
                        int selling = prices[currDay] + dp[currDay+1][transactionsLeft-1][0]; // A transaction starts after buying and completes after selling, so at this point we are completing a single transaction that's why only at this call we are subtracting a transaction not at any other calls
                        int notSelling = dp[currDay+1][transactionsLeft][1];

                        profit = Math.max(selling, notSelling);
                    } else { // get ready to buy on best price
                        int buying = dp[currDay+1][transactionsLeft][1] - prices[currDay];
                        int notBuying = dp[currDay+1][transactionsLeft][0];

                        profit = Math.max(buying, notBuying);
                    }

                    dp[currDay][transactionsLeft][isStockBought] = profit;                
                }
            }
        }

        return dp[0][k][0];
    }

    // memoization
    public int memoization(int[] prices, int currDay, boolean isStockBought, int transactionsLeft, int[][][] dp){
        // base condition
        if(currDay >= prices.length || transactionsLeft == 0){
            return 0;
        }

        if(dp[currDay][transactionsLeft][isStockBought ? 1 : 0] != -1){
            return dp[currDay][transactionsLeft][isStockBought ? 1 : 0];
        }

        // function body
        int profit = 0;

        if(isStockBought){ // we are ready to book some profit :)
            int selling = prices[currDay] + memoization(prices, currDay + 1, false, transactionsLeft-1, dp); // A transaction starts after buying and completes after selling, so at this point we are completing a single transaction that's why only at this call we are subtracting a transaction not at any other calls
            int notSelling = memoization(prices, currDay + 1, true, transactionsLeft, dp);

            profit = Math.max(selling, notSelling);
        } else { // get ready to buy on best price
            int buying = memoization(prices, currDay + 1, true, transactionsLeft, dp) - prices[currDay];
            int notBuying = memoization(prices, currDay+1, false, transactionsLeft, dp);

            profit = Math.max(buying, notBuying);
        }

        dp[currDay][transactionsLeft][isStockBought ? 1 : 0] = profit;
        return profit;
    }

    // recursive
    public int recursive(int[] prices, int currDay, boolean isStockBought, int transactionsLeft){
        // base condition
        if(currDay >= prices.length || transactionsLeft == 0){
            return 0;
        }

        // function body
        int profit = 0;

        if(isStockBought){ // we are ready to book some profit :)
            int selling = prices[currDay] + recursive(prices, currDay + 1, false, transactionsLeft-1); // A transaction starts after buying and completes after selling, so at this point we are completing a single transaction that's why only at this call we are subtracting a transaction not at any other calls
            int notSelling = recursive(prices, currDay + 1, true, transactionsLeft);

            profit = Math.max(selling, notSelling);
        } else { // get ready to buy on best price
            int buying = recursive(prices, currDay + 1, true, transactionsLeft) - prices[currDay];
            int notBuying = recursive(prices, currDay+1, false, transactionsLeft);

            profit = Math.max(buying, notBuying);
        }

        return profit;
    }
}
