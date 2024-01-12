package Heaps;

import java.util.Collections;
import java.util.PriorityQueue;

public class PriorityQueueEx {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // min-heap
        PriorityQueue<Integer> pq2 = new PriorityQueue<>(Collections.reverseOrder()); // max-heap

        pq.add(3);
        pq.add(6);
        pq.add(9);
        pq.add(4);
        pq.add(8);

        System.out.println(pq);
        System.out.println(pq.remove());
        System.out.println(pq.poll());
    }
}
