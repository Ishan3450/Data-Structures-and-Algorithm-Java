package Graphs;

import java.util.*;

public class DetectCycleInAnUndirectedGraph {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        Set<Integer> isVisited = new HashSet<>();

        for (int i = 0; i < V; i++) {
            if (!isVisited.contains(i) && bfs(i, adj, isVisited)) {
                return true;
            }
        }

        // for(int i = 0 ; i < V ; i ++){
        // if(!isVisited.contains(i) && dfs(i, adj, isVisited, -1)){
        // return true;
        // }
        // }

        return false;
    }

    private boolean bfs(int source, ArrayList<ArrayList<Integer>> adj, Set<Integer> isVisited) {
        Queue<Integer> q = new LinkedList<>();
        HashMap<Integer, Integer> parent = new HashMap<>();

        q.add(source);
        isVisited.add(source);
        parent.put(source, -1);

        while (!q.isEmpty()) {
            int peek = q.remove();

            for (int neighbour : adj.get(peek)) {
                if (isVisited.contains(neighbour)) {

                    // **** important line where I had stuck for a long time
                    if (parent.get(peek) != neighbour) { // if this conditions gets true means neighbour is the element
                                                         // which was previously visited by other node of the graph
                        return true;
                    }
                } else { // not visited
                    q.add(neighbour);
                    isVisited.add(neighbour);
                    parent.put(neighbour, peek);
                }
            }
        }

        return false;
    }

    // TLE Approach
    private boolean dfs(int source, ArrayList<ArrayList<Integer>> adj, Set<Integer> isVisited, int parent) {
        isVisited.add(source);

        for (int val : adj.get(source)) {
            if (isVisited.contains(val)) { // visited node
                if (val != parent) {
                    return true;
                }
            } else { // not visited
                if (dfs(val, adj, isVisited, source)) {
                    return true;
                }
            }
        }
        return false;
    }
}
