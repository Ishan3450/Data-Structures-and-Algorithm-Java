package Queues;

import java.util.*;

public class FirstNonRepetatingCharacterInStream {
    public static String FirstNonRepeating(String A) {

        HashMap<Character, Integer> count = new HashMap<>();
        Queue<Character> q = new LinkedList<>();

        String ans = "";

        for (int i = 0; i < A.length(); i++) {
            char curr = A.charAt(i);

            // incrementing the count
            if (count.containsKey(curr)) {
                count.put(curr, count.get(curr) + 1);
            } else {
                count.put(curr, 1);
            }   

            // adding the curr char in the queue
            q.add(curr);

            while (!q.isEmpty()) {
                if (count.get(q.peek()) > 1) { // we found a repeating element
                    q.remove();
                } else { // we found a non repeating element
                    ans += q.peek();
                    break;
                }
            }

            /*
             * At this point we either come if the queue becomes empty or through the break
             * condition of else block
             */
            if (q.isEmpty()) {
                ans += '#';
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "aabc";

        System.out.println(FirstNonRepeating(s));
    }
}
