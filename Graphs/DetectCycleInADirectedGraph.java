package Graphs;

import java.util.ArrayList;
import java.util.HashSet;

public class DetectCycleInADirectedGraph {
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        HashSet<Integer> isVisited = new HashSet<>();
        for (int i = 0; i < V; i++) {
            if (!isVisited.contains(i) && dfs(i, adj, isVisited, new HashSet<>())) {
                return true;
            }
        }
        return false;
    }

    public boolean dfs(int source, ArrayList<ArrayList<Integer>> adj, HashSet<Integer> isVisited, HashSet<Integer> recursionStack) {
        isVisited.add(source);
        recursionStack.add(source);

        for (int neighbour : adj.get(source)) {
            if (recursionStack.contains(neighbour)) {
                return true;
            } else {
                if (dfs(neighbour, adj, isVisited, recursionStack)) {
                    return true;
                }
            }
        }
        // * did mistake in below like placed this line at wrong place in the code
        recursionStack.remove(source); // backtracking

        return false;
    }
}
