import java.util.Stack;

public class DeleteMiddleElementOfStack {
    // Function to delete middle element of a stack.
    public void deleteMid(Stack<Integer> s, int sizeOfStack) {
        deleteMidHelper(s, sizeOfStack, (int) Math.ceil((sizeOfStack + 1) / 2));
    }

    private void deleteMidHelper(Stack<Integer> s, int size, int idxToDelete) {
        // base condition
        if (s.isEmpty() || size == 0) { // any one can be the condition to eleminate the further recursion
            return;
        }

        // function body
        int poppedElement = s.pop();
        if (size == idxToDelete) {
            deleteMidHelper(s, size - 1, idxToDelete);
        } else {
            deleteMidHelper(s, size - 1, idxToDelete);
            s.push(poppedElement);
        }
    }

}
