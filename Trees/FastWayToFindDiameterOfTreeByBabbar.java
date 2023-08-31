package Trees;

public class FastWayToFindDiameterOfTreeByBabbar {
    int diameter = 0;
    public int height(TreeNode root){
        // base condition
        if(root == null){
            return 0;
        }

        // function body
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        diameter = Math.max(leftHeight+rightHeight, diameter);

        return Math.max(leftHeight, rightHeight) + 1;
    }
    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return diameter;
    }
}
