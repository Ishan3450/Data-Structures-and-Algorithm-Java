package DynamicProgramming;

import java.util.Arrays;

public class MinimumInsertionStepsToMakeAStringPalindrome {
    public int minInsertions(String s) {
        // return recursive(s, 0, s.length()-1);

        int[][] dp = new int[s.length()][s.length()];
        for(int[] row: dp) Arrays.fill(row, -1);
        return memoization(s, 0, s.length()-1, dp);
    }

    // memoization
    public int memoization(String s, int left, int right, int[][] dp){
        // base condition
        if(left >= right){
            return 0;
        }

        if(dp[left][right] != -1){
            return dp[left][right];
        }

        // function body
        if(s.charAt(left) == s.charAt(right)){
            return dp[left][right] = memoization(s, left+1, right-1, dp);
        } else { // characters mismatch
            // NOTE: We are not actually modifying the string, instead we are just planning how the string will look like.

            // inserting character present at left index by inserting at the right index of the string which will create same characters on left and right
            int insertingCharAtLeftInRightPos = 1 + memoization(s, left+1, right, dp);

            // inserting character present at right index by inserting at the left index of the string which will create same characters
            int insertingCharAtRightInLeftPos = 1 + memoization(s, left, right-1, dp);

            return dp[left][right] = Math.min(insertingCharAtLeftInRightPos, insertingCharAtRightInLeftPos);
        }
    }

    // recursive
    public int recursive(String s, int left, int right){
        // base condition
        if(left >= right){
            return 0;
        }

        // function body

        if(s.charAt(left) == s.charAt(right)){
            return recursive(s, left+1, right-1);
        } else { // characters mismatch
            // NOTE: We not actually modifying the string, instead we are just planning how the string will look like.

            // inserting character present at left index by inserting at the right index of the string which will create same characters on left and right
            int insertingCharAtLeftInRightPos = 1 + recursive(s, left+1, right);

            // inserting character present at right index by inserting at the left index of the string which will create same characters
            int insertingCharAtRightInLeftPos = 1 + recursive(s, left, right-1);

            return Math.min(insertingCharAtLeftInRightPos, insertingCharAtRightInLeftPos);
        }
    }
}
