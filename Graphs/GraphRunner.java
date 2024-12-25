package Graphs;

public class GraphRunner {
    public static void main(String[] args) {
        GraphUsingAdjacencyMatrix graph = new GraphUsingAdjacencyMatrix(5);
        graph.addEdge(0, 1, true);
        graph.addEdge(0, 2, true);
        graph.addEdge(1, 3, true);
        graph.addEdge(2, 4, true);
        graph.printGraph();
        System.out.println();
        GraphUsingAdjacencyList graph2 = new GraphUsingAdjacencyList(5); // Undirected graph
        graph2.addEdge(0, 1, true);
        graph2.addEdge(0, 2, true);
        graph2.addEdge(1, 3, true);
        graph2.addEdge(2, 4, true);
        graph2.printGraph();
    }
}
