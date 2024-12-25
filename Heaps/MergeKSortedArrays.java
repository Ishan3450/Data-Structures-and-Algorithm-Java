package Heaps;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class MergeKSortedArrays {
    private static class HeapNode implements Comparable<HeapNode> {
        int val;
        int arrNo;
        int idx;

        HeapNode(int val, int arrNo, int idx) {
            this.val = val;
            this.arrNo = arrNo;
            this.idx = idx;
        }

        @Override
        public int compareTo(HeapNode node) {
            return this.val > node.val ? 1 : -1;
        }
    }

    // Function to merge k sorted arrays.
    public static ArrayList<Integer> mergeKArrays(int[][] arr, int K) {
        PriorityQueue<HeapNode> heap = new PriorityQueue<>();
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < K; i++) {
            heap.add(new HeapNode(arr[i][0], i, 0));
        }

        while (!heap.isEmpty()) {
            HeapNode topOfHeap = heap.remove();

            list.add(topOfHeap.val);

            int nextIdx = topOfHeap.idx + 1;
            int arrNo = topOfHeap.arrNo;

            if (nextIdx < arr[arrNo].length) {
                heap.add(new HeapNode(arr[arrNo][nextIdx], arrNo, nextIdx));
            }
        }

        return list;
    }
}
