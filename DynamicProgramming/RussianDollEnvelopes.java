package DynamicProgramming;

import java.util.Arrays;

public class RussianDollEnvelopes {
    private class Envelop implements Comparable<Envelop> {
        int height;
        int width;

        Envelop(int width, int height) {
            this.height = height;
            this.width = width;
        }

        @Override
        public int compareTo(Envelop e) {
            return this.width - e.width;
        }
    }

    public int maxEnvelopes(int[][] envelopes) {
        Envelop[] e = new Envelop[envelopes.length];

        for (int i = 0; i < envelopes.length; i++) {
            e[i] = new Envelop(envelopes[i][0], envelopes[i][1]);
        }

        Arrays.sort(e);
        // for(Envelop a: e){
        // System.out.println(a.width + " " + a.height);
        // }

        // int n = envelopes.length;
        // int[][] dp = new int[n][n];
        // for(int[] row: dp) Arrays.fill(row, -1);

        // return memoization(e, 0, -1, dp);

        return tabulation(e, e.length);
    }

    // space optimized
    public int spaceOptimized(Envelop[] envelopes, int n) {
        int[] curr = new int[n + 1];
        int[] next = new int[n + 1];

        for (int currIdx = envelopes.length - 1; currIdx >= 0; currIdx--) {
            for (int prevIdx = envelopes.length - 1; prevIdx >= -1; prevIdx--) {
                int include = 0;
                Envelop previouslyTaken = prevIdx != -1 ? envelopes[prevIdx] : null;
                Envelop currEnvelop = envelopes[currIdx];

                if (prevIdx == -1
                        || (currEnvelop.height > previouslyTaken.height && currEnvelop.width > previouslyTaken.width)) {
                    include = 1 + next[currIdx + 1];
                }

                int exclude = next[prevIdx + 1];

                curr[prevIdx + 1] = Math.max(include, exclude);
            }
            // shifting
            next = Arrays.copyOf(curr, curr.length);
        }
        return curr[0];
    }

    // tabulation
    public int tabulation(Envelop[] envelopes, int n) {
        int[][] dp = new int[n + 1][n + 1];

        for (int currIdx = envelopes.length - 1; currIdx >= 0; currIdx--) {
            for (int prevIdx = envelopes.length - 1; prevIdx >= -1; prevIdx--) {
                int include = 0;
                Envelop previouslyTaken = prevIdx != -1 ? envelopes[prevIdx] : null;
                Envelop currEnvelop = envelopes[currIdx];

                if (prevIdx == -1
                        || (currEnvelop.height > previouslyTaken.height && currEnvelop.width > previouslyTaken.width)) {
                    include = 1 + dp[currIdx + 1][currIdx + 1];
                }

                int exclude = dp[currIdx + 1][prevIdx + 1];

                dp[currIdx][prevIdx + 1] = Math.max(include, exclude);
            }
        }
        return dp[0][0];
    }

    // memoizatin approach
    public int memoization(Envelop[] envelopes, int currIdx, int prevIdx, int[][] dp) {
        // base condition
        if (currIdx >= envelopes.length) {
            return 0;
        }

        if (dp[currIdx][prevIdx + 1] != -1) {
            return dp[currIdx][prevIdx + 1];
        }

        // function body
        int include = 0;
        Envelop previouslyTaken = prevIdx != -1 ? envelopes[prevIdx] : null;
        Envelop currEnvelop = envelopes[currIdx];

        if (prevIdx == -1
                || (currEnvelop.height > previouslyTaken.height && currEnvelop.width > previouslyTaken.width)) {
            include = 1 + recursive(envelopes, currIdx + 1, currIdx);
        }

        int exclude = recursive(envelopes, currIdx + 1, prevIdx);

        dp[currIdx][prevIdx + 1] = Math.max(include, exclude);
        return dp[currIdx][prevIdx + 1];
    }

    // recursive solution
    public int recursive(Envelop[] envelopes, int currIdx, int prevIdx) {
        // base condition
        if (currIdx >= envelopes.length) {
            return 0;
        }

        // function body
        int include = 0;
        Envelop previouslyTaken = prevIdx != -1 ? envelopes[prevIdx] : null;
        Envelop currEnvelop = envelopes[currIdx];

        if (prevIdx == -1
                || (currEnvelop.height > previouslyTaken.height && currEnvelop.width > previouslyTaken.width)) {
            include = 1 + recursive(envelopes, currIdx + 1, currIdx);
        }

        int exclude = recursive(envelopes, currIdx + 1, prevIdx);

        return Math.max(include, exclude);
    }
}
