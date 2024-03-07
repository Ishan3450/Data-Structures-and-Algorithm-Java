package Graphs;

import java.util.Arrays;

public class KruskalsAlgorithm {
    static int spanningTree(int V, int E, int edges[][]) {
        int[] power = new int[V];
        int[] parent = new int[V];

        for (int i = 0; i < V; i++) {
            parent[i] = i; // initially parent of node will be self only
        }

        Arrays.sort(edges, (int[] a, int[] b) -> a[2] - b[2]); // sorting edges based on their weights

        int minimumSpanningTreeWeight = 0;

        for (int i = 0; i < edges.length; i++) {
            int source = edges[i][0];
            int destination = edges[i][1];
            int weight = edges[i][2];

            int parentOfSource = findParent(parent, source);
            int parentOfDestination = findParent(parent, destination);

            if (parentOfSource != parentOfDestination) {
                minimumSpanningTreeWeight += weight;
                unionSet(parent, power, parentOfSource, parentOfDestination);
            }
        }

        return minimumSpanningTreeWeight;
    }

    /*
     * Find parent using path compression logic
     */
    private static int findParent(int[] parent, int node) {
        if (parent[node] == node) {
            return node;
        }
        return parent[node] = findParent(parent, parent[node]);
    }

    /*
     * Union set using union find algorithm
     */
    private static void unionSet(int[] parent, int[] power, int source, int destination) {
        // we have to do union of source and destination

        if (power[source] < power[destination]) {
            parent[source] = destination;
            power[destination]++;
        } else { // power[source] > power[destination]
            parent[destination] = source;
            power[source]++;
        }
    }
}
