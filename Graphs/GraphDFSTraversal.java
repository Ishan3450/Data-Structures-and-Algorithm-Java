package Graphs;

import java.util.*;

public class GraphDFSTraversal {
    public static void main(String[] args) {
        GraphUsingAdjacencyList g = new GraphUsingAdjacencyList(8);
         
        // g.addEdge(0, 1, true);
        // g.addEdge(1, 2, true);
        // g.addEdge(1, 3, true);
        // g.addEdge(3, 5, true);
        // g.addEdge(3, 7, true);
        // g.addEdge(7, 6, true);
        // g.addEdge(7, 4, true);

        g.addEdge(0, 1, true);
        g.addEdge(0, 2, true);
        g.addEdge(1, 3, true);
        g.addEdge(2, 4, true);

        HashSet<Integer> isVisited = new HashSet<>();
        isVisited.add(0);
        dfs(0, g.getAdjacencyList(), isVisited);
    }

    public static void dfs(int source, Map<Integer, List<Integer>> adjacencyList, HashSet<Integer> isVisited) {
        System.out.print(source + " ");

        for(int neighbour: adjacencyList.get(source)){
            if(!isVisited.contains(neighbour)){
                isVisited.add(neighbour);
                dfs(neighbour, adjacencyList, isVisited);
            }
        }
    }
}
