package BinarySearchTrees;

public class RangeSumOfBST {
    public int rangeSumBST(TreeNode root, int low, int high) {
        // base condition
        if (root == null) {
            return 0;
        }

        // function body
        if (root.val >= low && root.val <= high) {
            return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
        } else if (root.val < low) {
            return rangeSumBST(root.right, low, high);
        } else if (root.val > high) {
            return rangeSumBST(root.left, low, high);
        }
        return -1;
    }
}
