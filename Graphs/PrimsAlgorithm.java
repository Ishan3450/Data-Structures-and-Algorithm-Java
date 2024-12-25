package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrimsAlgorithm {
    private static class WeightedNode {
        int node;
        int weight;

        WeightedNode(int node, int w) {
            this.node = node;
            this.weight = w;
        }
    }

    static int spanningTree(int V, int E, int edges[][]) {
        Map<Integer, List<WeightedNode>> adj = new HashMap<>();
        for (int[] edge : edges) {
            int source = edge[0];
            int dest = edge[1];
            int weight = edge[2];

            adj.putIfAbsent(source, new ArrayList<>());
            adj.putIfAbsent(dest, new ArrayList<>());

            adj.get(source).add(new WeightedNode(dest, weight));
            adj.get(dest).add(new WeightedNode(source, weight));
        }

        int[] minDistance = new int[V];
        boolean[] isIncluded = new boolean[V];

        Arrays.fill(minDistance, Integer.MAX_VALUE);
        minDistance[0] = 0; // initial source

        for (int i = 0; i < V; i++) {
            int minDist = Integer.MAX_VALUE;
            int sourceNode = -1;

            // finding node having minimum distance to reach
            for (int j = 0; j < V; j++) {
                if (isIncluded[j] == false && minDistance[j] < minDist) {
                    sourceNode = j;
                    minDist = minDistance[j];
                }
            }

            // marking the sourceNode as true as we will include it in our spanning tree
            isIncluded[sourceNode] = true;

            // visiting neighbour nodes
            for (WeightedNode neighbour : adj.get(sourceNode)) {
                int destination = neighbour.node;
                int weight = neighbour.weight;

                if (isIncluded[destination] == false && weight < minDistance[destination]) {
                    minDistance[destination] = weight;
                }
            }
        }

        int minimumWeight = 0;
        for (int val : minDistance) {
            minimumWeight += val;
        }
        return minimumWeight;
    }
}
