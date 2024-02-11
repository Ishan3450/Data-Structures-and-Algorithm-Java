package DynamicProgramming;

import java.util.HashMap;

public class HouseRobber3 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int rob(TreeNode root) {
        // return recursive(root);
        return memoization(root, new HashMap<>());
    }

    // * more better approach is available int the trees folder

    /*
     * tabulation approach makes no sense in trees as normally we traverse
     * recursively
     */

    // memoization
    public int memoization(TreeNode root, HashMap<TreeNode, Integer> dp) {
        // base condition
        if (root == null)
            return 0;

        if (dp.containsKey(root)) {
            return dp.get(root);
        }

        // function body
        int include = root.val;

        if (root.left != null) {
            include += memoization(root.left.left, dp) + memoization(root.left.right, dp);
        }

        if (root.right != null) {
            include += memoization(root.right.right, dp) + memoization(root.right.left, dp);
        }

        int exclude = memoization(root.left, dp) + memoization(root.right, dp);

        dp.put(root, Math.max(include, exclude));
        return dp.get(root);
    }

    // recursive
    public int recursive(TreeNode root) {
        // base condition
        if (root == null)
            return 0;

        // function body
        int include = root.val;

        if (root.left != null) {
            include += recursive(root.left.left) + recursive(root.left.right);
        }

        if (root.right != null) {
            include += recursive(root.right.right) + recursive(root.right.left);
        }

        int exclude = recursive(root.left) + recursive(root.right);

        return Math.max(include, exclude);
    }
}
