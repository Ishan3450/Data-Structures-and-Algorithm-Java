package Queues;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseFirstKElementOfQueue { 
    // using traditional queue
    public Queue<Integer> modifyQueue(Queue<Integer> q, int k) {
        // add code here.
        int temp = k;
        Stack<Integer> st = new Stack<>();
        while (temp != 0) {
            st.push(q.poll());
            temp--;
        }

        Queue<Integer> ans = new LinkedList<>();
        while (!st.isEmpty()) {
            ans.add(st.pop());
        }

        while (!q.isEmpty()) {
            ans.add(q.poll());
        }
        return ans;
    }


}
