package Heaps;

import java.util.Arrays;

public class BuildHeap {
    public static void main(String[] args) {
        int[] heap = { -1, 12, 56, 43, 6, 78, 87, 5, 44, 3, 23, 32 };
        buildHeap(heap, heap.length);
        System.out.println(Arrays.toString(heap));
    }

    public static void buildHeap(int[] heap, int n) {
        for (int i = n / 2; i > 0; i--) {
            heapify(heap, n, i);
        }
    }

    private static void heapify(int[] heap, int size, int idxToHeapify) {
        // base condition
        if (idxToHeapify > size) {
            return;
        }

        // function body
        int leftIdx = idxToHeapify * 2;
        int rightIdx = idxToHeapify * 2 + 1;
        int largest = idxToHeapify;

        if (leftIdx < size && heap[leftIdx] > heap[largest]) {
            largest = leftIdx;
        }

        if (rightIdx < size && heap[rightIdx] > heap[largest]) {
            largest = rightIdx;
        }

        if (largest != idxToHeapify) {
            int temp = heap[largest];
            heap[largest] = heap[idxToHeapify];
            heap[idxToHeapify] = temp;

            heapify(heap, size, largest);
        }
    }
}
