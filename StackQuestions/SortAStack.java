package StackQuestions;

import java.util.Stack;

public class SortAStack {
    public static void sortedInsert(Stack<Integer> s, int data) {
        // base condition
        if(s.empty() || s.peek() < data){
            s.push(data);
            return;
        }

        // function body
        int popped = s.pop();
        sortedInsert(s, data); // recursive call
        s.push(popped);

    }

    public static void sortStack(Stack<Integer> stack) {
        // base condition
        if(stack.isEmpty()){ // when stack becomes empty start reverting back towards the original call
            return;
        }

        // function body
        int data = stack.pop();
        sortStack(stack);

        sortedInsert(stack, data);
        /*
         * we don't have to insert the popped data back in the stack because the function: sortedInsert() do it for us 
         */
    }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();

        s.push(6);
        s.push(1);
        s.push(8);
        s.push(-2);
        s.push(-4);

        System.out.println(s);
        sortStack(s);
        System.out.println(s);
    }
}
