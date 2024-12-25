package Greedy;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class HuffmanEncoding {
    private class TreeNode implements Comparable<TreeNode> {
        int weight;
        TreeNode left, right;

        TreeNode(int weight) {
            this.weight = weight;
            left = right = null;
        }

        @Override
        public int compareTo(TreeNode o) {
            if (this.weight == o.weight)
                return 1; // We are returning 1 when a.data==b.data to maintain the insertion order.
            return this.weight - o.weight;
        }
    }

    public ArrayList<String> huffmanCodes(String S, int f[], int N) {
        PriorityQueue<TreeNode> pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            pq.add(new TreeNode(f[i]));
        }

        while (pq.size() > 1) { // there must be more than 2 nodes in pq to proceed further
            TreeNode first = pq.remove();
            TreeNode second = pq.remove();

            TreeNode newNode = new TreeNode(first.weight + second.weight);
            newNode.left = first;
            newNode.right = second;

            pq.add(newNode);
        }

        ArrayList<String> preorderTraversal = new ArrayList<>();
        preorder(pq.remove(), preorderTraversal, "");
        return preorderTraversal;
    }

    private void preorder(TreeNode root, ArrayList<String> preorderTraversal, String curr) {
        // base condition
        if (root.left == null && root.right == null) {
            preorderTraversal.add(curr);
            return;
        }

        // function body
        preorder(root.left, preorderTraversal, curr + "0");
        preorder(root.right, preorderTraversal, curr + "1");
    }
}
