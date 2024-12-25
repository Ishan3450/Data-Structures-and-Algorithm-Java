package Heaps;

// Terminologies:

// For 1-based index
// --------------------------
// Left Child: 2*i
// Right Child: 2*i+1
// Parent: i/2

// For 0-based index
// --------------------------
// Left Child: 2*i+1
// Right Child: 2*i+2
// Parent: i/2 - 1


// Leaf nodes: from n/2+1 to n are leaf nodes

public class Heap {
    /*
     * Max Heap
     */

    int[] heap;
    int size;

    Heap(int size) {
        heap = new int[size];
        size = 1; // size is 1 because of 1-based indexing
    }

    public void printHeap() {
        for (int i = 1; i <= size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }

    public int[] getHeap() {
        return heap;
    }

    /*
     * Insertion in heap
     * 
     * TC: O(log N)
     */
    public void insert(int val) {
        size++;
        heap[size] = val;
        int idx = size;

        while (idx > 1 && heap[idx / 2] < val) {
            int parentIdx = idx / 2;

            // swapping parent and the curr
            int temp = heap[parentIdx];
            heap[parentIdx] = heap[idx];
            heap[idx] = temp;

            idx = parentIdx;
        }
    }

    /*
     * Deletion in heap
     * 
     * Deletion in heap occurs only from the root of the heap
     * TC: O(log N)
     */ 
    public int delete() {
        int deletedVal = heap[1];

        heap[1] = heap[size];
        size --;

        int idx = 1;

        int leftIdx = idx*2;
        int rightIdx = idx*2+1;

        while((leftIdx <= size || rightIdx <= size)){
            int largestElemIdx = idx;
            
            if(heap[largestElemIdx] < heap[leftIdx]){
                largestElemIdx = leftIdx;
            }

            if(heap[largestElemIdx] < heap[rightIdx]){
                largestElemIdx = rightIdx;
            }

            int temp = heap[largestElemIdx];
            heap[largestElemIdx] = heap[idx];
            heap[idx] = temp;

            idx = largestElemIdx;
            leftIdx = idx*2;
            rightIdx = idx*2+1;
        }

        return deletedVal;
    }

}