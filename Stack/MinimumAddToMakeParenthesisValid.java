package Stack;

import java.util.Stack;

public class MinimumAddToMakeParenthesisValid {

    // APproach using stack
    public int minAddToMakeValidSlow(String s) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (st.isEmpty() || ch == '(') {
                st.push(ch);
            } else { // we got a closing bracket
                if (st.peek() == '(') {
                    st.pop();
                } else {
                    st.push(ch);
                }
            }
        }

        return st.size();
    }

    // appraoch faster than the stack approach
    public int minAddToMakeValidFast(String s) {
        int minAdds = 0;
        int balance = 0;

        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);

            if (curr == '(') {
                balance++;
            } else {
                balance--;

                if (balance < 0) {
                    minAdds++;
                    balance = 0;
                }
            }
        }

        if (balance != 0) {
            minAdds += balance;
        }

        return minAdds;
    }
}
