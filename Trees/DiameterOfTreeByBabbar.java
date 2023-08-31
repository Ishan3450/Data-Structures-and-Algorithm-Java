package Trees;

public class DiameterOfTreeByBabbar {
    // * as of now solved with the bruteforce way, in future will solve it with the more optimized way or simply the fast way to find diameter
    public int maxHeight(TreeNode root){
        // base condition
        if(root == null) {
            return 0;
        }

        // function body
        int leftHeight = maxHeight(root.left);
        int rightHeight = maxHeight(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public int diameterOfBinaryTree(TreeNode root) {
        // base condition
        if(root == null){
            return 0;
        }

        // function body
        int leftPart = diameterOfBinaryTree(root.left);
        int rightPart = diameterOfBinaryTree(root.right);
        int combined = maxHeight(root.left) + maxHeight(root.right);
        return Math.max(combined, Math.max(leftPart, rightPart));
    }
}
