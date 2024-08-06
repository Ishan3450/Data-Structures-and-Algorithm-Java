package Graphs;

import java.util.*;

public class MaximumTotalImportanceOfRoads {

    // better appraoch than the one mentioned below
    public long maximumImportance(int n, int[][] roads) {
        long[] neighbours = new long[n];

        for (int i = 0; i < roads.length; i++) {
            neighbours[roads[i][0]]++;
            neighbours[roads[i][1]]++;
        }
        Arrays.sort(neighbours); // srot by degree

        long importance = 0;
        int cityValue = 1;

        for (int i = 0; i < n; i++) {
            long sum = cityValue * neighbours[i];
            importance += sum;
            cityValue++;
        }

        return importance;
    }

    class ApproachedBySelf {
        private class Pair implements Comparable<Pair> {
            int node, neighbours;

            Pair(int node, int neighbours) {
                this.node = node;
                this.neighbours = neighbours;
            }

            @Override
            public int compareTo(Pair o) {
                return this.neighbours - o.neighbours;
            }
        }

        public long maximumImportance(int n, int[][] roads) {
            int[] neighbours = new int[n];

            for (int i = 0; i < roads.length; i++) {
                neighbours[roads[i][0]]++;
                neighbours[roads[i][1]]++;
            }

            PriorityQueue<Pair> pq = new PriorityQueue<>();

            for (int i = 0; i < n; i++) {
                pq.add(new Pair(i, neighbours[i]));
            }

            for (int i = 1; i <= n; i++) {
                Pair peek = pq.remove();

                neighbours[peek.node] = i;
            }

            long importance = 0;

            for (int i = 0; i < roads.length; i++) {
                int sum = neighbours[roads[i][0]] + neighbours[roads[i][1]];
                importance += sum;
            }

            return importance;
        }
    }
}
