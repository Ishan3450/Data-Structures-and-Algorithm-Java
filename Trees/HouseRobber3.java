package Trees;

public class HouseRobber3 {
    private class Pair {
        int include;
        int exclude;

        Pair(int include, int exclude) {
            this.include = include;
            this.exclude = exclude;
        }
    }

    public int rob(TreeNode root) {
        Pair p = helper(root);
        return Math.max(p.include, p.exclude);
    }

    public Pair helper(TreeNode root) {
        // base condition
        if (root == null) {
            return new Pair(0, 0);
        }

        // function body
        Pair left = helper(root.left);
        Pair right = helper(root.right);

        return new Pair(left.exclude + root.val + right.exclude,
                Math.max(left.include, left.exclude) + Math.max(right.include, right.exclude));
    }
}
