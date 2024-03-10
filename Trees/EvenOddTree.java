package Trees;

import java.util.LinkedList;
import java.util.Queue;

public class EvenOddTree {
      public boolean isEvenOddTree(TreeNode root) {
        int level = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            if((level & 1) == 1){ // odd level
                if(!oddLevel(q, q.size())){
                    return false;
                }
            } else { // even level
                if(!evenLevel(q, q.size())){
                    return false;
                }
            }
            
            level ++;
        }

        return true;
    }

    private boolean oddLevel(Queue<TreeNode> q, int size){
        boolean isFirstFound = false;
        int prevVal = Integer.MAX_VALUE;

        for(int i = 0 ; i < size ; i ++){
            TreeNode peek = q.remove();

            if((peek.val & 1) == 1) return false; // no odd val must be there

            if(!isFirstFound){
                prevVal = peek.val;
                isFirstFound = true;
            } else {
                if(peek.val >= prevVal) return false;
                prevVal = peek.val;
            }

            if(peek.left != null){
                q.add(peek.left);
            }

            if(peek.right != null){
                q.add(peek.right);
            }
        }

        return true;
    }

    private boolean evenLevel(Queue<TreeNode> q, int size){
        boolean isFirstFound = false;
        int prevVal = Integer.MIN_VALUE;

        for(int i = 0 ; i < size ; i ++){
            TreeNode peek = q.remove();

            if((peek.val & 1) != 1) return false; // no even val must be there

            if(!isFirstFound){
                isFirstFound = true;
                prevVal = peek.val;
            } else {
                if(peek.val <= prevVal) return false;
                prevVal = peek.val;
            }

            if(peek.left != null){
                q.add(peek.left);
            }

            if(peek.right != null){
                q.add(peek.right);
            }
        }

        return true;
    }
}
