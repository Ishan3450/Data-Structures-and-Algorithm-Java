package Trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigzagTraversalInBinaryTree {
     public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean direction = true; // true = l->r and false = r->l

        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> currList = new ArrayList<>(size);

            while(size > 0){
                TreeNode front = q.peek();
                if(front.left != null){
                    q.add(front.left);
                }
                if(front.right != null){
                    q.add(front.right);
                }
                currList.add(front.val);
                size--;
                q.remove();
            }
            if(!direction){
                Collections.reverse(currList);
            }
            ans.add(currList);
            direction = !direction;
        }
        return ans;
    }
}
