package Trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class HeightOfTree {
    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static TreeNode createTree(){
        Scanner sc = new Scanner(System.in);
        Queue<TreeNode> q = new LinkedList<>();

        System.out.println("Enter data for root: ");
        int data = sc.nextInt();
        TreeNode root = new TreeNode(data);
        q.add(root);

        while(!q.isEmpty()){
            TreeNode temp = q.peek();
            q.poll();

            System.out.println("Enter left node for " + temp.data);
            int leftData = sc.nextInt();

            if(leftData != -1){
                temp.left = new TreeNode(leftData);
                q.add(temp.left);
            }

            System.out.println("Enter right node for " + temp.data);
            int rightData = sc.nextInt();

            if(rightData != -1){
                temp.right = new TreeNode(rightData);
                q.add(temp.right);
            }
        }

        return root;
    }

    static int height(TreeNode node){
        // base condition
        if(node == null){
            return 0;
        }
        
        int left = height(node.left);
        int right = height(node.right);
        
        return Math.max(left, right) + 1; // + 1 for the root node
    }

    public static void main(String[] args){
        TreeNode root = createTree();
        System.out.println(height(root));
    }
}
