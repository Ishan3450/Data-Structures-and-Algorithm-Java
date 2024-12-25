package Trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindDuplicateSubtree {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        helper(root, list, map);
        return list;
    }

    public String helper(TreeNode root, List<TreeNode> list, HashMap<String, Integer> map) {
        // base condition
        if (root == null) {
            return "N";
        }

        // function body
        String left = helper(root.left, list, map);
        String right = helper(root.right, list, map);
        String combined = root.val + "," + left + "," + right;

        if (!map.containsKey(combined)) {
            map.put(combined, 1);
        } else {
            if (map.get(combined) == 1) {
                list.add(root);
            }
            map.put(combined, map.get(combined) + 1);
        }

        return combined;
    }
}
