/*
 * LC: 121
 */
class BestTimeToBuyAndSellStock {
    // iterative way
    public int maxProfit(int[] prices) {
        int maxProfit = Integer.MIN_VALUE;
        int lowestPriceOfADay = Integer.MAX_VALUE;

        for(int elem: prices){
            // in case we got a stock price of a day less than the lowestPriceOfADay we got then update it
            lowestPriceOfADay = elem < lowestPriceOfADay ? elem : lowestPriceOfADay;
            // calculating current day profit
            int currentDayProfit = elem - lowestPriceOfADay;

            // if current day profit is greater than the maxProfit the will update it
            maxProfit = currentDayProfit > maxProfit ? currentDayProfit : maxProfit;
        }

        return maxProfit;
    }

    // recursive way
    public int maxProfit2(int[] prices) {
        return helper(prices, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public int helper(int[] prices, int i, int maxProfit, int minPrice){
        // base condition
        if(i == prices.length){
            return maxProfit;
        }

        // function body
        minPrice = Math.min(minPrice, prices[i]);
        maxProfit = Math.max(maxProfit, prices[i] - minPrice);

        // recursive call
        return helper(prices, i+1, maxProfit, minPrice);
    }

}