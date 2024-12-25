package Trees;

import java.util.ArrayList;

public class BoundaryTraversalOfTree {
    private class Node {
        int data;
        Node left, right;
    }

    ArrayList<Integer> boundary(Node node) {
        ArrayList<Integer> list = new ArrayList<>();
        if (node == null) {
            return list;
        }
        list.add(node.data);

        if (node.left == null && node.right == null) {
            return list;
        }

        getLeftBoundary(node.left, list);
        getLeafBoundary(node, list);
        getRightBoundary(node.right, list);

        return list;
    }

    void getLeftBoundary(Node node, ArrayList<Integer> list) {
        // base condition
        if (node == null || (node.left == null && node.right == null)) {
            return;
        }

        // function body
        list.add(node.data);

        if (node.left != null) {
            getLeftBoundary(node.left, list);
        } else {
            getLeftBoundary(node.right, list);
        }
    }

    void getLeafBoundary(Node node, ArrayList<Integer> list) {
        // base condition
        if (node == null) {
            return;
        }

        if (node.left == null && node.right == null) {
            list.add(node.data);
            return;
        }

        // function body
        getLeafBoundary(node.left, list);
        getLeafBoundary(node.right, list);
    }

    void getRightBoundary(Node node, ArrayList<Integer> list) {
        // base condition
        if (node == null || (node.left == null && node.right == null)) {
            return;
        }

        // function body
        if (node.right != null) {
            getRightBoundary(node.right, list);
        } else {
            getRightBoundary(node.left, list);
        }

        list.add(node.data);
    }
}
