package DynamicProgramming;

import java.util.HashSet;
import java.util.List;

public class WordBreak1 {
    /*
     * We have to break the string s in such way that each space separeted word
     * created from s must be an element of wordDict
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>();
        for (String elem : wordDict) {
            set.add(elem);
        }

        // Boolean[] dp = new Boolean[s.length()];

        return tabulation(s, set);
    }

    // Space optimization is not possible

    // tabulation
    public boolean tabulation(String s, HashSet<String> set) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[s.length()] = true;

        for (int idx = s.length() - 1; idx >= 0; idx--) {
            StringBuilder sb = new StringBuilder();
            boolean isPossible = false;

            int temp = idx;
            while (temp < s.length()) {
                sb.append(s.charAt(temp));

                if (set.contains(sb.toString())) {
                    if (dp[temp + 1]) {
                        isPossible = true; // we are not returning here because still we have not completed the whole
                                           // tabulation table or not filled whole tabulation table
                    }
                }

                temp++;
            }

            dp[idx] = isPossible;
        }
        return dp[0];
    }

    // memoization
    public boolean memoization(String s, int idx, HashSet<String> set, Boolean[] dp) {
        // base condition
        if (idx >= s.length()) {
            return true;
        }

        if (dp[idx] != null) {
            return dp[idx];
        }

        // function body
        StringBuilder sb = new StringBuilder();

        int temp = idx;
        while (temp < s.length()) {
            sb.append(s.charAt(temp));

            if (set.contains(sb.toString())) {
                if (memoization(s, temp + 1, set, dp)) {
                    dp[temp] = true;
                    return true;
                }
            }

            temp++;
        }

        dp[idx] = false;
        return false;
    }

    // recursive
    public boolean recursive(String s, int idx, HashSet<String> set) {
        // base condition
        if (idx >= s.length()) {
            return true;
        }

        // function body
        StringBuilder sb = new StringBuilder();

        while (idx < s.length()) {
            sb.append(s.charAt(idx));

            if (set.contains(sb.toString())) {
                if (recursive(s, idx + 1, set)) {
                    return true;
                }
            }

            idx++;
        }
        return false;
    }
}
