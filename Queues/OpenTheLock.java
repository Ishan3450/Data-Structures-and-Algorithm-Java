/*
 * Lc 752
 */

package Queues;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class OpenTheLock {
    public int openLock(String[] deadends, String target) {
        HashSet<String> ends = new HashSet<>();
        for (String deadend : deadends) {
            ends.add(deadend);
        }

        Queue<String> q = new LinkedList<>();
        q.add("0000");
        int level = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                String curr = q.remove();

                if (ends.contains(curr)) {
                    continue;
                }

                if (curr.equals(target)) {
                    return level;
                }
                ends.add(curr); // marking visited

                // puting every combination of curr pattern string
                for (int k = 0; k < curr.length(); k++) {
                    int currDigit = (curr.charAt(k) - '0');

                    // adding 1
                    int added1 = (currDigit + 1) % 10;
                    q.add(curr.substring(0, k) + ((char) (added1 + '0')) + curr.substring(k + 1));

                    // deducting 1
                    int deducted1 = ((currDigit - 1) + 10) % 10;
                    q.add(curr.substring(0, k) + ((char) (deducted1 + '0')) + curr.substring(k + 1));
                }
            }

            level++;
        }
        return -1;
    }
}
