package Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, ArrayList<Integer>> adjList = createGraph(numCourses, prerequisites);

        return bfsKahnAlgo(numCourses, adjList);
    }

    private static HashMap<Integer, ArrayList<Integer>> createGraph(int numCourses, int[][] prerequisites) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

        for (int i = 0; i < numCourses; i++) {
            map.put(i, new ArrayList<>());
        }

        for (int[] prerequisite : prerequisites) {
            int toComplete = prerequisite[0];
            int mustComplete = prerequisite[1];

            map.get(mustComplete).add(toComplete);
        }

        return map;
    }

    private static boolean bfsKahnAlgo(int V, HashMap<Integer, ArrayList<Integer>> adj) {
        Queue<Integer> output = new LinkedList<>();
        Queue<Integer> q = new LinkedList<>();
        int[] indegrees = new int[V];

        for (int i = 0; i < V; i++) {
            for (int val : adj.get(i)) {
                indegrees[val]++;
            }
        }

        for (int i = 0; i < V; i++) {
            if (indegrees[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int peek = q.remove();

            output.add(peek);

            for (int val : adj.get(peek)) {
                if (--indegrees[val] == 0) {
                    q.add(val);
                }
            }
        }

        return output.size() == V;
    }
}
