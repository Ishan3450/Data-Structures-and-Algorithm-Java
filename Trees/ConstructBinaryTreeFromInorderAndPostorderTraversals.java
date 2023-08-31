package Trees;

public class ConstructBinaryTreeFromInorderAndPostorderTraversals {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(inorder, postorder, new int[] { postorder.length - 1 }, 0, inorder.length - 1);
    }

    public TreeNode helper(int[] inorder, int[] postorder, int[] postorderIdx, int inorderStart, int inorderEnd) {
        // base condition
        if (postorderIdx[0] <= -1 || inorderStart > inorderEnd) {
            return null;
        }

        // function body
        int currElement = postorder[postorderIdx[0]];
        TreeNode root = new TreeNode(currElement);
        int positionOfElem = find(inorder, currElement);

        postorderIdx[0]--;

        root.right = helper(inorder, postorder, postorderIdx, positionOfElem + 1, inorderEnd);
        root.left = helper(inorder, postorder, postorderIdx, inorderStart, positionOfElem - 1);

        return root;
    }

    public int find(int[] order, int target) {
        for (int i = 0; i < order.length; i++) {
            if (order[i] == target) {
                return i;
            }
        }
        return -1;
    }
}
