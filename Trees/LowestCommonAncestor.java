/*
 * Approach:
 * 
 * If either p or q is found then we will return that node
 * else will return null as the base case condition
 * 
 * then we will recursively call left and right part
 * 
 * to check ancestor found or not there are 4 cases:
 * 1. both left and right part are null -> no ancestor found
 * 2. if left is not null and right is null -> return left part
 * 3. if right is not null and left is null -> return right part
 * 4. if both are not null -> return curr standing node
 */

package Trees;

public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // base condition
        if(root == null){
            return null;
        }

        // function body

        // check if p or q found
        if(root == q || root == p){
            return root;
        }

        TreeNode leftPart = lowestCommonAncestor(root.left, p, q);
        TreeNode rightPart = lowestCommonAncestor(root.right, p, q);

        // case 1
        if(leftPart == null && rightPart == null){
            return null;
        }

        // case 2
        if(leftPart != null && rightPart == null){
            return leftPart;
        }

        // case 3
        if(leftPart == null && rightPart != null){
            return rightPart;
        }

        // case 4
        return root;
    }
}
