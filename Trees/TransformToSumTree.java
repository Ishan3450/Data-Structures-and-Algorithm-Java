package Trees;

public class TransformToSumTree {
    private class Node{
        int data;
        Node left, right;
    }
    public void toSumTree(Node root) {
        helper(root);
    }

    public int helper(Node root) {
        // base condition
        if (root == null) {
            return 0;
        }

        // function body
        int leftPart = helper(root.left);
        int rightPart = helper(root.right);

        int temp = root.data;
        root.data = leftPart + rightPart;
        return temp + root.data;
    }
}
