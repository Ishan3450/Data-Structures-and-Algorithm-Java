package Graphs;

// using adjacency matrix
public class GraphUsingAdjacencyMatrix {
    private int[][] adjacencyMatrix;
    private int numVertices;

    public GraphUsingAdjacencyMatrix(int numVertices) {
        this.numVertices = numVertices;
        adjacencyMatrix = new int[numVertices][numVertices];
    }

    public void addEdge(int source, int destination, boolean isUndirectedGraph) {
        adjacencyMatrix[source][destination] = 1;

        if (isUndirectedGraph)
            adjacencyMatrix[destination][source] = 1;
    }

    public void removeEdge(int source, int destination, boolean isUndirectedGraph) {
        adjacencyMatrix[source][destination] = 0;

        if (isUndirectedGraph)
            adjacencyMatrix[destination][source] = 0;
    }

    public boolean hasEdge(int source, int destination, boolean isUndirectedGraph) {
        if (isUndirectedGraph)
            return adjacencyMatrix[source][destination] == 1 && adjacencyMatrix[destination][source] == 1;

        return adjacencyMatrix[source][destination] == 1;
    }

    public void printGraph() {
        for (int i = 0; i < numVertices; i++) {
            System.out.print("Vertex " + i + " is connected to: ");
            for (int j = 0; j < numVertices; j++) {
                if (adjacencyMatrix[i][j] == 1) {
                    System.out.print(j + " ");
                }
            }
            System.out.println();
        }
    }

}
