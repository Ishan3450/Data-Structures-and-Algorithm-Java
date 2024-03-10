package Stack;

import java.util.Stack;

import javafx.util.Pair;

public class OnlineStockSpan {
    Stack<Pair<Integer, Integer>> st;

    public OnlineStockSpan() {
        st = new Stack<>();
    }

    public int next(int price) {
        int span = 1;

        while (!st.isEmpty() && st.peek().getKey() <= price) {
            span += st.peek().getValue();
            st.pop();
        }

        st.push(new Pair<>(price, span));
        return span;
    }
}
