package Trees;

import java.util.ArrayList;

public class LeftViewOfBinaryTree {
    private class Node{
        int data;
        Node left, right;
    }
    ArrayList<Integer> leftView(Node root){
      // Your code here
      ArrayList<Integer> list = new ArrayList<>();
      helper(root, 0, list);
      return list;
    }
    
    void helper(Node root, int level, ArrayList<Integer> nodes){
        // base condition
        if(root == null){
            return;
        }
        
        // function body
        if(level == nodes.size()){
            nodes.add(root.data);
        }
        helper(root.left, level+1, nodes);
        helper(root.right, level+1, nodes);
    }
}
