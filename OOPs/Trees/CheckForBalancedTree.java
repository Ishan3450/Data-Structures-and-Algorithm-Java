package OOPs.Trees;

public class CheckForBalancedTree {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // Function to check whether a binary tree is balanced or not.
    boolean isBalanced(Node root) {
        // Your code here
        if (getHeight(root, 0) == -1) {
            return false;
        }
        return true;
    }

    int getHeight(Node root, int count) {
        // base condition
        if (root == null || count == -1) {
            return count;
        }

        int left = getHeight(root.left, count + 1);
        int right = getHeight(root.right, count + 1);

        if (Math.abs(left - right) > 1) { // as height should not be > 1
            return -1;
        }

        return Math.max(left, right);
    }

    // to implement main method copy code form the HeightOfTree.java file
}
