package Heaps;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthSmallestElementInArray {
    public static int kthSmallest(int[] arr, int l, int r, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); // max-heap

        // create initial heap of size k
        for (int i = 0; i < k; i++) {
            pq.add(arr[i]);
        }

        for (int i = k; i <= r; i++) {
            if (arr[i] < pq.peek()) {
                pq.remove();
                pq.add(arr[i]);
            }
        }

        return pq.peek();
    }
}
