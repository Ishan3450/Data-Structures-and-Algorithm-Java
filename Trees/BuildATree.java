package Trees;

import java.util.Scanner;

public class BuildATree {
    public static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static Node buildATree() {
        Scanner sc = new Scanner(System.in);
        int userVal = sc.nextInt();

        // base condition
        if (userVal == -1) {
            return null;
        }

        // function body
        Node root = new Node(userVal);

        System.out.print("Enter left of " + userVal + ": ");
        root.left = buildATree();
        System.out.print("Enter right of " + userVal + ": ");
        root.right = buildATree();

        return root;
    }

    public static void printTree(Node root) {
        // base condition
        if (root == null) {
            return;
        }

        // function body
        System.out.println(root.data);
        printTree(root.left);
        printTree(root.right);
    }

    public static void main(String[] args) {
        int[] arr = { 20, 11, -1, -1, 13, -1, 50, -1, -1 };
        System.out.print("Enter root data: ");
        printTree(buildATree());
    }
}
