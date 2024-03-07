package Graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/*
 * Topological Sort can only be applied on a Directed Acyclic Graph
 */

public class TopologicalSort {
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        // add your code here
        Stack<Integer> st = new Stack<>();
        Set<Integer> isVisited = new HashSet<>();

        for (int i = 0; i < V; i++) {
            if (!isVisited.contains(i)) {
                dfs(i, adj, st, isVisited);
            }
        }

        int[] ans = new int[st.size()];
        int idx = 0;
        while (!st.isEmpty()) {
            ans[idx++] = st.pop();
        }
        return ans;
    }

    private static void dfs(int source, ArrayList<ArrayList<Integer>> adj, Stack<Integer> st, Set<Integer> isVisited) {
        isVisited.add(source);

        for (int val : adj.get(source)) {
            if (!isVisited.contains(val)) {
                dfs(val, adj, st, isVisited);
            }
        }
        st.push(source);
    }
}
