package BinarySearchTrees;

public class CreateBSTFromInorder {
    public static TreeNode create(int[] inorder, int start, int end) {
        // base condition
        if (start > end) {
            return null;
        }

        // function body
        int mid = (start + end) / 2;

        TreeNode root = new TreeNode(inorder[mid]);
        root.left = create(inorder, start, mid - 1);
        root.right = create(inorder, mid + 1, end);
        return root;
    }
}
