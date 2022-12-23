import java.util.*;

public class NextGreaterElement {
    public static int[] nextGreater(int[] arr, int n){
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[n];

        st.push(-1);

        for(int i=n-1; i>=0; i--){
            int curr = arr[i];

            while(curr >= st.peek()){
                st.pop();
            }

            ans[i] = st.peek();
            st.push(curr);
        }

        return ans;
    }

    public static void main(String[] args){
        int[] arr = {1,3,2,4};
        System.out.println(Arrays.toString(nextGreater(arr, arr.length)));
    }
}
