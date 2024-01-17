package Heaps;

import java.util.Collections;
import java.util.PriorityQueue;

public class KClosestPointsToOrigin {
    private class HeapNode implements Comparable<HeapNode> {
        int[] pair;
        double distanceFromOrigin;

        HeapNode(int[] pair) {
            this.pair = pair;
            this.distanceFromOrigin = Math.sqrt((pair[0] * pair[0]) + (pair[1] * pair[1]));
        }

        @Override
        public int compareTo(HeapNode h) {
            if (this.distanceFromOrigin == h.distanceFromOrigin) {
                return 0;
            } else if (this.distanceFromOrigin > h.distanceFromOrigin) {
                return 1;
            }
            return -1;
        }
    }

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<HeapNode> pq = new PriorityQueue<>(Collections.reverseOrder());

        // creation of initial heap
        for (int i = 0; i < k; i++) {
            pq.add(new HeapNode(points[i]));
        }

        for (int i = k; i < points.length; i++) {
            HeapNode newNode = new HeapNode(points[i]);

            if (newNode.distanceFromOrigin < pq.peek().distanceFromOrigin) {
                pq.remove();
                pq.add(newNode);
            }
        }

        int[][] ans = new int[k][2];
        int idx = 0;

        while (!pq.isEmpty()) {
            ans[idx++] = pq.remove().pair;
        }
        return ans;
    }
}