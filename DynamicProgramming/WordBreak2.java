package DynamicProgramming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class WordBreak2 {
    public List<String> wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);

        // return recursive(s, set, 0);

        // HashMap<Integer, List<String>> dp = new HashMap<>();
        // return memoization(s, set, 0, dp);

        return tabulation(s, set);
    }

    // tabulation
    public List<String> tabulation(String s, HashSet<String> set) {
        HashMap<Integer, List<String>> dp = new HashMap<>();

        // base case setting
        List<String> l = new ArrayList<>();
        l.add("");
        dp.put(s.length(), l);
        //

        for (int idx = s.length() - 1; idx >= 0; idx--) {
            List<String> sentences = new ArrayList<>();

            StringBuilder curr = new StringBuilder();
            int temp = idx;
            while (temp < s.length()) {
                curr.append(s.charAt(temp));

                if (set.contains(curr.toString())) {
                    List<String> future = dp.get(temp + 1);

                    for (String elem : future) {
                        StringBuilder sb = new StringBuilder();

                        if (idx > 0) { // no additional space required as first word of the sentence is there
                            sb.append(" ");
                        }
                        sb.append(curr);
                        sb.append(elem);
                        sentences.add(sb.toString());
                    }
                }
                temp++;
            }

            dp.put(idx, sentences);
        }

        return dp.get(0);
    }

    // memoization
    public List<String> memoization(String s, HashSet<String> set, int idx, HashMap<Integer, List<String>> dp) {
        // base condition
        if (idx >= s.length()) {
            List<String> l = new ArrayList<>();
            l.add(""); // important thing to create a list with emmpty string so that after returning
                       // from base case the loop will execute atleast once
            return l;
        }

        if (dp.containsKey(idx)) {
            return dp.get(idx);
        }

        // function body
        List<String> sentences = new ArrayList<>();

        StringBuilder curr = new StringBuilder();
        int temp = idx;
        while (temp < s.length()) {
            curr.append(s.charAt(temp));

            if (set.contains(curr.toString())) {
                List<String> future = memoization(s, set, temp + 1, dp);

                for (String elem : future) {
                    StringBuilder sb = new StringBuilder();

                    if (idx > 0) { // no additional space required as first word of the sentence is there
                        sb.append(" ");
                    }
                    sb.append(curr);
                    sb.append(elem);
                    sentences.add(sb.toString());
                }
            }
            temp++;
        }

        dp.put(idx, sentences);
        return sentences;
    }

    // recursive
    public List<String> recursive(String s, HashSet<String> set, int idx) {
        // base condition
        if (idx >= s.length()) {
            List<String> l = new ArrayList<>();
            l.add("");
            return l;
        }

        // function body
        List<String> sentences = new ArrayList<>();

        String curr = "";
        int temp = idx;
        while (temp < s.length()) {
            curr += s.charAt(temp);

            if (set.contains(curr)) {
                List<String> future = recursive(s, set, temp + 1);

                for (String elem : future) {
                    if (idx == 0) { // no additional space required as first word of the sentence is there
                        sentences.add(curr + elem);
                    } else {
                        sentences.add(" " + curr + elem);
                    }
                }
            }
            temp++;
        }

        return sentences;
    }   
}
