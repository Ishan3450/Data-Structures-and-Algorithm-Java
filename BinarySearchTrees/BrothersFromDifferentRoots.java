package BinarySearchTrees;

import java.util.Stack;

public class BrothersFromDifferentRoots {
    public static int countPairs(Node root1, Node root2, int x) {
        Stack<Node> st1 = new Stack<>();
        Stack<Node> st2 = new Stack<>();
        int count = 0;

        Node a = root1;
        Node b = root2;

        while (true) {
            while (a != null) {
                st1.push(a);
                a = a.left;
            }

            while (b != null) {
                st2.push(b);
                b = b.right;
            }

            if (st1.isEmpty() || st2.isEmpty()) {
                break;
            }

            Node aTop = st1.peek();
            Node bTop = st2.peek();
            int sum = aTop.data + bTop.data;

            if (sum == x) {
                count++;
                st1.pop();
                st2.pop();
                a = aTop.right;
                b = bTop.left;
            } else if (sum < x) {
                st1.pop();
                a = aTop.right;
            } else {
                st2.pop();
                b = bTop.left;
            }
        }
        return count;
    }
}
