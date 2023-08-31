package Trees;

import java.util.ArrayList;
import java.util.List;

public class RightViewOfBinaryTree {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        helper(root, 0, list);
        return list;
    }

    public void helper(TreeNode root, int level, List<Integer> nodes) {
        // base condition
        if (root == null) {
            return;
        }

        // function body
        if (level == nodes.size()) {
            nodes.add(root.val);
        }

        helper(root.right, level + 1, nodes);
        helper(root.left, level + 1, nodes);
    }
}
