package BinarySearchTrees;

import java.util.ArrayList;

public class FindAPairForGivenSumInBST {
      public boolean findTarget(TreeNode root, int k) {
        ArrayList<Integer> nodes = new ArrayList<>();
        helper(root, nodes);

        int i = 0, j = nodes.size()-1;
        while(i < j){
            int sum = nodes.get(i) + nodes.get(j);

            if(sum == k){
                return true;
            } else if(sum < k){
                i ++;
            } else {
                j --;
            }
        }

        return false;
    }
    private void helper(TreeNode root, ArrayList<Integer> nodes){
        // base condition
        if(root == null) return;

        // function body
        helper(root.left, nodes);
        nodes.add(root.val);
        helper(root.right, nodes);
    }
}
