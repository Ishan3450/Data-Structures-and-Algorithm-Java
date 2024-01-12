package Heaps;

import java.util.PriorityQueue;

public class KthLargestElementInArray {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // min-heap

        // heap of size k which will remain of size k constant
        for (int i = 0; i < k; i++) {
            pq.add(nums[i]);
        }

        for (int i = k; i < nums.length; i++) {
            if (nums[i] > pq.peek()) {
                pq.remove();
                pq.add(nums[i]);
            }
        }

        return pq.peek();
    }

}
