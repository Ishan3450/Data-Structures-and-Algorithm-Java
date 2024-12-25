package Trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class IterativePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        while (!st.isEmpty()) {
            TreeNode top = st.pop();

            list.add(top.val);

            if (top.right != null) {
                st.push(top.right);
            }

            if (top.left != null) {
                st.push(top.left);
            }
        }
        return list;
    }
}
