package BinarySearchTrees;

// HARD https://practice.geeksforgeeks.org/problems/merge-two-bst-s/1

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MergeTwoBSTs {
    public List<Integer> merge(Node root1, Node root2) {
        List<Integer> list = new ArrayList<>();
        Stack<Node> st1 = new Stack<>();
        Stack<Node> st2 = new Stack<>();

        Node a = root1;
        Node b = root2;

        while (true) {
            while (a != null) {
                st1.push(a);
                a = a.left;
            }
            while (b != null) {
                st2.push(b);
                b = b.left;
            }

            if (st1.isEmpty() && st2.isEmpty()) {
                break;
            }

            if (!st1.isEmpty() && !st2.isEmpty()) {
                Node aTop = st1.peek();
                Node bTop = st2.peek();

                if (aTop.data <= bTop.data) {
                    list.add(st1.pop().data);
                    a = aTop.right;
                } else {
                    list.add(st2.pop().data);
                    b = bTop.right;
                }
            } else if (!st1.isEmpty()) {
                Node aTop = st1.pop();
                list.add(aTop.data);
                a = aTop.right;
            } else {
                Node bTop = st2.pop();
                list.add(bTop.data);
                a = bTop.right;
            }
        }
        return list;
    }
}
