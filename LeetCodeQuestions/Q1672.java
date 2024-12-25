/*
 * 1672. Richest Customer Wealth

 * - take the wealth of a single customer
 * - take minimum int variable minimum and initialize it with 0
 * - add the wealth of the customer of each bank
 * - if the total wealth of the customer is > minimum then replace the minimum with the wealth of the current customer
 * - if two or more than two customers have same wealth then return one of that two wealth of the customers
 */

package LeetCodeQuestions;

public class Q1672 {
   public static void main(String[] args){
    int[][] accounts = {{1,2,3},{3,2,1}};
    int[][] accounts2 = {{1,5},{7,3},{3,5}};

    System.out.println(maximumWealth(accounts2));
   }

   static int maximumWealth(int[][] accounts) {
        int max_wealth = 0;

        for(int customer=0; customer<accounts.length; customer++){
            int curr_customer_wealth = get_wealth(accounts[customer]);

            if(curr_customer_wealth > max_wealth){
                max_wealth = curr_customer_wealth;
            }

        }

        return max_wealth;
    }

    static int get_wealth(int[] bank_accounts){
        int total_wealth = 0;

        for(int account=0; account< bank_accounts.length; account++){
            total_wealth += bank_accounts[account];
        }

        return total_wealth;
    }

}
