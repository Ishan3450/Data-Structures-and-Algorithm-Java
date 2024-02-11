package DynamicProgramming;

import java.util.Arrays;

public class BestTimeToBuyAndSellStocksWIthTransactionFee {
    /*
     * Same code as Best time to buy and sell stock 2 just added the transaction fee element
     */
    
    public int maxProfit(int[] prices, int fee) {
        // int[][] dp = new int[prices.length][2];
        // for(int[] row: dp) Arrays.fill(row, -1);

        // return memoization(prices, fee, false, 0, dp);

        return spaceOptimized(prices, fee);
    }

    // space optimization approach
    public int spaceOptimized(int[] prices, int fee) {
        int[] curr = new int[2];
        int[] next = new int[2];

        for (int currDay = prices.length - 1; currDay >= 0; currDay--) {
            for (int isStockBought = 1; isStockBought >= 0; isStockBought--) {
                int profit = 0;

                if (isStockBought == 1) { // ready to sell
                    int selling = prices[currDay] + next[0] - fee;
                    int notSelling = next[1];

                    profit = Math.max(selling, notSelling);
                } else { // ready to buy
                    int buying = next[1] - prices[currDay];
                    int notBuying = next[0];

                    profit = Math.max(buying, notBuying);
                }

                curr[isStockBought] = profit;
            }
            // shifting
            next = Arrays.copyOf(curr, curr.length);
        }
        return curr[0];
    }

    // tabulation approach
    public int tabulation(int[] prices, int fee) {
        int[][] dp = new int[prices.length + 1][2];

        for (int currDay = prices.length - 1; currDay >= 0; currDay--) {
            for (int isStockBought = 1; isStockBought >= 0; isStockBought--) {
                int profit = 0;

                if (isStockBought == 1) { // ready to sell
                    int selling = prices[currDay] + dp[currDay + 1][0] - fee;
                    int notSelling = dp[currDay + 1][1];

                    profit = Math.max(selling, notSelling);
                } else { // ready to buy
                    int buying = dp[currDay + 1][1] - prices[currDay];
                    int notBuying = dp[currDay + 1][0];

                    profit = Math.max(buying, notBuying);
                }

                dp[currDay][isStockBought] = profit;
            }
        }
        return dp[0][0];
    }

    // memoization
    public int memoization(int[] prices, int fee, boolean isStockBought, int currDay, int[][] dp) {
        // base condition
        if (currDay >= prices.length) {
            return 0;
        }

        if (dp[currDay][isStockBought ? 1 : 0] != -1) {
            return dp[currDay][isStockBought ? 1 : 0];
        }

        // function body
        int profit = 0;

        if (isStockBought) { // ready to sell
            int selling = prices[currDay] + memoization(prices, fee, false, currDay + 1, dp) - fee;
            int notSelling = memoization(prices, fee, true, currDay + 1, dp);

            profit = Math.max(selling, notSelling);
        } else { // ready to buy
            int buying = memoization(prices, fee, true, currDay + 1, dp) - prices[currDay];
            int notBuying = memoization(prices, fee, false, currDay + 1, dp);

            profit = Math.max(buying, notBuying);
        }

        dp[currDay][isStockBought ? 1 : 0] = profit;
        return profit;
    }

    // recursive
    public int recursive(int[] prices, int fee, boolean isStockBought, int currDay) {
        // base condition
        if (currDay >= prices.length) {
            return 0;
        }

        // function body
        int profit = 0;

        if (isStockBought) { // ready to sell
            int selling = prices[currDay] + recursive(prices, fee, false, currDay + 1) - fee;
            int notSelling = recursive(prices, fee, true, currDay + 1);

            profit = Math.max(selling, notSelling);
        } else { // ready to buy
            int buying = recursive(prices, fee, true, currDay + 1) - prices[currDay];
            int notBuying = recursive(prices, fee, false, currDay + 1);

            profit = Math.max(buying, notBuying);
        }

        return profit;
    }
}
