package BinarySearchTrees;

// Replace every element with the least greater element on its right | Practice | GeeksforGeeks

import java.util.ArrayList;
import java.util.Collections;

public class ReplaceEveryElementWithItsLeastGreaterElementToItsRight {
     private static class Node{
        int data;
        Node left, right;
        
        Node(int data){
            this.data = data;
        }
    }
    
    public static ArrayList<Integer> findLeastGreater(int n, int[] arr) {
        ArrayList<Integer> list = new ArrayList<>();
        Node root = null;
        for(int i = n-1; i>=0; i--){
            int[] successor = new int[1];
            successor[0] = -1;
            root = insert(root, arr[i], successor);
            list.add(successor[0]);
        }
        Collections.reverse(list);
        return list;
    }
    
    private static Node insert(Node root, int val, int[] succ){
        // base condition
        if(root == null){
            return new Node(val);
        }
        
        // function body
        if(root.data <= val){
            root.right = insert(root.right, val, succ);
        } else{
            succ[0] = root.data;
            root.left = insert(root.left, val, succ);
        }
        
        return root;
    }
}
