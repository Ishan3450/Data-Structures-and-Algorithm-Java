package Heaps;

import java.util.*;

class BSTtoMaxHeap {
    class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    public static void convertToMaxHeapUtil(Node root) {
        // code here
        ArrayList<Integer> inOrder = getInOrder(root);
        placeInPostOrder(root, inOrder, new int[] { 0 });
    }

    private static void placeInPostOrder(Node root, ArrayList<Integer> inOrder, int[] idx) {
        // base condition
        if (root == null) {
            return;
        }

        // function body
        placeInPostOrder(root.left, inOrder, idx);
        placeInPostOrder(root.right, inOrder, idx);

        root.data = inOrder.get(idx[0]);
        idx[0]++;
    }

    private static ArrayList<Integer> getInOrder(Node root) {
        ArrayList<Integer> list = new ArrayList<>();
        Node curr = root;

        while (curr != null) {
            if (curr.left == null) {
                list.add(curr.data);
                curr = curr.right;
            } else {
                Node pred = curr.left;

                while (pred.right != null && pred.right != curr) {
                    pred = pred.right;
                }

                if (pred.right != null) {
                    pred.right = null;
                    list.add(curr.data);
                    curr = curr.right;
                } else {
                    pred.right = curr;
                    curr = curr.left;
                }
            }
        }
        return list;
    }
}