package OOPs.Trees;

import java.util.*;

public class LevelOrder {
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    
    static ArrayList <Integer> levelOrder(Node node){
        // Your code here
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        
        q.add(node);
        q.add(null);
        
        while(!q.isEmpty()){
            Node curr = q.poll();
            
            if(curr == null){
                if(q.isEmpty()){
                    break;
                } else{
                    q.add(null);
                }
                
            } else{
                ans.add(curr.data);
                
                if(curr.left != null){
                    q.add(curr.left);
                } 
                
                if(curr.right != null){
                    q.add(curr.right);
                }

            }
            
        }
        
        return ans;
    }
}
