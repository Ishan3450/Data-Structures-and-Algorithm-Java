package Stack;

import java.util.Stack;

public class RemoveAdjacentDuplicatesInString {
    public String removeDuplicates(String s) {
        Stack<Character> st = new Stack<>();

        for(int i = 0 ; i < s.length(); i++){
            char curr = s.charAt(i);

            if(!st.isEmpty() && st.peek() == curr){
                st.pop();
            } else{
                st.push(curr);
            }
        }

        char[] arr = new char[st.size()];
        for(int i = arr.length-1; i >= 0; i--){
            arr[i] = st.pop();
        }
        return new String(arr);
    }
}
