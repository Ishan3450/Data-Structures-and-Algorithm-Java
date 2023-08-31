package Trees;

import java.util.ArrayList;
import java.util.List;

public class PostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        // base condition
        if(root == null){
            return new ArrayList<>();
        }

        // function body
        List<Integer> list = new ArrayList<>();
        list.addAll(postorderTraversal(root.left));
        list.addAll(postorderTraversal(root.right));
        list.add(root.val);
        return list;
    }
}
