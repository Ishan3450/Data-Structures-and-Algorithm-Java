package Graphs;

import java.util.Arrays;

public class FindCityWithSmallestNumberOfNeighborsAtThresholdDistance {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] shortestDistance = new int[n][n];
        for (int[] row : shortestDistance)
            Arrays.fill(row, Integer.MAX_VALUE);

        // setting weights
        for (int[] edge : edges) {
            shortestDistance[edge[0]][edge[1]] = edge[2];
            shortestDistance[edge[1]][edge[0]] = edge[2]; // undirected
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    shortestDistance[i][j] = 0;
                } else if (shortestDistance[i][j] == Integer.MAX_VALUE) {
                    shortestDistance[i][j] = 10001; // settting this after reading constrains
                }
            }
        }

        // floyd warshall algorithm
        for (int helper = 0; helper < n; helper++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    shortestDistance[i][j] = Math.min(shortestDistance[i][j],
                            shortestDistance[i][helper] + shortestDistance[helper][j]);
                }
            }
        }

        int minCities = Integer.MAX_VALUE;
        int cityNum = 0;
        for (int i = 0; i < n; i++) {
            int citiesWithinThresholdDistance = 0;
            for (int j = 0; j < n; j++) {
                if (shortestDistance[i][j] <= distanceThreshold) {
                    citiesWithinThresholdDistance++;
                }
            }

            if (citiesWithinThresholdDistance > 0 && citiesWithinThresholdDistance <= minCities) {
                cityNum = i;
                minCities = citiesWithinThresholdDistance;
            }
        }
        return cityNum;
    }
}
