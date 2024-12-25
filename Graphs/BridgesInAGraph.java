package Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BridgesInAGraph {
    private static class Pair {
        int toi, lit; // time of insertion and lowest insertion time

        Pair(int time) {
            this.toi = time;
            this.lit = time;
        }
    }

    public static List<List<Integer>> findBridges(int[][] edges, int v, int e) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for (int[] edge : edges) {
            if (!adjList.containsKey(edge[0])) {
                adjList.put(edge[0], new ArrayList<>());
            }

            if (!adjList.containsKey(edge[1])) {
                adjList.put(edge[1], new ArrayList<>());
            }
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        List<List<Integer>> bridges = new ArrayList<>();
        Set<Integer> isVisited = new HashSet<>();
        Pair[] pairs = new Pair[v];
        int[] time = { 1 };

        for (int i = 0; i < v; i++) {
            if (!isVisited.contains(i))
                dfs(0, 0, bridges, adjList, isVisited, pairs, time);
        }

        return bridges;
    }

    private static void dfs(int source, int parent, List<List<Integer>> bridges, Map<Integer, List<Integer>> adjList,
            Set<Integer> isVisited, Pair[] pairs, int[] time) {
        isVisited.add(source);
        pairs[source] = new Pair(time[0]);
        time[0]++;

        for (int neighbour : adjList.getOrDefault(source, new ArrayList<>())) {
            if (neighbour == parent)
                continue;

            if (isVisited.contains(neighbour)) {
                pairs[source].lit = Math.min(pairs[source].lit, pairs[neighbour].lit);
            } else {
                dfs(neighbour, source, bridges, adjList, isVisited, pairs, time);

                pairs[source].lit = Math.min(pairs[source].lit, pairs[neighbour].lit);

                /*
                 * Below condition is a important part of the code
                 * 
                 * Why we are checking source.toi because if may be possible that source.lit might be change if its neighbour's lit is smaller than source.lit as done in the above code line that's why we are checking source.toi not source.lit
                 */
                if (pairs[neighbour].lit > pairs[source].toi) {
                    List<Integer> bridge = new ArrayList<>();
                    bridge.add(source);
                    bridge.add(neighbour);

                    bridges.add(bridge);
                }
            }
        }
    }
}
