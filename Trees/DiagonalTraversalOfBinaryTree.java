package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class DiagonalTraversalOfBinaryTree {
    private class Node {
        int data;
        Node left, right;
    }

    // * Good use of level order traversal
    public ArrayList<Integer> diagonal(Node root){
        ArrayList<Integer> list = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()){
            Node front = q.peek();
            
            while(front != null){
                if(front.left != null){
                    q.add(front.left);
                }
                list.add(front.data);
                front = front.right;
            }
            
            q.remove();
        }
        return list;
    }

    // * recursive way (kind of bruteforce)
    public ArrayList<Integer> diagonal2(Node root) {
        // add your code here.
        Map<Integer, ArrayList<Integer>> map = new TreeMap<>();
        helper(root, 0, map);
        ArrayList<Integer> ans = new ArrayList<>();
        for (ArrayList<Integer> list : map.values()) {
            ans.addAll(list);
        }
        return ans;
    }

    public void helper(Node root, int diagonal, Map<Integer, ArrayList<Integer>> map) {
        // base condition
        if (root == null) {
            return;
        }

        // function body
        if (!map.containsKey(diagonal)) {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(root.data);
            map.put(diagonal, list);
        } else {
            map.get(diagonal).add(root.data);
        }

        helper(root.left, diagonal + 1, map);
        helper(root.right, diagonal, map);
    }
}
