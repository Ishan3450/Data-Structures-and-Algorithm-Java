package Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CriticalConnectionsInANetwork {
    private class Pair {
        int toi, lit; // time of insertion and lowest insertion time

        Pair(int time) {
            this.toi = time;
            this.lit = time;
        }
    }

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for (List<Integer> edge : connections) {
            if (!adjList.containsKey(edge.get(0))) {
                adjList.put(edge.get(0), new ArrayList<>());
            }

            if (!adjList.containsKey(edge.get(1))) {
                adjList.put(edge.get(1), new ArrayList<>());
            }
            adjList.get(edge.get(0)).add(edge.get(1));
            adjList.get(edge.get(1)).add(edge.get(0));
        }

        List<List<Integer>> bridges = new ArrayList<>();
        Set<Integer> isVisited = new HashSet<>();
        Pair[] pairs = new Pair[n];
        int[] time = { 1 };

        dfs(0, 0, bridges, adjList, isVisited, pairs, time);

        return bridges;
    }

    private void dfs(int source, int parent, List<List<Integer>> bridges, Map<Integer, List<Integer>> adjList,
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
