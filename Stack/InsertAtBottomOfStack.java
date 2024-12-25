/*
 * Solved using recursion with backtracking
 * 
 * conclusion: insert the given data when the stack becomes empty, and at last when we come out of the recursion call insert the previously popped element back in the stack.
 */

package Stack;

import java.util.Stack;

public class InsertAtBottomOfStack {
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
  
    public static void main(String[] args){
        Stack<Integer> s = new Stack<>();

        s.push(7);
        s.push(1);
        s.push(4);
        s.push(5);

        System.out.println(pushAtBottom(s, 9));
    }
}
