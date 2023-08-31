package Trees;

public class SumOfLongestBloodlineOfATree {
    private class Node{
        int data;
        Node left, right;
    }
    private class Pair {
        int height, sum;

        Pair(int height, int sum) {
            this.height = height;
            this.sum = sum;
        }
    }

    public int sumOfLongRootToLeafPath(Node root) {
        // code here
        Pair ans = helper(root);
        return ans.sum;
    }

    public Pair helper(Node root) {
        // base condition
        if (root == null) {
            return new Pair(0, 0);
        }

        // recursive calls
        Pair left = helper(root.left);
        Pair right = helper(root.right);

        // function body
        if (left.height == right.height) {
            if (left.sum == right.sum || left.sum > right.sum) {
                return new Pair(left.height + 1, left.sum + root.data);
            }
            return new Pair(right.height + 1, right.sum + root.data);
        }

        if (left.height > right.height) {
            return new Pair(left.height + 1, left.sum + root.data);
        }

        return new Pair(right.height + 1, right.sum + root.data);
    }

    /*
     * 
     * Another way same logic just adding all the stuff of curr node before calculating
     * 
     * NOTE: Above logic makes more sense than the below one. But below one is easy to understand.
     * 
     */
    public int sumOfLongRootToLeafPath2(Node root){
        // code here
        return helper2(root).sum;
        
    }
    
    public Pair helper2(Node root){
        // base condition
        if(root == null){
            return new Pair(0,0);
        }
        
        // function body
        Pair left = helper(root.left);
        Pair right = helper(root.right);
        
        left.height += 1;
        left.sum += root.data;
        right.height += 1;
        right.sum += root.data;
        
        if(left.height > right.height){
            return left;
        }
        if(right.height > left.height){
            return right;
        }
        

        if(left.sum > right.sum){
            return left;
        }
        if(left.sum < right.sum){
            return right;
        }
        
        // else both have equal sum
        return left; // or right; does not matters
        
    }
}
