package Trees;

public class KthAncestorInATree {
    private class Node{
        int data;
        Node left, right;
    }
    // recursive way
    public int kthAncestor(Node root, int k, int node)
    {
        // base condition
        int[] ans = new int[1];
        ans[0] = -1;
        int[] nk = {k};
        helper(root, nk, node, ans);
        return ans[0];
    }
    
    public boolean helper(Node root, int[] k, int node, int[] ans){
        // base condition
        if(root == null){
            return false;
        }
        
        // function body
        
        // finding node
        if(root.data == node){
            return true;
        }
        
        boolean leftPart = helper(root.left, k, node, ans);
        boolean rightPart = helper(root.right, k, node, ans);
        
        if(leftPart || rightPart){
            k[0]--;
        }
        
        if(k[0] == 0){
            ans[0] = root.data;
            k[0] = -1;
        }
        
        return leftPart || rightPart;
    }
}
