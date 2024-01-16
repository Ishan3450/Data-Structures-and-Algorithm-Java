package Heaps;

import java.util.List;
import java.util.PriorityQueue;

public class SmallestRangeCoveringElementsFromKLists {
    private class HeapNode implements Comparable<HeapNode> {
        int val;
        int arrNo;
        int idx;

        HeapNode(int val, int arrNo, int idx) {
            this.val = val;
            this.arrNo = arrNo;
            this.idx = idx;
        }

        @Override
        public int compareTo(HeapNode h) {
            return this.val > h.val ? 1 : -1;
        }
    }

    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<HeapNode> pq = new PriorityQueue<>();
        int[] minRange = new int[2];

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        // setting the initial queue
        for (int i = 0; i < nums.size(); i++) {
            int val = nums.get(i).get(0);

            min = Math.min(val, min);
            max = Math.max(max, val);

            pq.add(new HeapNode(val, i, 0));
        }

        minRange[0] = min;
        minRange[1] = max;

        while (!pq.isEmpty()) {
            HeapNode top = pq.remove();

            int currArr = top.arrNo;
            int currIdx = top.idx;

            if (currIdx + 1 >= nums.get(currArr).size()) {
                break;
            }

            int nextVal = nums.get(currArr).get(currIdx + 1);

            pq.add(new HeapNode(nextVal, currArr, currIdx + 1));

            max = Math.max(max, nextVal);
            min = pq.peek().val;

            int oldRange = minRange[1] - minRange[0] + 1;
            int newRange = max - min + 1;

            if (newRange < oldRange) {
                minRange[0] = min;
                minRange[1] = max;
            }
        }
        return minRange;
    }
}
