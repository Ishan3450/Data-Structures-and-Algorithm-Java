/*
 * Algorithm:
 * 
 * NOTE: Solved using the logic of Morris Traversal.
 * 
 * 1. start with the curr = root;
 * 2. check if curr.left is null or not.
 * 3. if null then move the curr = curr.right;
 * 4. if not null then place the predecessor node to the curr.left
 * 5. then loop predc = predc.right until predc.right not becomes null
 * 6. establish a link from predc.right to curr.right; so the right of curr is not lost while establishing a link to left of curr
 * 7. now establish a link from curr.right to curr.left and make curr.left = null
 * 8. and move curr = curr.right;
 */
package Trees;

public class FlattenBinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
        TreeNode curr = root;

        while (curr != null) {
            // checking if curr.left is null or not
            if (curr.left != null) {
                // .left is not null
            
                // if not null then find the inorder successor and link it the the right of curr to preserve the right of curr
                TreeNode predc = curr.left;
                while (predc.right != null) {
                    predc = predc.right;
                }
                
                // after finding the inorder successor link it
                predc.right = curr.right;
                
                // now we have preserved the right subtree of curr, so link the right of curr to left of curr and make left of curr null
                curr.right = curr.left;
                curr.left = null;
            }
            curr = curr.right;
        }
    }
}
