package Stack;

import java.util.HashMap;
import java.util.Stack;

public class ReverseSubstringsBetweenEachPairOfParentheses {
    public String reverseParentheses(String s) {
        HashMap<Integer, Integer> door = createTeleportationDoors(s);
        boolean goingLeft = false;
        StringBuilder output = new StringBuilder();

        int idx = 0;

        while (idx >= 0 && idx < s.length()) {
            char curr = s.charAt(idx);

            if (Character.isAlphabetic(curr)) {
                output.append(curr);
            } else if (curr == '(' || curr == ')') {
                idx = door.get(idx);
                goingLeft = !goingLeft;
            }

            if (goingLeft) {
                idx--;
            } else {
                idx++;
            }
        }

        return output.toString();
    }

    private HashMap<Integer, Integer> createTeleportationDoors(String s) {
        HashMap<Integer, Integer> door = new HashMap<>();
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);

            if (curr == '(') {
                st.push(i);
            } else if (curr == ')') {
                // closing is i
                // opening is st.peek()
                int correspondingBracket = st.pop();

                door.put(correspondingBracket, i);
                door.put(i, correspondingBracket);
            }
        }

        return door;
    }
}