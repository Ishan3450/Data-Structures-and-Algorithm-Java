package BinarySearchTrees;

public class DeleteNodeInBST {
    public TreeNode deleteNode(TreeNode root, int key) {
        // base condition
        if (root == null) {
            return null;
        }

        // function body
        if (root.val == key) {
            // it is the node to be deleted
            if (root.left == null && root.right == null) {
                return null;
            } else if (root.left != null && root.right == null) {
                return root.left;
            } else if (root.left == null && root.right != null) {
                return root.right;
            } else {
                int inorderPredecessor = inorderPred(root.left);
                root.val = inorderPredecessor;
                root.left = deleteNode(root.left, inorderPredecessor);
                return root;
            }
        } else if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        }
        return root;
    }

    private int inorderPred(TreeNode root) {
        // base condition
        if (root == null) {
            return -1;
        }

        // function body
        TreeNode pred = root;
        while (pred.right != null) {
            pred = pred.right;
        }
        return pred.val;
    }
}
