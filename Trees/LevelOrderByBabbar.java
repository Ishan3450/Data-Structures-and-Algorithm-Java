package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderByBabbar {
    // temp class, to use it create constructor
    private class Node{
        int data;
        Node left;
        Node right;
    }

    // iterative way
    static ArrayList <Integer> levelOrder(Node node) 
    {
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        
        q.add(node);
        
        while(!q.isEmpty()){
            Node front = q.peek();
            ans.add(front.data);
            
            if(front.left != null){
                q.add(front.left);
            }
            if(front.right != null){
                q.add(front.right);
            }
            
            q.remove(); // removes the front
        }
        
        return ans;
    }   

}
