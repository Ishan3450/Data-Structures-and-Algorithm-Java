package Trees;

import java.util.*;

public class BurningTree {

    private class Node {
        int data;
        Node left, right;
    }

    public static Node createMapAndGetTarget(Node root, HashMap<Node, Node> map, int target) {
        Node targetNode = null;
        Queue<Node> q = new LinkedList<>();

        q.add(root);

        while (!q.isEmpty()) {
            Node front = q.remove();

            if (front.data == target) {
                targetNode = front;
            }

            if (front.left != null) {
                q.add(front.left);
                map.put(front.left, front);
            }

            if (front.right != null) {
                q.add(front.right);
                map.put(front.right, front);
            }
        }
        return targetNode;
    }

    public static int burnTree(Node target, HashMap<Node, Node> nodeToParent) {
        HashMap<Node, Boolean> visited = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        int time = 0;

        q.add(target);
        visited.put(target, true);

        while (!q.isEmpty()) {
            boolean isQueueChanged = false;
            int size = q.size();

            for (int i = 0; i < size; i++) {
                Node front = q.remove();

                /*
                 * NOTE: in below cases .getOrDefault() method is used, because in some cases
                 * when front.left key don't exists in that null is returned and by applying !
                 * operation it was giving null pointer exception.
                 */

                // left of front
                if (front.left != null && !visited.getOrDefault(front.left, false)) {
                    q.add(front.left);
                    isQueueChanged = true;
                    visited.put(front.left, true);
                }

                // right of front
                if (front.right != null && !visited.getOrDefault(front.right, false)) {
                    q.add(front.right);
                    isQueueChanged = true;
                    visited.put(front.right, true);
                }

                // parent node
                if (nodeToParent.get(front) != null && !visited.getOrDefault(nodeToParent.get(front), false)) {
                    q.add(nodeToParent.get(front));
                    isQueueChanged = true;
                    visited.put(nodeToParent.get(front), true);
                }
            }

            if (isQueueChanged) {
                time++;
            }
        }
        return time;
    }

    public static int minTime(Node root, int target) {
        // Step1 Create a node to parent mapping
        HashMap<Node, Node> nodeToParent = new HashMap<>();

        // Step2 Get the node with value target
        Node targetNode = createMapAndGetTarget(root, nodeToParent, target);

        // Step3 Start burning the tree using level order traversal
        return burnTree(targetNode, nodeToParent);
    }

}
