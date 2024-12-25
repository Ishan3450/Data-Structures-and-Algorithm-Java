package BinarySearchTrees;

import java.util.ArrayList;

public class NormalBSTToBalancedBST {
    public TreeNode balanceBST(TreeNode root) {
        ArrayList<Integer> nodes = new ArrayList<>();
        createInorderTraversalList(nodes, root);
        return helper(nodes, 0, nodes.size()-1);
    }

    private TreeNode helper(ArrayList<Integer> nodes, int start, int end){
        // base condition
        if(start > end) return null;

        // function body
        int mid = (start + end) / 2;

        TreeNode root = new TreeNode(nodes.get(mid));
        root.left = helper(nodes, start, mid-1);
        root.right = helper(nodes, mid+1, end);
        return root;
    }

    private void createInorderTraversalList(ArrayList<Integer> nodes, TreeNode root){
        // base condition
        if(root == null){
            return;
        }

        // function body
        createInorderTraversalList(nodes, root.left);
        nodes.add(root.val);
        createInorderTraversalList(nodes, root.right);
    }
}
