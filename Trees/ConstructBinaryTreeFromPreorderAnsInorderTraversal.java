package Trees;

public class ConstructBinaryTreeFromPreorderAnsInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, inorder, new int[]{0}, 0, inorder.length-1);
    }

    public TreeNode helper(int[] preorder, int[] inorder, int[] preorderIdx, int inorderStart, int inorderEnd){
        // base condition
        if(preorderIdx[0] >= preorder.length || inorderStart > inorderEnd){
            return null;
        }

        // function body
        int currElement = preorder[preorderIdx[0]];
        TreeNode root = new TreeNode(currElement);
        int positionOfElement = find(inorder, currElement);

        preorderIdx[0] ++;
        root.left = helper(preorder, inorder, preorderIdx, inorderStart, positionOfElement-1);
        root.right = helper(preorder, inorder, preorderIdx, positionOfElement+1, inorderEnd);
        return root;
    }

    public int find(int[] order, int target){
        for(int i = 0 ; i < order.length; i ++){
            if(order[i] == target){
                return i;
            }
        }
        return -1;
    }
}
