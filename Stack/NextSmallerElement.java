/* 
 * Time: O(N) 
 */
package Stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class NextSmallerElement {
    static ArrayList<Integer> nextSmallerElement(ArrayList<Integer> arr, int n){
        // Write your code here.
        Stack<Integer> st = new Stack<>();
        st.push(-1); // adding initial value in the stack

        ArrayList<Integer> ans = new ArrayList<>(n);

        for(int i=n-1; i>=0; i--){ // will start from the back of the list
            int curr = arr.get(i);
            while(st.peek() >= curr){
                st.pop();
            }

            // at this line the top of the stack is the next smaller element
            ans.add(st.peek());
            st.push(curr); // adding curr in the stack for the next iteration
        }
        Collections.reverse(ans);
        return ans;
    }

    public static void main(String[] args){
        ArrayList<Integer> ans = new ArrayList<>();

        ans.add(6);
        ans.add(2);
        ans.add(5);
        ans.add(4);
        ans.add(5);
        ans.add(1);
        ans.add(6);

        System.out.println(nextSmallerElement(ans, ans.size()));
    }

}
