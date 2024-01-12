package Heaps;

public class Merge2BinaryMaxHeaps {
    public int[] mergeHeaps(int[] a, int[] b, int n, int m) {
        int[] heap = new int[n + m];
        int size = 0;

        for (int i = 0; i < n; i++) {
            heap[i] = a[i];
        }
        size = n;

        for (int i = 0; i < m; i++) {
            size = insertInHeap(heap, b[i], size);
        }

        return heap;
    }

    public int insertInHeap(int[] heap, int elem, int size) {
        heap[size] = elem;
        int idx = size;

        size++;

        while (idx >= 0) {
            int parentIdx = (idx - 1) / 2;

            if (parentIdx >= 0 && heap[parentIdx] < heap[idx]) {
                int temp = heap[parentIdx];
                heap[parentIdx] = heap[idx];
                heap[idx] = temp;

                idx = parentIdx;
            } else {
                break;
            }
        }

        return size;
    }
}
