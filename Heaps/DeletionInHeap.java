package Heaps;

public class DeletionInHeap {
    public static void main(String[] args) {
        Heap h = new Heap(100);
        h.insert(100);
        h.insert(50);
        h.insert(60);
        h.insert(40);
        h.insert(45);
        h.insert(110);

        h.printHeap();

        System.out.println(h.delete());
        h.printHeap();
        System.out.println(h.delete());
        h.printHeap();
        System.out.println(h.delete());
        h.printHeap();
        System.out.println(h.delete());
        h.printHeap();
    }
}
