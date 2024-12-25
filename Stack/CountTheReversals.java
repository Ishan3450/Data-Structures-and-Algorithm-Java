package Stack;

import java.util.Stack;

public class CountTheReversals {
    int countRev(String s) {
        // edge case
        if (s.length() % 2 != 0) {
            return -1;
        }

        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);

            if (st.isEmpty() || curr == '{') {
                st.push(curr);
            } else { // we got a closing one
                if (st.peek() == '{') {
                    st.pop();
                } else {
                    st.push(curr);
                }
            }
        }

        if (st.size() % 2 != 0) {
            return -1;
        }

        int count = 0;
        int times = st.size() / 2;

        for (int i = 1; i <= times; i++) {
            char ch1 = st.pop();
            char ch2 = st.pop();

            // case 1
            if (ch1 == ch2) {
                count++;
            } else { // case 2
                count += 2;
            }
        }
        return count;
    }
}
