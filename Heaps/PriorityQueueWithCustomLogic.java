package Heaps;

import java.util.PriorityQueue;

public class PriorityQueueWithCustomLogic {
    private static class Customer implements Comparable<Customer>{
        int id;
        int amount;
        String name;

        Customer(int id, int amount, String name){
            this.id = id;
            this.amount = amount;
            this.name = name;
        }

        @Override
        public int compareTo(Customer curr) {
            // for min heap
            // return curr.id > this.id ? 1 : -1;

            // for max heap
            return this.id > curr.id ? 1 : -1;
        }
        
        @Override
        public String toString() {
            return this.id + "";
        }
    }

    public static void main(String[] args) {
        PriorityQueue<Customer> q = new PriorityQueue<>();

        q.add(new Customer(10, 100, "null"));
        q.add(new Customer(8, 100, "null"));
        q.add(new Customer(4, 100, "null"));
        q.add(new Customer(100, 100, "null"));

        System.out.println(q);
    }
}
