package Heaps;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueWithCustomLogic {
    private static class Customer implements Comparable<Customer> {
        int id;
        int amount;
        String name;

        Customer(int id, int amount, String name) {
            this.id = id;
            this.amount = amount;
            this.name = name;
        }

        /*
         * This method returns:
         * 
         * It returns a negative integer if the current object (referred to as "this")
         * is less than the specified object.
         * It returns zero if the current object is equal to the specified object.
         * It returns a positive integer if the current object is greater than the
         * specified object.
         */
        @Override
        public int compareTo(Customer curr) {
            return this.id > curr.id ? 1 : -1;
        }

        @Override
        public String toString() {
            return this.id + "";
        }
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        public String toString() {
            return this.val + "";
        }
    }

    public static void main(String[] args) {
        PriorityQueue<Customer> q = new PriorityQueue<>();
        PriorityQueue<Customer> q2 = new PriorityQueue<>(Collections.reverseOrder()); // max heap

        q.add(new Customer(10, 100, "null"));
        q.add(new Customer(8, 100, "null"));
        q.add(new Customer(4, 100, "null"));
        q.add(new Customer(100, 100, "null"));

        q2.add(new Customer(10, 100, "null"));
        q2.add(new Customer(8, 100, "null"));
        q2.add(new Customer(4, 100, "null"));
        q2.add(new Customer(100, 100, "null"));

        System.out.println(q.peek());
        System.out.println(q2.peek());

        // passing custom comparator
        Comparator<ListNode> minHeapVal = new Comparator<ListNode>() {
            public int compare(ListNode l1, ListNode l2) {
                if (l1.val > l2.val) {
                    return 1;
                }
                return -1;
            }
        };
        PriorityQueue<ListNode> pq = new PriorityQueue<>(minHeapVal);

        pq.add(new ListNode(100));
        pq.add(new ListNode(1));
        pq.add(new ListNode(5));
        pq.add(new ListNode(80));

        // System.out.println(pq);
        // pq.remove();
        // pq.add(new ListNode(1));
        // System.out.println(pq);
    }
}
