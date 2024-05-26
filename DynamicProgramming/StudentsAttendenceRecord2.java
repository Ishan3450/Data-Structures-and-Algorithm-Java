package DynamicProgramming;

import java.util.Arrays;

public class StudentsAttendenceRecord2 {
    final static int MOD = 1000000007;

    public int checkRecord(int n) {
        int[][][] dp = new int[n + 1][2][3];

        for (int[][] mat : dp) {
            for (int[] row : mat) {
                Arrays.fill(row, -1);
            }
        }

        return memoization(n, 0, 0, dp);
    }

    // memoization
    private int memoization(int n, int absentDays, int lateDays, int[][][] dp) {
        // base condition
        if (n == 0) {
            return 1;
        }

        if (dp[n][absentDays][lateDays] != -1) {
            return dp[n][absentDays][lateDays];
        }

        // function body
        int present = memoization(n - 1, absentDays, 0, dp);
        int late = lateDays == 2 ? 0 : memoization(n - 1, absentDays, lateDays + 1, dp);
        int absent = absentDays == 1 ? 0 : memoization(n - 1, absentDays + 1, 0, dp);

        return dp[n][absentDays][lateDays] = (((present + late) % MOD) + absent) % MOD;
    }

    // recursive
    // private int recursive(int n, int presentDays, int absentDays, int lateDays){
    // // base condition
    // if(n == 0){
    // return 1;
    // }

    // // function body
    // int present = recursive(n-1, presentDays+1, absentDays, lateDays);
    // int late = lateDays == 2 ? recursive(n, presentDays, absentDays, 0) :
    // recursive(n-1, presentDays, absentDays, lateDays+1);
    // int absent = absentDays == 1 ? 0 : recursive(n-1, presentDays, absentDays+1,
    // lateDays);

    // return (((present + late) % MOD) + absent) % MOD;
    // }
}