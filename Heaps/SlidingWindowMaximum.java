package Heaps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class SlidingWindowMaximum {
    private class HeapNode implements Comparable<HeapNode> {
        int val;
        int idx;

        HeapNode(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }

        @Override
        public int compareTo(HeapNode h) {
            if (this.val > h.val) {
                return 1;
            }

            if (this.val < h.val) {
                return -1;
            }

            return 0;
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<HeapNode> pq = new PriorityQueue<>(Collections.reverseOrder());
        ArrayList<Integer> list = new ArrayList<>();

        // initial heap
        for (int i = 0; i < k; i++) {
            pq.add(new HeapNode(nums[i], i));
        }

        list.add(pq.peek().val);

        // processing rest of the windows
        for (int i = k; i < nums.length; i++) {
            // remove the out of the windows elements
            while (!pq.isEmpty() && i - pq.peek().idx >= k) {
                pq.remove();
            }

            // add the curr window element
            pq.add(new HeapNode(nums[i], i));

            // get the ans
            list.add(pq.peek().val);
        }

        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }
}
