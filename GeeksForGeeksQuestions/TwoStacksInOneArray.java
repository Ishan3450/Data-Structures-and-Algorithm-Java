public class TwoStacksInOneArray {
    // stacks
    private int[] stack = new int[100];

    // stack pointers
    private int top1 = -1, top2 = 100;

    // Function to push an integer into the stack1.
    void push1(int x) {
        if (isEmpty()) {
            stack[++top1] = x;
        }
    }

    // Function to push an integer into the stack2.
    void push2(int x) {
        if (isEmpty()) {
            stack[--top2] = x;
        }
    }

    // Function to remove an element from top of the stack1.
    int pop1() {
        int res = -1;
        if (top1 >= 0) {
            res = stack[top1--];
        }
        return res;
    }

    // Function to remove an element from top of the stack2.
    int pop2() {
        int res = -1;
        if (top2 < 100) {
            res = stack[top2++];
        }
        return res;
    }

    boolean isEmpty() {
        return top2 - top1 > 0 ? true : false;
    }
}
