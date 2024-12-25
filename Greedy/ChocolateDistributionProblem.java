package Greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class ChocolateDistributionProblem {
    public long findMinDiff(ArrayList<Integer> a, int n, int m) {
        Collections.sort(a);
        Queue<Integer> window = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            window.add(a.get(i));
        }

        int min = a.get(m - 1) - a.get(0);

        for (int i = m; i < n; i++) {
            int curr = a.get(i);

            window.remove();
            window.add(curr);

            min = Math.min(min, curr - window.peek());
        }
        return min;
    }
}
