package DynamicProgramming;

import java.util.Arrays;

public class NumberOfWaysToStayInTheSamePlaceAfterSomeSteps {
    final int MOD = 1000000007;

    public int numWays(int steps, int arrLen) {
        // return recursive(steps, arrLen, 0);

        /**
            * below line is important otherwise the problem will not be submitted

            Reason:

            Lets take steps = 5 and arrLen = 1000
            - Point 1: here we can clearly see at most we can go steps only in the len of the array.
            - Point 2: also we have to reach 0 so at most we can go steps/2 right and then come back.

            we can also take: arrLen = Math.min(steps, arrLen);
         */
        arrLen = Math.min(steps/2+1, arrLen);

        int[][] dp = new int[steps+1][arrLen];
        for(int[] row: dp) Arrays.fill(row, -1);

        return memoization(steps, arrLen, 0, dp);
    }

    // memoization
    public int memoization(int steps, int arrLen, int currPos, int[][] dp){
        // base condition
        if(steps == 0){
            if(currPos == 0){
                return 1;
            }
            return 0;
        }

        if(currPos < 0 || currPos >= arrLen){
            return 0;
        }

        if(dp[steps][currPos] != -1){
            return dp[steps][currPos];
        }

        // function body
        int totalWays = 0;

        // left
        totalWays = (totalWays + (memoization(steps-1, arrLen, currPos-1, dp) % MOD)) % MOD;

        // right
        totalWays = (totalWays + (memoization(steps-1, arrLen, currPos+1, dp) % MOD)) % MOD;

        // stay
        totalWays = (totalWays + (memoization(steps-1, arrLen, currPos, dp) % MOD)) % MOD;

        return dp[steps][currPos] = totalWays;
    }

    // recursive
    public int recursive(int steps, int arrLen, int currPos){
        // base condition
        if(steps == 0){
            if(currPos == 0){
                return 1;
            }
            return 0;
        }

        if(currPos < 0 || currPos >= arrLen){
            return 0;
        }

        // function body
        int totalWays = 0;

        // left
        totalWays = (totalWays + (recursive(steps-1, arrLen, currPos-1) % MOD)) % MOD;

        // right
        totalWays = (totalWays + (recursive(steps-1, arrLen, currPos+1) % MOD)) % MOD;

        // stay
        totalWays = (totalWays + (recursive(steps-1, arrLen, currPos) % MOD)) % MOD;

        return totalWays;
    }
}
