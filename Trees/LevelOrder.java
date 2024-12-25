package Trees;

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
                
    // Way 1
    public List<List<Integer>> levelOrder1(Node root) {
        List<List<Integer>> list = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();

        if(root == null){
            return list;
        }

        q.add(root);
        while(!q.isEmpty()){
            List<Integer> subList = new ArrayList<>();
            int levelSize = q.size();

            for(int i=0; i<levelSize; i++){
                Node curr = q.poll();

                subList.add(curr.data);

                if(curr.left != null){
                    q.add(curr.left);
                }

                if(curr.right != null){
                    q.add(curr.right);
                }
            }

            list.add(subList);
        }

        return list;
    }
    
    // Way 2
    static ArrayList <Integer> levelOrder2(Node node){
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
