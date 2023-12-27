package LeetCodeQuestions;

import java.util.Stack;

public class Q1578 {
    private class Pair {
        char color;
        int neededTime;

        Pair(char color, int neededTime) {
            this.color = color;
            this.neededTime = neededTime;
        }
    }

    public int minCost(String colors, int[] neededTime) {
        Stack<Pair> st = new Stack<>();
        int totalTime = 0;

        for (int i = 0; i < neededTime.length; i++) {
            char currColor = colors.charAt(i);
            int currNeededTime = neededTime[i];

            if (st.isEmpty() || st.peek().color != currColor) {
                st.push(new Pair(currColor, currNeededTime));
            } else {
                if (currNeededTime <= st.peek().neededTime) {
                    totalTime += currNeededTime;
                } else {
                    Pair poppedPair = st.pop();
                    totalTime += poppedPair.neededTime;
                    st.push(new Pair(currColor, currNeededTime));
                }
            }
        }
        return totalTime;
    }
}
