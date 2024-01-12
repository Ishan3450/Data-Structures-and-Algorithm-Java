package Heaps;

import java.util.*;

// TC: O(N log N)
public class HeapSort {
    public static void main(String[] args) {
        int[] heap = {-1, 87, 78, 43, 44, 56, 12, 5, 6, 3, 23, 32};

        // provide a valid heap or run buildHeap method

        System.out.println(heapSort(heap, heap.length - 1));
    }

    public static ArrayList<Integer> heapSort(int[] heap, int size) {
        ArrayList<Integer> list = new ArrayList<>();

        while (size > 0) {
            list.add(heap[1]);
            heap[1] = heap[size];
            size--;

            heapify(heap, size, 1);
        }

        return list;
    }

    private static void heapify(int[] heap, int size, int idx) {
        while (idx <= size) {
            int leftIdx = idx * 2;
            int rightIdx = idx * 2 + 1;

            int largest = idx;

            if (leftIdx <= size && heap[leftIdx] > heap[largest]) {
                largest = leftIdx;
            }

            if (rightIdx <= size && heap[rightIdx] > heap[largest]) {
                largest = rightIdx;
            }

            if (idx != largest) {
                int temp = heap[largest];
                heap[largest] = heap[idx];
                heap[idx] = temp;

                idx = largest;
            } else {
                break;
            }
        }
    }
}
