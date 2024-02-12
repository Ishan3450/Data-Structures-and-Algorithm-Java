package DynamicProgramming;

import java.util.Arrays;

public class ReducingDishes {
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction); // key point here is sorting becuase dishes can be made in any order.

        // int[][] dp = new int[satisfaction.length][satisfaction.length+1];
        // for(int[] row: dp) Arrays.fill(row, -1);

        // return memoization(satisfaction, 0, 1, dp);

        return spaceOptimized(satisfaction);
    }

    // space optimized approach
    public int spaceOptimized(int[] satisfaction) {
        int[] curr = new int[satisfaction.length + 2];
        int[] next = new int[satisfaction.length + 2];

        for (int idx = satisfaction.length - 1; idx >= 0; idx--) {
            for (int time = satisfaction.length; time >= 1; time--) {
                // include curr dish
                int include = (satisfaction[idx] * time) + next[time + 1];

                // exclude curr dish
                int exclude = next[time];

                curr[time] = Math.max(include, exclude);
            }
            // shifting
            next = curr.clone();
        }
        return curr[1];
    }

    // tabulation approach
    public int tabulation(int[] satisfaction) {
        int[][] dp = new int[satisfaction.length + 1][satisfaction.length + 2];

        for (int idx = satisfaction.length - 1; idx >= 0; idx--) {
            for (int time = satisfaction.length; time >= 1; time--) {
                // include curr dish
                int include = (satisfaction[idx] * time) + dp[idx + 1][time + 1];

                // exclude curr dish
                int exclude = dp[idx + 1][time];

                dp[idx][time] = Math.max(include, exclude);
            }
        }
        return dp[0][1];
    }

    // memoization approach
    public int memoization(int[] satisfaction, int idx, int time, int[][] dp) {
        // base condition
        if (idx >= satisfaction.length) {
            return 0;
        }

        if (dp[idx][time] != -1) {
            return dp[idx][time];
        }

        // function body

        // include curr dish
        int include = (satisfaction[idx] * time) + memoization(satisfaction, idx + 1, time + 1, dp);

        // exclude curr dish
        int exclude = memoization(satisfaction, idx + 1, time, dp);

        dp[idx][time] = Math.max(include, exclude);
        return dp[idx][time];
    }

    // recursive approach
    public int recursive(int[] satisfaction, int idx, int time) {
        // base condition
        if (idx >= satisfaction.length) {
            return 0;
        }

        // function body

        // include curr dish
        int include = (satisfaction[idx] * time) + recursive(satisfaction, idx + 1, time + 1);

        // exclude curr dish
        int exclude = recursive(satisfaction, idx + 1, time);

        return Math.max(include, exclude);
    }
}
