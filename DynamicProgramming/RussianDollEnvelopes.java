package DynamicProgramming;

import java.util.Arrays;

public class RussianDollEnvelopes {
    public int maxEnvelopes(int[][] envelopes) {
        // ** for recursive, memoization, tabualtion, space optimized tabulation below
        // sort line will work in which we are sorting based on just width of the
        // envelop
        // Arrays.sort(envelopes, (a,b) -> a[0] - b[0]);

        // return recursive(envelopes, 0, -1);

        // int[][] dp = new int[envelopes.length][envelopes.length];
        // for(int[] row: dp) Arrays.fill(row, -1);
        // return memoization(envelopes, 0, -1, dp);

        // return tabulation(envelopes);
        // return spaceOptimized(envelopes);

        /*
         * Below sort like will work for both but in the case of applying dp below line
         * will not affect it will affect in just binary search approach why?
         * 
         * Let's take a case:
         * For this: [[5,4],[6,4],[6,7],[2,3]]
         * Sorted: [[2,3], [5,4], [6,4], [6,7]]
         * 
         * We will just pass the height of the envelopes in the binary search array and
         * sort so in above case:
         * 3,4,4,7 will be the height so the ans will 3, there is no problem in this
         * case
         * 
         * Now let's take another case:
         * [[4,5],[4,6],[6,7],[2,3],[1,1]]
         * 
         * So after sorting the height which will be used is:
         * [[1,1], [2,3], [4,5], [4,6], [6,7]] => 1,3,5,6,7
         * 
         * So according to height the ans is 5 but if we see the [4,5] and [4,6]
         * elements are considered which is not correct becuase both height and width
         * must be greater
         * 
         * That's why we will sort the width in ascending order and height in descending
         * order
         */
        Arrays.sort(envelopes, (a, b) -> {
            return a[0] != b[0] ? a[0] - b[0] : b[1] - a[1];
        });

        return mostOptimalBinarySearch(envelopes);
    }

    // binary search
    public int mostOptimalBinarySearch(int[][] envelopes) {
        // arr[] will be used to store just height
        int[] arr = new int[envelopes.length];

        arr[0] = envelopes[0][1];

        int len = 1;

        for (int i = 0; i < envelopes.length; i++) {
            if (envelopes[i][1] > arr[len - 1]) {
                arr[len] = envelopes[i][1];
                len++;
            } else {
                int insertionPoint = Arrays.binarySearch(arr, 0, len, envelopes[i][1]);

                if (insertionPoint < 0) {
                    insertionPoint = -(insertionPoint + 1);
                }

                arr[insertionPoint] = envelopes[i][1];
            }
        }

        return len;
    }

    // space optimized
    public int spaceOptimized(int[][] envelopes) {
        int[] currArr = new int[envelopes.length + 1];
        int[] nextArr = new int[envelopes.length + 1];

        for (int curr = envelopes.length - 1; curr >= 0; curr--) {
            for (int prev = envelopes.length - 1; prev >= -1; prev--) {
                int include = 0;
                if (prev == -1
                        || (envelopes[prev][0] < envelopes[curr][0] && envelopes[prev][1] < envelopes[curr][1])) {
                    include = 1 + nextArr[curr + 1];
                }

                int exclude = nextArr[prev + 1];

                currArr[prev + 1] = Math.max(include, exclude);
            }
            // shifting
            nextArr = currArr.clone();
        }

        return currArr[0];
    }

    // tabulation
    public int tabulation(int[][] envelopes) {
        int[][] dp = new int[envelopes.length + 1][envelopes.length + 1];

        for (int curr = envelopes.length - 1; curr >= 0; curr--) {
            for (int prev = envelopes.length - 1; prev >= -1; prev--) {
                int include = 0;
                if (prev == -1
                        || (envelopes[prev][0] < envelopes[curr][0] && envelopes[prev][1] < envelopes[curr][1])) {
                    include = 1 + dp[curr + 1][curr + 1];
                }

                int exclude = dp[curr + 1][prev + 1];

                dp[curr][prev + 1] = Math.max(include, exclude);
            }
        }

        return dp[0][0];
    }

    public int memoization(int[][] envelopes, int curr, int prev, int[][] dp) {
        // base condition
        if (curr >= envelopes.length) {
            return 0;
        }

        if (dp[curr][prev + 1] != -1) {
            return dp[curr][prev + 1];
        }

        // function body
        int include = 0;
        if (prev == -1 || (envelopes[prev][0] < envelopes[curr][0] && envelopes[prev][1] < envelopes[curr][1])) {
            include = 1 + memoization(envelopes, curr + 1, curr, dp);
        }

        int exclude = memoization(envelopes, curr + 1, prev, dp);

        dp[curr][prev + 1] = Math.max(include, exclude);
        return dp[curr][prev + 1];
    }

    public int recursive(int[][] envelopes, int curr, int prev) {
        // base condition
        if (curr >= envelopes.length) {
            return 0;
        }

        // function body
        int include = 0;
        if (prev == -1 || (envelopes[prev][0] < envelopes[curr][0] && envelopes[prev][1] < envelopes[curr][1])) {
            include = 1 + recursive(envelopes, curr + 1, curr);
        }

        int exclude = recursive(envelopes, curr + 1, prev);

        return Math.max(include, exclude);
    }
}
