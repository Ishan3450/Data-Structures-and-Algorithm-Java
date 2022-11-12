package StackQuestions;

import java.util.Stack;

public class ReverseStackUsingRecursion {
    public static Stack<Integer> pushAtBottom(Stack <Integer> s, int x){
        // base condition
        if(s.empty()){
            s.push(x);
            return s;
        }

        // function body
        int poppedData = s.pop();
        s = pushAtBottom(s, x);
        s.push(poppedData);

        return s;
    }

	public static void reverseStack(Stack<Integer> stack) {
		// base condition
        if(stack.empty()){
            return;
        }

        // function body
        int poppedData = stack.pop();
        reverseStack(stack);
        stack = pushAtBottom(stack, poppedData);
		
	}

    public static void main(String[] args){
        Stack<Integer> s = new Stack<>();

        s.push(3);
        s.push(1);
        // s.push(2);
        // s.push(4);

        System.out.println(s);
        reverseStack(s);
        System.out.println(s);
    }
}
