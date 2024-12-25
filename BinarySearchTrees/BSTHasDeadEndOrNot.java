package BinarySearchTrees;

import java.util.HashMap;

public class BSTHasDeadEndOrNot {
    public static boolean isDeadEnd(Node root) {
        boolean[] ans = new boolean[1];
        HashMap<Integer, Boolean> visited = new HashMap<>();
        helper(root, visited, ans);
        return ans[0];
    }

    private static void helper(Node root, HashMap<Integer, Boolean> visited, boolean[] ans) {
        // base condition
        if (root == null || ans[0])
            return;

        // function body
        visited.put(root.data, true);
        if (root.left == null && root.right == null) {
            int lb = root.data - 1 == 0 ? 1 : root.data - 1;
            int up = root.data + 1;

            if (visited.containsKey(lb) && visited.containsKey(up) && visited.get(lb) && visited.get(up)) {
                ans[0] = true;
                return;
            }
        }
        helper(root.left, visited, ans);
        helper(root.right, visited, ans);
    }
}
