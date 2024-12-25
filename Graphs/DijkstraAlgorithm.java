package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

/*
 * Dijkstra algo does not works on negative cycles and negative weights
 */

public class DijkstraAlgorithm {
    private static class Node implements Comparable<Node> {
        int distance;
        int node;

        Node(int dist, int node) {
            this.distance = dist;
            this.node = node;
        }

        @Override
        public int compareTo(Node o) {
            return this.distance == o.distance ? 0 : this.distance > o.distance ? 1 : -1;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;

            if (obj == null || this.getClass() != obj.getClass())
                return false;

            Node other = (Node) obj;
            if (distance != other.distance || node != other.node)
                return false;

            return true;
        }

    }

    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {
        PriorityQueue<Node> pq = new PriorityQueue<>();

        int[] shortestDistance = new int[V];
        Arrays.fill(shortestDistance, Integer.MAX_VALUE);

        shortestDistance[S] = 0;
        pq.add(new Node(0, S));

        while (!pq.isEmpty()) {
            Node peek = pq.remove(); // got the node having least distance till now

            int node = peek.node;
            int dist = peek.distance;

            for (ArrayList<Integer> neighbour : adj.get(node)) {
                // 0 is destination node
                // 1 is weight

                int oldDist = shortestDistance[neighbour.get(0)];
                int newDist = dist + neighbour.get(1);

                if (newDist < oldDist) { // we got a new path having shorter length than the older one
                    // as we got a new distance we have to update it at 2 places:
                    // 1 in the shortestDistance array
                    // 2 in the priority queue as there is a change that older node might present

                    // updating in the shortest distance
                    shortestDistance[neighbour.get(0)] = newDist;

                    // updating in the priority queue
                    Node temp = new Node(oldDist, neighbour.get(0));
                    if (pq.contains(temp)) {
                        pq.remove(temp);
                    }
                    pq.add(new Node(newDist, neighbour.get(0)));
                }
            }
        }
        return shortestDistance;
    }
}
