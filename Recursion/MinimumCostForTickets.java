// LC: 983 Self approached problem
/*
 * TC: O(3^N)
 * SC: O(N)
 */

package Recursion;

public class MinimumCostForTickets {
    // method 1 taking an extra sum varible as an arguement
    public int helper(int[] days, int di, int[] costs, int sum){
        // base condition
        if(di >= days.length){
            return sum;
        }

        // function body + rec calls
        // a call for 1-day trip
        int oneDay = helper(days, di+1, costs, sum + costs[0]);

        // a call for 7-days trip
        int end = (days[di] + 7) - 1;
        int temp = 0; // declaring temp as we don't want to move the end pointer forward instead will use a dummy pointer for that
        while(di+temp < days.length && days[di+temp] <= end){
            temp++;
        }
        int sevenDays = helper(days, di+temp, costs, sum + costs[1]);

        // a call for 30-days trip
        end = (days[di] + 30) - 1;
        temp = 0;
        while(di+temp < days.length && days[di+temp] <= end){
            temp++;
        }        
        int thirtyDays = helper(days, di+temp, costs, sum + costs[2]);

        return Math.min(oneDay, Math.min(sevenDays, thirtyDays));
    }

    public int mincostTickets(int[] days, int[] costs) {
        return helper(days, 0, costs, 0);
    }

}
