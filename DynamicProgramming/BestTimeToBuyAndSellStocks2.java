/* 
 * On each day we can either buy that stock, sell that stock or skip that day.
 * 
 * At each day:
 * 1. Buy
 * 2. Sell
 * 3. Skip
 * 
 * - Either we can buy on ith day or skip buying on that ith day.
 * - But to buy in the questions it is mentioned that we can only keep a single stock at a time. So we will ensure that we have not bought any of the stock from previous days.
 * 
 * - Same for selling that we can either sell on that day or skip selilng the stock on that day.
 * - But to sell we must ensure that we have bought a stock from any of the previous days.
 * 
 * Now we know when we have to buy or sell.
 * 
 * ** Approach: **
 * 
 * For buying:
 *     - We will first ensure that we have not bought any of the stock.
 *     - Then we can either buy on that day.
 *     - Or skip that day.
 * 
 * For selling:
 *     - We will first ensure that we have bought a stock from previous days.
 *     - Then we can sell on that day.
 *     - Or we will skip to sell on that day.
 */

package DynamicProgramming;

import java.util.Arrays;

public class BestTimeToBuyAndSellStocks2 {
    public int maxProfit(int[] prices) {
        // int[][] dp = new int[prices.length][2];
        // for(int[] row: dp) Arrays.fill(row, -1);

        return spaceOptimized(prices, prices.length);
    }

    // most optimized GREEDY APPROACH UNINTIUTIVE APPROACH
    public int greedy(int[] prices, int n) {
        int profit = 0;

        for (int i = 1; i < n; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }

        return profit;
    }

    // space optimization
    public int spaceOptimized(int[] prices, int n) {
        int[] curr = { 0, 0 };
        int[] next = { 0, 0 };

        for (int currDay = n - 1; currDay >= 0; currDay--) {
            for (int isStockBought = 0; isStockBought < 2; isStockBought++) {
                int profit = 0;

                if (isStockBought == 1) { // we are ready to book some green profit ;)
                    int sellingOnCurrDay = prices[currDay] + next[0]; // passing false as we have sold our stock and
                                                                      // ready for future profit bookings
                    int skippingSellOnCurrDay = next[1];

                    profit = Math.max(sellingOnCurrDay, skippingSellOnCurrDay);
                } else { // we are ready to pick the best price

                    int buyingOnCurrDay = next[1] - prices[currDay]; // we are buying that's why passing true and
                                                                     // subtracting current day price from the profit we
                                                                     // will be receiving from the recursive call
                    int skippingBuyOnCurrDay = next[0];

                    profit = Math.max(buyingOnCurrDay, skippingBuyOnCurrDay);
                }

                curr[isStockBought] = profit;
            }
            // shifting
            next = Arrays.copyOf(curr, curr.length);
        }
        return curr[0];
    }

    // tabulation appraoch
    public int tabulation(int[] prices, int n) {
        int[][] dp = new int[n + 1][2];

        for (int currDay = n - 1; currDay >= 0; currDay--) {
            for (int isStockBought = 0; isStockBought < 2; isStockBought++) {
                int profit = 0;

                if (isStockBought == 1) { // we are ready to book some green profit ;)
                    int sellingOnCurrDay = prices[currDay] + dp[currDay + 1][0]; // passing false as we have sold our
                                                                                 // stock and ready for future profit
                                                                                 // bookings
                    int skippingSellOnCurrDay = dp[currDay + 1][1];

                    profit = Math.max(sellingOnCurrDay, skippingSellOnCurrDay);
                } else { // we are ready to pick the best price

                    int buyingOnCurrDay = dp[currDay + 1][1] - prices[currDay]; // we are buying that's why passing true
                                                                                // and subtracking current day price
                                                                                // from the profit we will be receiving
                                                                                // from the recursive call
                    int skippingBuyOnCurrDay = dp[currDay + 1][0];

                    profit = Math.max(buyingOnCurrDay, skippingBuyOnCurrDay);
                }

                dp[currDay][isStockBought] = profit;
            }
        }
        return dp[0][0];
    }

    // memoization appraoch
    public int memoization(int[] prices, int currDay, boolean isStockBought, int[][] dp) {
        // base condition
        if (currDay >= prices.length) {
            return 0;
        }

        if (dp[currDay][isStockBought ? 1 : 0] != -1) {
            return dp[currDay][isStockBought ? 1 : 0];
        }

        // function body
        int profit = 0;

        if (isStockBought) { // we are ready to book some green profit ;)
            int sellingOnCurrDay = prices[currDay] + memoization(prices, currDay + 1, false, dp); // passing false as we
                                                                                                  // have sold our stock
                                                                                                  // and ready for
                                                                                                  // future profit
                                                                                                  // bookings
            int skippingSellOnCurrDay = memoization(prices, currDay + 1, true, dp);

            profit = Math.max(sellingOnCurrDay, skippingSellOnCurrDay);
        } else { // we are ready to pick the best price

            int buyingOnCurrDay = memoization(prices, currDay + 1, true, dp) - prices[currDay]; // we are buying that's
                                                                                                // why passing true and
                                                                                                // subtracking current
                                                                                                // day price from the
                                                                                                // profit we will be
                                                                                                // receiving from the
                                                                                                // recursive call
            int skippingBuyOnCurrDay = memoization(prices, currDay + 1, false, dp);

            profit = Math.max(buyingOnCurrDay, skippingBuyOnCurrDay);
        }

        dp[currDay][isStockBought ? 1 : 0] = profit;
        return profit;
    }

    // recursive approach
    public int recursive(int[] prices, int currDay, boolean isStockBought) {
        // base condition
        if (currDay >= prices.length) {
            return 0;
        }

        // function body
        int profit = 0;

        if (isStockBought) { // we are ready to book some green profit ;)
            int sellingOnCurrDay = prices[currDay] + recursive(prices, currDay + 1, false); // passing false as we have
                                                                                            // sold our stock and ready
                                                                                            // for future profit
                                                                                            // bookings
            int skippingSellOnCurrDay = recursive(prices, currDay + 1, true);

            profit = Math.max(sellingOnCurrDay, skippingSellOnCurrDay);
        } else { // we are ready to pick the best price

            int buyingOnCurrDay = recursive(prices, currDay + 1, true) - prices[currDay]; // we are buying that's why
                                                                                          // passing true and
                                                                                          // subtracking current day
                                                                                          // price from the profit we
                                                                                          // will be receiving from the
                                                                                          // recursive call
            int skippingBuyOnCurrDay = recursive(prices, currDay + 1, false);

            profit = Math.max(buyingOnCurrDay, skippingBuyOnCurrDay);
        }

        return profit;
    }
}
