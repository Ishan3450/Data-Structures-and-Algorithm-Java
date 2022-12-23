package QueueQuestions;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class queue {
    public static void main(String[] args){
        Queue<Integer> q = new LinkedList<>();
        

        // add adds an element in the queue
        for(int i=1; i<=5; i++){
            q.add(i);
        }

        /*
         * remove and poll both have same work:
         * - both remove the head of the queue and return the head
         * - but the main difference is if queue is empty: remove returns an exception and poll return null. That's it !
         */
        System.out.println(q.remove());
        System.out.println(q.poll());

        q.element(); // only return the head of the queue
        q.contains(3); // check if the passes param is present in the queue or not

        /*
         * Doubly Ended Queue
         */
        Deque<Integer> dq = new LinkedList<>();

        dq.addFirst(1);
        dq.addLast(3);

        System.out.println(dq);
    }
}
