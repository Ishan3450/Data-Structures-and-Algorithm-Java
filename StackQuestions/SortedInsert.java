package StackQuestions;

import java.util.Stack;

public class SortedInsert {
    public static void sortedInsert(Stack<Integer> s, int data){
        // base condition
        if(s.isEmpty() || s.peek() < data){
            s.push(data);
            return;
        }

        int popped = s.pop();
        sortedInsert(s, data);
        s.push(popped);
    }

    public static void main(String[] args){
        Stack<Integer> s = new Stack<>();

        s.push(1);
        s.push(5);
        s.push(8);

        System.out.println(s);
        sortedInsert(s, 6);
        System.out.println(s);

    }
}
