package DynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTrees2 {
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

    public List<TreeNode> generateTrees(int n) {
        // return recursive(1, n);
        List<TreeNode>[][] dp = new List[n + 1][n + 1];
        return memoization(1, n, dp);
    }

    // memoization
    public List<TreeNode> memoization(int start, int end, List<TreeNode>[][] dp) {
        // base condition
        if (start > end) {
            List<TreeNode> list = new ArrayList<>();
            list.add(null);
            return list;
        }

        if (dp[start][end] != null) {
            return dp[start][end];
        }

        // function body
        List<TreeNode> allBsts = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            List<TreeNode> allLeftPossible = memoization(start, i - 1, dp);
            List<TreeNode> allRightPossible = memoization(i + 1, end, dp);

            for (int left = 0; left < allLeftPossible.size(); left++) {
                for (int right = 0; right < allRightPossible.size(); right++) {
                    TreeNode root = new TreeNode(i);
                    root.left = allLeftPossible.get(left);
                    root.right = allRightPossible.get(right);
                    allBsts.add(root);
                }
            }
        }

        dp[start][end] = allBsts;
        return allBsts;
    }

    // recursive
    public List<TreeNode> recursive(int start, int end) {
        // base condition
        if (start > end) {
            List<TreeNode> list = new ArrayList<>();
            list.add(null);
            return list;
        }

        // function body
        List<TreeNode> allBsts = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            List<TreeNode> allLeftPossible = recursive(start, i - 1);
            List<TreeNode> allRightPossible = recursive(i + 1, end);

            for (int left = 0; left < allLeftPossible.size(); left++) {
                for (int right = 0; right < allRightPossible.size(); right++) {
                    TreeNode root = new TreeNode(i);
                    root.left = allLeftPossible.get(left);
                    root.right = allRightPossible.get(right);
                    allBsts.add(root);
                }
            }
        }

        return allBsts;
    }
}
