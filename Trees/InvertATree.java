package Trees;

public class InvertATree {
    public TreeNode invertTree(TreeNode root) {
        // base condition
        if(root == null){
            return null;
        }

        // function body
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        // swapping nodes
        root.left = right;
        root.right = left;

        return root;
    }
}
