package OOPs.Trees;

import javafx.util.Pair;

public class DiameterOfTree {
    static class Node{
        Node left;
        Node right;
        int data;
    }

      /*
      ! The pair class in java is not that much good as per our need,so we are re-creating 
        our new pair class
     */
    static class pair{
        int first;
        int second;

        pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }
    
    /*
     * The first Integer in the pair is the diameter
     * Second Integer in the pair is the height
     */
    pair helper(Node root){
        // base condition
        if(root == null){
            pair p = new pair(0,0);
            return p;
        }
        
        // function body
        pair left = helper(root.left);
        pair right = helper(root.right);
        
        // now we have 3 options 
        // 1st is the left height 
        int lh = left.first;
        
        // 2nd is the right height
        int rh = right.first;
        
        // 3rd is the left height + root + the right height
        int lrh = left.second + 1 + right.second;
        
        int ansDiameter = Math.max(lh, Math.max(rh, lrh));
        int ansHeight = Math.max(left.second, right.second) + 1; // + 1 for root
        
        return new pair(ansDiameter, ansHeight);
    }
    
    // Function to return the diameter of a Binary Tree.
    int diameter(Node root) {
        // as we want diameter we are returning first as first stands for diameter ans second for height
        return helper(root).first;
    }

    public static void main(String[] args){

    }
}
