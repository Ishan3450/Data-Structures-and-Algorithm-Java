package Heaps;

import java.util.Arrays;

public class Heapify {
    public static void main(String[] args) {
        int[] heap = {0, 10,20,30,40,50,60,70,100}; // 1-based thats why heap[0] is 0
        heapify(heap, heap.length-1, 1);
        System.out.println(Arrays.toString(heap));
    }

    public static void heapify(int[] heap, int size, int idxToHeapify){
        // base condition
        if(idxToHeapify > size){
            return;
        }

        // function body
        int leftIdx = idxToHeapify*2;
        int rightIdx = idxToHeapify*2+1;
        int largest = idxToHeapify;

        if(leftIdx < size && heap[leftIdx] > heap[largest]){
            largest = leftIdx;
        }

        if(rightIdx < size && heap[rightIdx] > heap[largest]){
            largest = rightIdx;
        }

        if(largest != idxToHeapify){
            int temp = heap[largest];
            heap[largest] = heap[idxToHeapify];
            heap[idxToHeapify] = temp;

            heapify(heap, size, largest);
        }
    }
}
