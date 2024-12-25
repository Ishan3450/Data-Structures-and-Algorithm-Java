package LeetCodeQuestions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Q2358 {
    public int amountOfTime(TreeNode root, int start) {
        HashMap<TreeNode, TreeNode> nodeToParent = new HashMap<>();
        TreeNode startNode = createMappingAndReturnStartNode(root, nodeToParent, start);

        Queue<TreeNode> forest = new LinkedList<>();
        forest.add(startNode);
        HashSet<TreeNode> visited = new HashSet<>();
        visited.add(startNode);

        int timeToBurn = 0;

        while (!forest.isEmpty()) {
            int size = forest.size();
            boolean isForestChanged = false;

            for (int i = 1; i <= size; i++) {
                TreeNode front = forest.remove();

                if (front.left != null && !visited.contains(front.left)) {
                    forest.add(front.left);
                    visited.add(front.left);
                    isForestChanged = true;
                }

                if (front.right != null && !visited.contains(front.right)) {
                    forest.add(front.right);
                    visited.add(front.right);
                    isForestChanged = true;
                }

                if (nodeToParent.get(front) != null && !visited.contains(nodeToParent.get(front))) {
                    forest.add(nodeToParent.get(front));
                    visited.add(nodeToParent.get(front));
                    isForestChanged = true;
                }
            }

            if (isForestChanged) {
                timeToBurn++;
            }
        }
        return timeToBurn;
    }

    private TreeNode createMappingAndReturnStartNode(TreeNode root, HashMap<TreeNode, TreeNode> nodeToParent,
            int start) {

        TreeNode startNode = null;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        nodeToParent.put(root, null);

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 1; i <= size; i++) {
                TreeNode front = q.remove();

                if (front.val == start) {
                    startNode = front;
                }

                if (front.left != null) {
                    nodeToParent.put(front.left, front);
                    q.add(front.left);
                }

                if (front.right != null) {
                    nodeToParent.put(front.right, front);
                    q.add(front.right);
                }
            }
        }
        return startNode;
    }
}
