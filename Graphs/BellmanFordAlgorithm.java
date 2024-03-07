package Graphs;

import java.util.ArrayList;
import java.util.Arrays;

public class BellmanFordAlgorithm {
    /*
     * TC is more than Dijkstra algo
     * 
     * Only 2 main things:
     * 1. Loop for Vertices-1 times
     * 2. Every time do relaxation (updation if shorter path found)
     * 
     * ** Must knwo why Vertices-1 and how relaxation will work
     */
    final static int DEFAULT = 100000000;

    static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int S) {
        int[] shortestDistance = new int[V];
        Arrays.fill(shortestDistance, DEFAULT);
        shortestDistance[S] = 0;

        for (int times = 0; times < V - 1; times++) {
            boolean isChanged = false;

            for (ArrayList<Integer> edge : edges) {
                // * edge structure: {source, destination, weight}
                int source = edge.get(0);
                int destination = edge.get(1);
                int weight = edge.get(2);

                if (shortestDistance[source] != DEFAULT) {
                    if (shortestDistance[source] + weight < shortestDistance[destination]) {
                        isChanged = true;
                        shortestDistance[destination] = shortestDistance[source] + weight;
                    }
                }
            }

            if (!isChanged) {
                break;
            }
        }

        // ** checking for negative cycle
        boolean isNegativeCyclePresent = false;

        for (ArrayList<Integer> edge : edges) {
            // edge: {source, destination, weight}
            int source = edge.get(0);
            int destination = edge.get(1);
            int weight = edge.get(2);

            if (shortestDistance[source] != DEFAULT) {
                if (shortestDistance[source] + weight < shortestDistance[destination]) {
                    isNegativeCyclePresent = true;
                    break;
                }
            }
        }

        if (isNegativeCyclePresent) {
            return new int[] { -1 }; // stated in question to return {-1}
        }
        return shortestDistance;
    }
}
