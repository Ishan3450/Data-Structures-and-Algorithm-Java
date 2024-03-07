package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DetectCycleInADirectedGraphBFSKahnAlgo {
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        Queue<Integer> ans = new LinkedList<>();
        bfsKahnAlgo(V, adj, ans);

        if (ans.size() != V) {
            // cycle is tehre
            return true;
        }
        return false;
    }

    public void bfsKahnAlgo(int V, ArrayList<ArrayList<Integer>> adj, Queue<Integer> ans) {
        int[] inDegrees = new int[V];

        // calculating indegrees
        for (int i = 0; i < V; i++) {
            for (int val : adj.get(i)) {
                inDegrees[val]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (inDegrees[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int peek = q.remove();

            ans.add(peek);

            for (int val : adj.get(peek)) {
                if (--inDegrees[val] == 0) {
                    q.add(val);
                }
            }
        }

    }
}
