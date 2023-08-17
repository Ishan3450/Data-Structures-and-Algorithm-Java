package StackQuestions;

import java.util.Stack;

public class MinimumAddToMakeParenthesisValid {
    public int minAddToMakeValid(String s) {
        Stack<Character> st = new Stack<>();
        for(int i = 0 ; i < s.length(); i++){
            char ch = s.charAt(i);

            if(st.isEmpty() || ch == '('){
                st.push(ch);
            } else{ // we got a closing bracket
                if(st.peek() == '('){
                    st.pop();
                } else{
                    st.push(ch);
                }
            }
        }

        return st.size();
    }
}
