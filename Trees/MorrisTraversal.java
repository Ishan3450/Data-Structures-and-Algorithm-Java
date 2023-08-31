/*
 * Algorithm:
 * 
 ! NOTE: This algo is set algo, doing dry run will get your hand and head clear on and in it.
 * 
 * 1. start curr = root;
 * 2. if curr.left != null then place pred to curr.left and loop pred=pred.right until pred.right not becomes null
 * 3. when pred.right == null then link pred.right = curr; and move curr to left.
 * (ELSE of 2.) 4. When curr.left == null then add curr.val to list and move curr = curr.right.
 * (ELSE of 3.) 5. if pred.right == curr and pred.left == null means pred is already visited node, so remove link of pred and add curr.val to list and move curr to right.
 * 
 */
package Trees;

import java.util.ArrayList;
import java.util.List;

public class MorrisTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        TreeNode curr = root;

        while(curr != null){
            // check if curr.left is null or not
            if(curr.left == null){
                list.add(curr.val);
                curr = curr.right;
            } else { 
                // curr.left is not null, in that case first get the inorder predecessor of curr
                TreeNode pred = curr.left;
                while(pred.right != curr && pred.right != null){
                    pred = pred.right;
                }

                // establishment of link based on pred
                if(pred.right == null){
                    // establish a link to the curr from pred
                    pred.right = curr;
                    curr = curr.left;
                } else{
                    // pred is already visited, so remove the established link
                    pred.right = null;
                    list.add(curr.val);
                    curr = curr.right;
                }
            }
        }
        return list;
    }
}
