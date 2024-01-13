package Heaps;

import java.util.LinkedList;
import java.util.Queue;

public class IsBinaryTreeHeap {

    private class Node {
        int data;
        Node left, right;

        Node(int d) {
            data = d;
            left = right = null;
        }
    }

    private class Pair {
        int val;
        boolean isHeap;

        Pair(int val, boolean isHeap) {
            this.val = val;
            this.isHeap = isHeap;
        }
    }

    boolean isHeap(Node tree) {
        // base condition
        if (!isCompleteBinaryTree(tree)) {
            return false;
        }
        return helper(tree).isHeap;
    }

    Pair helper(Node root) {
        // base condition
        if (root == null) {
            return new Pair(Integer.MIN_VALUE, true);
        }

        if (root.left == null && root.right == null) {
            return new Pair(root.data, true);
        }

        // function body
        Pair left = helper(root.left);
        Pair right = helper(root.right);

        if (left.isHeap && right.isHeap && root.data > left.val && root.data > right.val) {
            return new Pair(root.data, true);
        }
        return new Pair(-1, false);
    }

    boolean isCompleteBinaryTree(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        boolean isEnd = false;

        while (!q.isEmpty()) {
            Node front = q.remove();

            if (front == null) {
                isEnd = true;
            } else {
                if (isEnd) {
                    return false;
                }

                q.add(front.left);
                q.add(front.right);
            }
        }
        return true;
    }
}
