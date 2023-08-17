package StackQuestions;

import java.util.Stack;

public class DecodeString {
    public String decodeString(String s) {
        Stack<String> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);

            if (curr != ']') {
                st.push(curr + "");
            } else {
                StringBuilder inBetween = new StringBuilder();
                while (!st.isEmpty() && !st.peek().equals("[")) {
                    inBetween.append(st.pop());
                }
                st.pop();

                // System.out.println(inBetween);

                StringBuilder timesToRepeat = new StringBuilder();
                while (!st.isEmpty() && Character.isDigit(st.peek().charAt(0))) {
                    timesToRepeat.append(st.pop());
                }

                // System.out.println(timesToRepeat);

                int timesToRepeatP = Integer.parseInt(timesToRepeat.reverse().toString());

                // System.out.println(timesToRepeatP);

                StringBuilder subString = new StringBuilder();
                while (timesToRepeatP != 0) {
                    subString.append(inBetween);
                    timesToRepeatP--;
                }

                st.push(subString.toString());

                // System.out.println(subString);
            }

        }

        StringBuilder ans = new StringBuilder();
        while (!st.isEmpty()) {
            ans.append(st.pop());
        }

        return ans.reverse().toString();
    }
}
