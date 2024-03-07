package Graphs;

import java.util.*;

// using adjacency list
public class GraphUsingAdjacencyList {
    private int numVertices;
    private Map<Integer, List<Integer>> adjacencyList;

    public GraphUsingAdjacencyList(int numVertices) {
        this.numVertices = numVertices;
        this.adjacencyList = new HashMap<>();
        for (int i = 0; i < numVertices; i++) {
            adjacencyList.put(i, new LinkedList<>());
        }
    }

    public void addEdge(int source, int destination, boolean isUndirectedGraph) {
        adjacencyList.get(source).add(destination);

        if (isUndirectedGraph)
            adjacencyList.get(destination).add(source); // For undirected graph
    }

    public void removeEdge(int source, int destination, boolean isUndirectedGraph) {
        adjacencyList.get(source).remove(Integer.valueOf(destination));

        if (isUndirectedGraph)
            adjacencyList.get(destination).remove(Integer.valueOf(source)); // For undirected graph
    }

    public boolean hasEdge(int source, int destination, boolean isUndirectedGraph) {
        if (isUndirectedGraph)
            return adjacencyList.get(source).contains(destination) && adjacencyList.get(destination).contains(source);

        return adjacencyList.get(source).contains(destination);
    }

    public void printGraph() {
        for (int i = 0; i < numVertices; i++) {
            List<Integer> neighbors = adjacencyList.get(i);
            System.out.print("Vertex " + i + " is connected to: ");
            for (int neighbor : neighbors) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }

    public Map<Integer, List<Integer>> getAdjacencyList() {
        return adjacencyList;
    }
}

