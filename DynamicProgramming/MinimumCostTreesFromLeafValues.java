package DynamicProgramming;

import java.util.HashMap;
import java.util.Objects;

public class MinimumCostTreesFromLeafValues {
    private class Pair {
        int from;
        int to;

        Pair(int from, int to) {
            this.from = from;
            this.to = to;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;
            Pair pair = (Pair) o;
            return from == pair.from && to == pair.to;
        }

        @Override
        public int hashCode() {
            return Objects.hash(from, to);
        }
    }

    public int mctFromLeafValues(int[] arr) {
        HashMap<Pair, Integer> rangeMaxValues = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            rangeMaxValues.put(new Pair(i, i), arr[i]);
            int maxVal = arr[i];

            for (int j = i + 1; j < arr.length; j++) {
                maxVal = Math.max(arr[j], maxVal);
                rangeMaxValues.put(new Pair(i, j), maxVal);
            }
        }

        int n = arr.length;
        // int[][] dp = new int[n+1][n+1];

        return tabulation(rangeMaxValues, n);
    }

    // space optimization not possible

    // tabulation approach
    public int tabulation(HashMap<Pair, Integer> rangeMaxValues, int n) {
        int[][] dp = new int[n][n];

        for (int start = n - 1; start >= 0; start--) {
            for (int end = 0; end < n; end++) {
                if (start >= end) {
                    continue;
                }

                int minNonLeafSum = Integer.MAX_VALUE;

                for (int i = start; i < end; i++) {
                    int rootNodeSum = rangeMaxValues.get(new Pair(start, i)) * rangeMaxValues.get(new Pair(i + 1, end));
                    minNonLeafSum = Math.min(minNonLeafSum, rootNodeSum + dp[start][i] + dp[i + 1][end]);
                }
                dp[start][end] = minNonLeafSum;
            }
        }

        return dp[0][n - 1];
    }

    // memoization approach
    public int memoization(HashMap<Pair, Integer> rangeMaxValues, int start, int end, int[][] dp) {
        // base condition
        if (start >= end) {
            return 0;
        }

        if (dp[start][end] != 0) {
            return dp[start][end];
        }

        // function body
        int minNonLeafSum = Integer.MAX_VALUE;

        for (int i = start; i < end; i++) {
            int rootNodeSum = rangeMaxValues.get(new Pair(start, i)) * rangeMaxValues.get(new Pair(i + 1, end));
            minNonLeafSum = Math.min(minNonLeafSum, rootNodeSum + memoization(rangeMaxValues, start, i, dp)
                    + memoization(rangeMaxValues, i + 1, end, dp));
        }

        dp[start][end] = minNonLeafSum;
        return minNonLeafSum;
    }

    // recursive approach
    public int recursive(HashMap<Pair, Integer> rangeMaxValues, int start, int end) {
        // base condition
        if (start >= end) {
            return 0;
        }

        // function body
        int minNonLeafSum = Integer.MAX_VALUE;

        for (int i = start; i < end; i++) {
            int rootNodeSum = rangeMaxValues.get(new Pair(start, i)) * rangeMaxValues.get(new Pair(i + 1, end));
            minNonLeafSum = Math.min(minNonLeafSum,
                    rootNodeSum + recursive(rangeMaxValues, start, i) + recursive(rangeMaxValues, i + 1, end));
        }

        return minNonLeafSum;
    }
}
