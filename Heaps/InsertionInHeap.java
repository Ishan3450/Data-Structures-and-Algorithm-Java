package Heaps;

// using Heap class from the same folder

public class InsertionInHeap {
    public static void main(String[] args) {
        Heap h = new Heap(100);
        h.insert(100);
        h.insert(50);
        h.insert(60);
        h.insert(40);
        h.insert(45);
        h.insert(110);
        h.printHeap();
    }
}
