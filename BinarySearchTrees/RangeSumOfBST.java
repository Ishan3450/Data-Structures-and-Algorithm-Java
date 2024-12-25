package BinarySearchTrees;

public class RangeSumOfBST {
    public int rangeSumBST(TreeNode root, int low, int high) {
        // base condition
        if(root == null){
            return 0;
        }

        // function body
        if(root.val >= low && root.val <= high){
            return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
        }

        if(root.val < low){
            return rangeSumBST(root.right, low, high);
        }

        // root.val > high
        return rangeSumBST(root.left, low, high);
    }
}

// if node in range then do both left and right calls
// if node.val < low then do only right call
// if node.val > high then do only left call