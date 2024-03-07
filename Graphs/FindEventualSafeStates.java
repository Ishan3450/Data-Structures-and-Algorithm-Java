package Graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindEventualSafeStates {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        boolean[] isSafe = new boolean[graph.length];

        Set<Integer> isVisited = new HashSet<>();
        Set<Integer> recursionStack = new HashSet<>();

        for (int i = 0; i < graph.length; i++) {
            if (!isVisited.contains(i)) {
                detectCycle(i, isVisited, recursionStack, graph, isSafe);
            }
        }

        List<Integer> safeNodes = new ArrayList<>();
        for (int i = 0; i < isSafe.length; i++) {
            if (isSafe[i]) {
                safeNodes.add(i);
            }
        }
        return safeNodes;
    }

    private boolean detectCycle(int source, Set<Integer> isVisited, Set<Integer> recursionStack, int[][] graph,
            boolean[] isSafe) {
        isVisited.add(source);
        recursionStack.add(source);
        isSafe[source] = false; // initially assumming curr node is not safe

        for (int neighbour : graph[source]) {
            if (recursionStack.contains(neighbour)) {
                return true; // cycle detected
            }

            if (!isVisited.contains(neighbour)) {
                if (detectCycle(neighbour, isVisited, recursionStack, graph, isSafe)) {
                    return true; // cycle is there so definately not a safe node
                }
            }
        }

        recursionStack.remove(source);
        isSafe[source] = true; // stating source node as a safe node
        return false; // no cycle detected
    }
}
