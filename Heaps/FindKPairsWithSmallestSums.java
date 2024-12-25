package Heaps;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Set;

public class FindKPairsWithSmallestSums {
    private class Pair implements Comparable<Pair> {
        int sum;
        int i, j;

        Pair(int sum, int i, int j) {
            this.sum = sum;
            this.i = i;
            this.j = j;
        }

        @Override
        public int compareTo(Pair o) {
            return this.sum - o.sum;
        }

        @Override
        public int hashCode() {
            return Objects.hash(i, j);
        }

        @Override
        public boolean equals(Object o) {
            Pair p = (Pair) o;
            return this.i == p.i && this.j == p.j;
        }
    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(); // min heap
        pq.add(new Pair(nums1[0] + nums2[0], 0, 0));

        List<List<Integer>> pairs = new ArrayList<>();

        Set<Pair> isVisited = new HashSet<>();

        while (k > 0 && !pq.isEmpty()) {
            Pair peek = pq.remove();

            List<Integer> list = new ArrayList<>();
            list.add(nums1[peek.i]);
            list.add(nums2[peek.j]);
            pairs.add(list);

            int i = peek.i;
            int j = peek.j;

            // from i, j --> we can go i+1, j and i, j+1

            // i+1, j
            if (i + 1 < nums1.length && !isVisited.contains(new Pair(-1, i + 1, j))) {
                pq.add(new Pair(nums1[i + 1] + nums2[j], i + 1, j));
                isVisited.add(new Pair(-1, i + 1, j));
            }

            // i, j+1
            if (j + 1 < nums2.length && !isVisited.contains(new Pair(-1, i, j + 1))) {
                pq.add(new Pair(nums1[i] + nums2[j + 1], i, j + 1));
                isVisited.add(new Pair(-1, i, j + 1));
            }

            k--;
        }

        return pairs;
    }

    // i, j --> i+1, j and i, j+1
    // 0, 0 --> 1, 0 and 0, 1
    // 1, 0 --> 2, 0 and 1, 1
    // 0, 1 --> 1, 1 and 0, 2

}
