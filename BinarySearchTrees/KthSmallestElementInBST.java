package BinarySearchTrees;

// https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/

public class KthSmallestElementInBST {
    public int kthSmallest(TreeNode root, int k) {
        return helper(root, new int[]{k});
    }
    
    private int helper(TreeNode root, int[] k){
        // base condition
        if(root == null){
            return -1;
        }

        // inorder traversal
        int left = helper(root.left, k);
        if(left != -1) return left;
        if(--k[0] == 0) return root.val;
        return helper(root.right, k);
    }
}
