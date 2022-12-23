package LeetCodeContests;

import java.util.HashMap;

public class Q389 {
    public static char findTheDifference(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (map.containsKey(curr)) {
                map.put(s.charAt(i), map.get(curr) + 1);
            } else {
                map.put(s.charAt(i), 1);
            }

        }

        for (int i = 0; i < t.length(); i++) {
            char curr = t.charAt(i);
            if (map.containsKey(curr)) {
                map.put(t.charAt(i), map.get(curr) + 1);
            } else {
                map.put(t.charAt(i), 1);
            }

        }

        for (int i = 0; i < t.length(); i++) {
            char curr = t.charAt(i); 
            if(map.get(curr) %2 != 0){
                return curr;
            }
        }

        return '\0'; // null
    }

    public static void main(String[] args) {
        System.out.println(findTheDifference("a", "aa"));
    }
}
