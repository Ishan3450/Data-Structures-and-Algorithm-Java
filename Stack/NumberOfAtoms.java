package Stack;

import java.util.HashMap;
import java.util.Stack;
import java.util.TreeMap;

public class NumberOfAtoms {
    public String countOfAtoms(String formula) {
        int i = 0;
        Stack<HashMap<String, Integer>> st = new Stack<>();
        st.push(new HashMap<>());

        while (i < formula.length()) {
            if (formula.charAt(i) == '(') {
                // push a new hashmap in the stack
                st.push(new HashMap<>());
                i++;
            } else if (formula.charAt(i) == ')') {
                // check if a multiplier is available if available then multiply it with the top
                // of the stack and merge it with the latest top just after curr one
                StringBuilder multiplier = new StringBuilder();
                i++; // shifting from ')' char index
                while (i < formula.length() && Character.isDigit(formula.charAt(i))) {
                    multiplier.append(formula.charAt(i));
                    i++;
                }

                int multiplierInt = multiplier.length() == 0 ? 1 : Integer.parseInt(multiplier.toString());

                HashMap<String, Integer> top = st.pop();
                for (String key : top.keySet()) {
                    // merging curr top with the latest top
                    st.peek().put(key, st.peek().getOrDefault(key, 0) + (top.get(key) * multiplierInt));
                }
            } else { // alphabet is found
                // form string, and check for occr of that string
                StringBuilder sb = new StringBuilder();
                sb.append(formula.charAt(i));
                i++;

                while (i < formula.length() && Character.isLowerCase(formula.charAt(i))) {
                    sb.append(formula.charAt(i));
                    i++;
                }

                StringBuilder occr = new StringBuilder();
                while (i < formula.length() && Character.isDigit(formula.charAt(i))) {
                    occr.append(formula.charAt(i));
                    i++;
                }
                if (occr.length() == 0) {
                    occr.append("1");
                }
                String sbStr = sb.toString();
                String occrStr = occr.toString();

                st.peek().put(sbStr, st.peek().getOrDefault(sbStr, 0) + Integer.parseInt(occr.toString()));
            }
        }

        TreeMap<String, Integer> lexographicallySorted = new TreeMap<>(st.peek());
        StringBuilder sb = new StringBuilder();

        for (String key : lexographicallySorted.keySet()) {
            sb.append(key);

            if (lexographicallySorted.get(key) > 1) {
                sb.append(lexographicallySorted.get(key));
            }
        }
        return sb.toString();
    }
}
