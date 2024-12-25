package Graphs;

import java.util.*;

public class WeightedGraphUsingAdjacencyList {
    private int numVertices;
    private Map<Integer, List<WeightedEdge>> adjacencyList;

    public WeightedGraphUsingAdjacencyList(int numVertices) {
        this.numVertices = numVertices;
        this.adjacencyList = new HashMap<>();
        for (int i = 0; i < numVertices; i++) {
            adjacencyList.put(i, new LinkedList<>());
        }
    }

    public void addEdge(int source, int destination, int weight, boolean isUndirectedGraph) {
        adjacencyList.get(source).add(new WeightedEdge(destination, weight));

        if (isUndirectedGraph)
            adjacencyList.get(destination).add(new WeightedEdge(source, weight)); // For undirected graph
    }

    public void printGraph() {
        for (int i = 0; i < numVertices; i++) {
            List<WeightedEdge> edges = adjacencyList.get(i);
            System.out.print("Vertex " + i + " is connected to: ");
            for (WeightedEdge edge : edges) {
                System.out.print(edge.destination + " (Weight: " + edge.weight + ") ");
            }
            System.out.println();
        }
    }

    public Map<Integer, List<WeightedEdge>> getAdjacencyList() {
        return adjacencyList;
    }

    public static class WeightedEdge {
        public int destination;
        public int weight;

        public WeightedEdge(int destination, int weight) {
            this.destination = destination;
            this.weight = weight;
        }
    }
}
