package Graphs;

import java.util.*;

import Graphs.WeightedGraphUsingAdjacencyList.WeightedEdge;

public class ShortestPathFromSingleSourceToAllDestionations {
    public static void main(String[] args) {
        WeightedGraphUsingAdjacencyList g = new WeightedGraphUsingAdjacencyList(5);
        g.addEdge(0, 1, 5, false);
        g.addEdge(0, 2, 3, false);
        g.addEdge(2, 1, 2, false);
        g.addEdge(1, 3, 3, false);
        g.addEdge(2, 3, 5, false);
        g.addEdge(2, 4, 6, false);
        g.addEdge(4, 3, 1, false);

        Map<Integer, List<WeightedEdge>> adjList = g.getAdjacencyList();

        int[] allDestinationShortestPath = shortestPath(5, adjList, 3);

        System.out.println(Arrays.toString(allDestinationShortestPath));
    }
    
    public static int[] shortestPath(int v, Map<Integer, List<WeightedEdge>> adjList, int destination){
        Stack<Integer> safeOrder = new Stack<>();
        getTopologicalSortOrder(adjList, 0, new HashSet<>(), safeOrder);

        int[] shortestDistance = new int[v];
        Arrays.fill(shortestDistance, Integer.MAX_VALUE);

        boolean isSourceFound = false;

        while(!safeOrder.isEmpty()){
            int front = safeOrder.pop();

            if(!isSourceFound){ // this will only run for the first pop() from the stack
                shortestDistance[front] = 0; // setting source distance 0 so that we can start from someplace
                isSourceFound = true;
            }

            if(shortestDistance[front] != Integer.MAX_VALUE){ // if not max_val means we have reached at front value atleast once
                for(WeightedEdge we: adjList.get(front)){
                    int oldDist = shortestDistance[we.destination];
                    int newDist = shortestDistance[front] + we.weight;

                    if(newDist < oldDist){
                        shortestDistance[we.destination] = newDist;
                    }
                }
            }
        }

        return shortestDistance;
    }

    public static void getTopologicalSortOrder(Map<Integer, List<WeightedEdge>> adjList, int source, Set<Integer> isVisited, Stack<Integer> safeOrder){
        isVisited.add(source);

        for(WeightedEdge w: adjList.get(source)){
            if(!isVisited.contains(w.destination)){
                getTopologicalSortOrder(adjList, w.destination, isVisited, safeOrder);
            }
        }
        safeOrder.push(source);
    }
}
