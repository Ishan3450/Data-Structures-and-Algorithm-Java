package BinarySearchTrees;

public class CreateBST {
    public static TreeNode createBST(TreeNode root, int data) {
        // base condition
        if (root == null) {
            return new TreeNode(data);
        }

        // function body
        if (root.val > data) {
            root.left = createBST(root.left, data);
        } else {
            root.right = createBST(root.right, data);
        }
        return root;
    }

    public static void main(String[] args) {

    }
}
