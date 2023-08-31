package Trees;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> allPaths = new ArrayList<>();
        if (root != null) {
            helper(root, targetSum, new ArrayList<>(), allPaths);
        }
        return new ArrayList<>(allPaths);
    }

    public void helper(TreeNode root, int targetSum, List<Integer> path, List<List<Integer>> allPaths) {
        // base condition
        if (root == null) {
            return;
        }

        // function body
        if (root.left == null && root.right == null) {
            path.add(root.val);
            targetSum -= root.val;

            if (targetSum == 0) {
                allPaths.add(new ArrayList<>(path));
            }

            targetSum += root.val;
            path.remove(path.size() - 1);

            return;
        }

        path.add(root.val);
        helper(root.left, targetSum - root.val, path, allPaths);
        helper(root.right, targetSum - root.val, path, allPaths);
        path.remove(path.size() - 1);
    }
}
