package Stack;

import java.util.Stack;

public class LongestValidParenthesis {
    public int longestValidParentheses(String s) {
        int ans = 0;
        Stack<Integer> st = new Stack<>();
        st.push(-1);

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                st.push(i);
            } else { // we got a closing bracket
                st.pop();

                if (st.isEmpty()) {
                    st.push(i);
                } else {
                    ans = Math.max(ans, i - st.peek());
                }
            }
        }
        return ans;
    }
}

// 012345
// )()())

// >>>
// 0 5

// 0 1 2 3 4 5 6 7 8 9
// ) ( ) ( ( ) ) ( ( )

// 0 7 8

// 2 5 6

// ) found then pop from st and check
// if st is empty or not
// if empty then push curr idx
// else find length by currIdx - st.top