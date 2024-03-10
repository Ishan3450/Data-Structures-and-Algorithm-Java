package Queues;

import java.util.*;
public class QueueInterleaving {

    public static void interLeavedQueue(Queue<Integer> q){
        int n = (q.size()/2);
        Queue<Integer> firstHalf = new LinkedList<>();

        for(int i=0; i<n; i++){
            firstHalf.add(q.poll());
        }

        System.out.println(firstHalf);

        while(!firstHalf.isEmpty()){
            q.add(firstHalf.poll());
            q.add(q.poll());
        }

        System.out.println(q);
    }

    public static void main(String[] args){
        Queue<Integer> q = new LinkedList<>();

        for(int i=11; i<=20; i++){
            q.add(i);
        }

        interLeavedQueue(q);
    }
}
