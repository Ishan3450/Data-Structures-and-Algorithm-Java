package Graphs;

import java.util.*;

public class GraphBFSTraversal {
    public static void main(String[] args) {
        GraphUsingAdjacencyList g = new GraphUsingAdjacencyList(8);

        // g.addEdge(0, 1, true);
        // g.addEdge(1, 2, true);
        // g.addEdge(1, 3, true);
        // g.addEdge(3, 5, true);
        // g.addEdge(3, 7, true);
        // g.addEdge(7, 6, true);
        // g.addEdge(7, 4, true);

        g.addEdge(0, 1, true);
        g.addEdge(0, 2, true);
        g.addEdge(1, 3, true);
        g.addEdge(2, 4, true);


        bfs(0, g.getAdjacencyList());
    }

    public static void bfs(int source, Map<Integer, List<Integer>> adjacencyList){
        Queue<Integer> q = new LinkedList<>();
        HashSet<Integer> set = new HashSet<>();

        q.add(source);
        set.add(source);

        while(!q.isEmpty()){
            int peek = q.remove();
            System.out.print(peek + " ");

            for(int neighbour: adjacencyList.get(peek)){
                if(!set.contains(neighbour)){
                    q.add(neighbour);
                    set.add(neighbour);
                }
            }
        }
        
    }
}
