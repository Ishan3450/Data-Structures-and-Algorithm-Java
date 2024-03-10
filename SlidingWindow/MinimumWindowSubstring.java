package SlidingWindow;

import java.util.HashMap;

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        if (t.length() > s.length())
            return "";

        HashMap<Character, Integer> tmap = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            char curr = t.charAt(i);
            tmap.put(curr, tmap.getOrDefault(curr, 0) + 1);
        }

        HashMap<Character, Integer> smap = new HashMap<>();
        int i = 0, j = 0;

        int minLength = Integer.MAX_VALUE;
        String minStr = ""; // try taking int[] array of size 2 storing i and j and at the returning stage just call substring single time

        int matchCount = 0;
        while (j < s.length()) {
            while (j < s.length() && matchCount < t.length()) {
                // trying to get the window containing t chars
                char curr = s.charAt(j);
                smap.put(curr, smap.getOrDefault(curr, 0) + 1);

                if (tmap.containsKey(curr) && smap.get(curr) <= tmap.get(curr)) {
                    matchCount++;
                }
                j++;
            }

            if (matchCount == t.length()) {
                while (matchCount == t.length()) {
                    // trying to minimize the window
                    // minLength = Math.min(minLength, j-i+1);

                    if (j - i + 1 < minLength) {
                        minLength = j - i + 1;
                        minStr = s.substring(i, j);
                    }

                    char toBeRemoved = s.charAt(i);

                    if (tmap.containsKey(toBeRemoved) && smap.get(toBeRemoved) <= tmap.get(toBeRemoved)) {
                        matchCount--;
                    }

                    smap.put(toBeRemoved, smap.get(toBeRemoved) - 1);
                    i++;
                }
            }
        }

        return minStr;
    }
}
