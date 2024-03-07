package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/* 
 * Kahn's algorithm is a BFS algorithm used to find topological sort of a DAG
 * 
 * Logic:
 * 
 * - Ans will be stored in queue and we will add a node in queue if its indegree is 0 meaning that node is independent
 * - For that we have to get indegrees of nodes first before applying algorithm
 */
public class KahnAlgorithmForTopologicalSort {
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        // add your code here
        int[] inDegrees = new int[V];

        for (int i = 0; i < V; i++) {
            for (int neighbour : adj.get(i)) {
                inDegrees[neighbour]++;
            }
        }

        Queue<Integer> ans = new LinkedList<>();
        bfsKahnAlgo(adj, ans, inDegrees, V);

        int[] a = new int[ans.size()];
        int idx = 0;

        while (!ans.isEmpty()) {
            a[idx++] = ans.remove();
        }
        return a;
    }

    private static void bfsKahnAlgo(ArrayList<ArrayList<Integer>> adj, Queue<Integer> ans, int[] inDegrees, int V) {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (inDegrees[i] == 0) { // we found an independent node
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int peek = q.remove();

            ans.add(peek);

            for (int neighbour : adj.get(peek)) {
                if (--inDegrees[neighbour] == 0) {
                    q.add(neighbour);
                }
            }
        }
    }
}
