package Trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BuildBinaryTreeFromLevelOrderTraversal {
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

    public static void levelTraversal(TreeNode root){
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while(!q.isEmpty()){
            TreeNode curr = q.poll();

            if(curr == null){
                System.out.println();
                if(q.isEmpty()){
                    break;
                } else{
                    q.add(null);
                }
            } else{
                System.out.print(curr.data + " ");
                if(curr.left != null){
                    q.add(curr.left);
                }

                if(curr.right != null){
                    q.add(curr.right);
                }
            }
        }
    }

    public static void main(String[] args){
        /*
         * Paste this data in the terminal directly to get the answer
         * 1 3 5 7 11 17 -1 -1 -1 -1 -1 -1 -1
         */
        TreeNode root = createTree();
        levelTraversal(root);
    }
}
