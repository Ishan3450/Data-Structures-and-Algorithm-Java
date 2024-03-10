package Stack;

import java.util.Stack;

public class CheckIfWordIsValidAfterSubstitution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();

        for(int i = 0 ; i < s.length(); i ++){
            char curr = s.charAt(i);

            if(curr == 'a'){
                st.push(curr);
            } else if(curr == 'b'){
                if(!st.isEmpty() && st.peek() == 'a'){
                    st.push(curr);
                } else{
                    return false;
                }
            } else{ // found c
                if(!st.isEmpty() && st.peek() == 'b'){
                    st.pop();
                    st.pop();
                } else{
                    return false;
                }
            }
        }

        return st.isEmpty();
    }
}
