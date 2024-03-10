/*
 * Solved using backtracking & recursion
 */

package Stack;

import java.util.Stack;

public class DeleteMiddleElementFromStack {
    static Stack<Integer> deleteMiddle(Stack<Integer> s, int N, int count){
        // base condition
        if(count == N/2){
            System.out.println("Count " + count);
            System.out.println("Peek " + s.peek());
            System.out.println(N/2);
            s.pop();
            return s;
        }

        // function body
        int poppedData = s.pop(); 
        deleteMiddle(s, N, count+1);
        
        // inserrting back the poppedData 
        s.push(poppedData);

        return s;
    }
    public static void main(String[] args){
        Stack<Integer> s = new Stack<>();

        // 83 74 67 49 94 8 11 1  
        s.push(83);
        s.push(74);
        s.push(67);
        s.push(49);
        s.push(94);
        s.push(8);
        s.push(11);
        s.push(1);



        // for(int i=1; i<=6; i++){
        //     s.push(i);
        // }

        System.out.println(deleteMiddle(s, s.size(), 0));
    }
}
