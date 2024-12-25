// https://practice.geeksforgeeks.org/problems/largest-bst/1

package BinarySearchTrees;

public class LargestBSTInBinaryTree {
    private static class NodeInfo{
        int size, minVal, maxVal;
        boolean isBst;
        
        NodeInfo() {
            size = 0;
            minVal = Integer.MAX_VALUE;
            maxVal = Integer.MIN_VALUE;
            isBst = true;
        }
        
    }
    
    // Return the size of the largest sub-tree which is also a BST
    static int largestBst(Node root)
    {
        int[] ans = new int[1];
        helper(root, ans);
        return ans[0];
    }
    
    private static NodeInfo helper(Node root, int[] ans){
        // base condition
        if(root == null){
            return new NodeInfo();
        }
        
        // function body
        NodeInfo leftSubtree = helper(root.left, ans);
        NodeInfo rightSubtree = helper(root.right, ans);
        
        NodeInfo includingRootInfo = new NodeInfo();
        
        if(leftSubtree.isBst && rightSubtree.isBst && root.data > leftSubtree.maxVal && root.data < rightSubtree.minVal){
            int newSize = leftSubtree.size + rightSubtree.size + 1;
            includingRootInfo.size = newSize;
            includingRootInfo.minVal = Math.min(root.data, Math.min(leftSubtree.minVal, rightSubtree.minVal));
            includingRootInfo.maxVal = Math.max(root.data, Math.max(leftSubtree.maxVal, rightSubtree.maxVal));
            ans[0] = Math.max(ans[0], newSize);
        } else{
            includingRootInfo.isBst = false;
        }
        
        return includingRootInfo;
    }
}
