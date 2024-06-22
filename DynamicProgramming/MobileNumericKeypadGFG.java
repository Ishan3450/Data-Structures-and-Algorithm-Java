package DynamicProgramming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class MobileNumericKeypadGFG {
    HashMap<Integer, List<Integer>> map = new HashMap<>();

    MobileNumericKeypadGFG() {
        makeMap(Arrays.asList(0, 8), 0);
        makeMap(Arrays.asList(1, 2, 4), 1);
        makeMap(Arrays.asList(1, 2, 3, 5), 2);
        makeMap(Arrays.asList(2, 3, 6), 3);
        makeMap(Arrays.asList(1, 4, 5, 7), 4);
        makeMap(Arrays.asList(2, 4, 5, 6, 8), 5);
        makeMap(Arrays.asList(3, 5, 6, 9), 6);
        makeMap(Arrays.asList(4, 7, 8), 7);
        makeMap(Arrays.asList(0, 5, 7, 8, 9), 8);
        makeMap(Arrays.asList(6, 8, 9), 9);
    }

    public long getCount(int n) {
        long[][] dp = new long[n + 1][10];
        for (long[] row : dp)
            Arrays.fill(row, -1);

        long count = 0;
        for (int source = 0; source <= 9; source++) {
            count += helper(n - 1, source, dp);
        }
        return count;
    }

    private long helper(int n, int source, long[][] dp) {
        // base condition
        if (n == 0) {
            return 1;
        }

        if (dp[n][source] != -1) {
            return dp[n][source];
        }

        // function body
        long count = 0;
        List<Integer> possibleMoves = map.get(source);

        for (int move : possibleMoves) {
            count += helper(n - 1, move, dp);
        }
        return dp[n][source] = count;
    }

    private void makeMap(List<Integer> list, int key) {
        map.put(key, list);
    }
}
