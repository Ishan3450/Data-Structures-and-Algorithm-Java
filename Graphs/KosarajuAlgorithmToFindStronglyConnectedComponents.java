package Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class KosarajuAlgorithmToFindStronglyConnectedComponents {
    /*
     * Only 3 major steps:
     * 
     * 1. Find safe order using Topological Sort
     * 2. Reversing the edges
     * 3. Apply DFS
     */

    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj) {
        Stack<Integer> safeOrder = new Stack<>();
        Set<Integer> isVisited = new HashSet<>();

        // Step 1
        for (int i = 0; i < V; i++) {
            if (!isVisited.contains(i))
                getTopologicalSortUsingDfs(adj, isVisited, safeOrder, i);
        }

        // Step 2
        Map<Integer, ArrayList<Integer>> adjList = new HashMap<>(); // adjacency list with reversed list
        for (int i = 0; i < V; i++) {
            for (int val : adj.get(i)) {
                if (!adjList.containsKey(val)) {
                    adjList.put(val, new ArrayList<>());
                }
                adjList.get(val).add(i);
            }
        }

        // Step 3
        int sccCount = 0;
        isVisited.clear();

        // * we ahveto utilized safeOrder stack, I did mistake frist time solving this questions just used a loop for o -> V
        while (!safeOrder.isEmpty()) {
            int peek = safeOrder.pop();

            if (!isVisited.contains(peek)) {
                dfs(adjList, peek, isVisited);
                sccCount++;
            }
        }

        return sccCount;
    }

    public void dfs(Map<Integer, ArrayList<Integer>> adjList, int source, Set<Integer> isVisited) {
        isVisited.add(source);

        for (int val : adjList.getOrDefault(source, new ArrayList<>())) {
            if (!isVisited.contains(val)) {
                dfs(adjList, val, isVisited);
            }
        }
    }

    public void getTopologicalSortUsingDfs(ArrayList<ArrayList<Integer>> adj, Set<Integer> isVisited, Stack<Integer> st,
            int source) {
        isVisited.add(source);

        for (int val : adj.get(source)) {
            if (!isVisited.contains(val)) {
                getTopologicalSortUsingDfs(adj, isVisited, st, val);
            }
        }

        st.push(source);
    }
}
