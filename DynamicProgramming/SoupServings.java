package DynamicProgramming;

import java.util.Arrays;

public class SoupServings {
     public double soupServings(int n) {
        // very worst thing in this questions is below condition
        // below condition means the more the value of A means with the increasing in the value of A the probability of getting A first empty will get near and near to 1 then of B because in questions it has state that we cannot empty B on once 100ml like we have for A.
        if(n >= 4700) return 1;

        // return recursive(n, n);

        double[][] dp = new double[n+1][n+1];
        for(double[] row: dp) Arrays.fill(row, -1);

        return memoization(n, n, dp);
    }

    // memoization
    public double memoization(int soupA, int soupB, double[][] dp){
        // base condition
        if(soupA == 0 && soupB != 0){
            return 1;
        }

        if(soupA == 0 && soupB == 0){
            return 0.5;
        }

        if(soupB == 0){
            return 0;
        }

        if(dp[soupA][soupB] != -1){
            return dp[soupA][soupB];
        }

        // function body

        // either of the 4 operation
        double operation1 = memoization(Math.max(0, soupA-100), soupB, dp);
        double operation2 = memoization(Math.max(0, soupA-75), Math.max(0, soupB-25), dp);
        double operation3 = memoization(Math.max(0, soupA-50), Math.max(0, soupB-50), dp);
        double operation4 = memoization(Math.max(0, soupA-25), Math.max(0, soupB-75), dp);

        return dp[soupA][soupB] = 0.25 * (operation1 + operation2 + operation3 + operation4);
    }

    // recursive
    public double recursive(int soupA, int soupB){
        // base condition
        if(soupA == 0 && soupB != 0){
            return 1;
        }

        if(soupA == 0 && soupB == 0){
            return 0.5;
        }

        if(soupB == 0){
            return 0;
        }

        // function body

        // either of the 4 operation
        double operation1 = recursive(Math.max(0, soupA-100), soupB);
        double operation2 = recursive(Math.max(0, soupA-75), Math.max(0, soupB-25));
        double operation3 = recursive(Math.max(0, soupA-50), Math.max(0, soupB-50));
        double operation4 = recursive(Math.max(0, soupA-25), Math.max(0, soupB-75));

        return (operation1 + operation2 + operation3 + operation4) / 4;
    }
}
