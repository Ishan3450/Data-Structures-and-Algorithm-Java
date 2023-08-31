package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class TopViewOfBinaryTree {
    private class Node {
        int data;
        Node left, right;
    }

    private static class Pair {
        Node node;
        int distance;

        Pair(Node node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }

    // Function to return a list of nodes visible from the top view
    // from left to right in Binary Tree.
    static ArrayList<Integer> topView(Node root) {
        // add your code
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));

        while (!q.isEmpty()) {
            Node front = q.peek().node;
            int distance = q.peek().distance;

            if (!map.containsKey(distance)) {
                map.put(distance, front.data);
            }

            if (front.left != null) {
                q.add(new Pair(front.left, distance - 1));
            }

            if (front.right != null) {
                q.add(new Pair(front.right, distance + 1));
            }

            q.remove();
        }

        return new ArrayList<>(map.values());
    }
}
