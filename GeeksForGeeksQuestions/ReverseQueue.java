import java.util.Queue;
import java.util.Stack;

public class ReverseQueue {
    public Queue<Integer> rev(Queue<Integer> q) {
        // add code here.
        Stack<Integer> st = new Stack<>();

        while (!q.isEmpty()) {
            st.push(q.poll());
        }

        while (!st.isEmpty()) {
            q.add(st.pop());
        }

        return q;
    }

}
