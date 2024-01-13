package Heaps;

import java.util.LinkedList;
import java.util.Queue;

public class CompletenessOfBinaryTree {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }



    // Approach using level order traversal
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean isEnd = false;

        while (!q.isEmpty()) {
            TreeNode front = q.remove();

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
