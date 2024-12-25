package Trees;

public class MaximumSumOfNonAdjacentNodes {
    private static class Node{
        int data;
        Node left, right;
    }
    private static class Pair{
        int first, second;
        Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }
    
    //Function to return the maximum sum of non-adjacent nodes.
    static int getMaxSum(Node root){
        // add your code here
        Pair ans = helper(root);
        return Math.max(ans.first, ans.second);
    }
    
    static Pair helper(Node root){
        // base condition
        if(root == null){
            return new Pair(0,0);
        }
        
        // recursive calls
        Pair left = helper(root.left);
        Pair right = helper(root.right);
        
        // function body after exiting the calls
        int sumIncludingRoot = root.data + left.second + right.second;
        int sumExcludingRoot = Math.max(left.first, left.second) + Math.max(right.first, right.second);
        
        return new Pair(sumIncludingRoot, sumExcludingRoot);
    }
}
