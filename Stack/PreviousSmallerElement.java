package Stack;

import java.util.ArrayList;
import java.util.Stack;

public class PreviousSmallerElement {
    static ArrayList<Integer> previousSmallerElement(ArrayList<Integer> arr, int n){
        Stack<Integer> st = new Stack<>();
        st.push(-1);

        ArrayList<Integer> ans = new ArrayList<>();

        for(int i=0; i<n; i++){
            int curr = arr.get(i);

            while(st.peek() >= curr){
                st.pop();
            }

            // at this point top is our answer
            ans.add(st.peek());
            // adding the curr int item in the stack for the next iterations
            st.push(curr);
        }

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

        System.out.println(previousSmallerElement(ans, ans.size()));
    }
}
