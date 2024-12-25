package Queues;

import java.util.Queue;
import java.util.Stack;
import java.util.LinkedList;

/*
 * Two approaches to reverse:
 * 1. use stack
 * 2. using recursion
 */
public class ReverseAQueue {
    /* Using Stack */
    public static Queue<Integer> rev(Queue<Integer> q){
        Queue<Integer> ans = new LinkedList<>();

        Stack<Integer> st = new Stack<>();

        for(Integer item: q){
            st.push(item);
        }

        while(!st.isEmpty()){
            ans.add(st.pop());
        }

        return ans;
    }

    public static void main(String[] args){
        Queue<Integer> q = new LinkedList<>();
        Queue<Integer> ans = new LinkedList<>();
        q.add(4);
        q.add(4);
        q.add(4);
        q.add(4);

        System.out.println(rev(q));
    }
}
