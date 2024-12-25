package Trees;

public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        if(height(root) == -1){
            return false;
        }
        return true;
    }

    public int height(TreeNode root) {
        // base condition
        if(root == null){
            return 0;
        }

        // function body
        int leftPart = height(root.left);
        int rightPart = height(root.right);

        if(leftPart == -1 || rightPart == -1){
            return -1;
        }
        if(Math.abs(leftPart-rightPart) > 1){
            return -1;
        }
        return 1 + Math.max(leftPart, rightPart);
    }
}
