package DynamicProgramming;

public class MinimumCostForTickets {
    public int mincostTickets(int[] days, int[] costs) {
        // int[] dp = new int[days.length];
        // Arrays.fill(dp, -1);
        return tabulation(days, costs);
    }

    // tabulation
    public int tabulation(int[] days, int[] costs) {
        int[] dp = new int[days.length + 1];

        for (int currDay = days.length - 1; currDay >= 0; currDay--) {
            int daycation = costs[0] + dp[currDay + 1];

            // 1-week trip
            int tempDay = currDay;
            int expirationDay = days[currDay] + 7 - 1;

            while (tempDay < days.length && days[tempDay] <= expirationDay) {
                tempDay++;
            }

            int weekTrip = costs[1] + dp[tempDay];

            // 1-month trip
            tempDay = currDay;
            expirationDay = days[currDay] + 30 - 1;

            while (tempDay < days.length && days[tempDay] <= expirationDay) {
                tempDay++;
            }

            int monthTrip = costs[2] + dp[tempDay];

            dp[currDay] = Math.min(monthTrip, Math.min(weekTrip, daycation));
        }

        return dp[0];
    }

    // memoization
    public int memoization(int[] days, int[] costs, int currDay, int[] dp) {
        // base condition
        if (currDay >= days.length) {
            return 0;
        }

        if (dp[currDay] != -1) {
            return dp[currDay];
        }

        // function body

        // single day trip
        int daycation = costs[0] + memoization(days, costs, currDay + 1, dp);

        // 1-week trip
        int tempDay = currDay;
        int expirationDay = days[currDay] + 7 - 1;

        while (tempDay < days.length && days[tempDay] <= expirationDay) {
            tempDay++;
        }

        int weekTrip = costs[1] + memoization(days, costs, tempDay, dp);

        // 1-month trip
        tempDay = currDay;
        expirationDay = days[currDay] + 30 - 1;

        while (tempDay < days.length && days[tempDay] <= expirationDay) {
            tempDay++;
        }

        int monthTrip = costs[2] + memoization(days, costs, tempDay, dp);

        dp[currDay] = Math.min(monthTrip, Math.min(weekTrip, daycation));
        return dp[currDay];
    }

    // recursive approach
    public int recursive(int[] days, int[] costs, int currDay) {
        // base condition
        if (currDay >= days.length) {
            return 0;
        }

        // function body

        // single day trip
        int daycation = costs[0] + recursive(days, costs, currDay + 1);

        // 1-week trip
        int tempDay = currDay;
        int expirationDay = days[currDay] + 7 - 1;

        while (tempDay < days.length && days[tempDay] <= expirationDay) {
            tempDay++;
        }

        int weekTrip = costs[1] + recursive(days, costs, tempDay);

        // 1-month trip
        tempDay = currDay;
        expirationDay = days[currDay] + 30 - 1;

        while (tempDay < days.length && days[tempDay] <= expirationDay) {
            tempDay++;
        }

        int monthTrip = costs[2] + recursive(days, costs, tempDay);

        return Math.min(monthTrip, Math.min(weekTrip, daycation));
    }
}
