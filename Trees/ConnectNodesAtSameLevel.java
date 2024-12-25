// gfg https://practice.geeksforgeeks.org/problems/connect-nodes-at-same-level/1
package Trees;

import java.util.LinkedList;
import java.util.Queue;

public class ConnectNodesAtSameLevel {
    private class Node {
        int data;
        Node left, right, nextRight;
    }

    // Function to connect nodes at same level.
    public void connect(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while (!q.isEmpty()) {
            Node front = q.remove();

            if (front == null) {
                if (q.size() == 0) {
                    break;
                }
                q.add(null);
            } else {
                if (front.left != null) {
                    q.add(front.left);
                }
                if (front.right != null) {
                    q.add(front.right);
                }

                front.nextRight = q.peek();
            }
        }
    }
}
