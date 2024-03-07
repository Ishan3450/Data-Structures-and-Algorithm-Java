package Graphs;

import java.util.Arrays;
import java.util.PriorityQueue;

public class PathWithMinimumEffort {
    private class Pair implements Comparable<Pair> {
        int diff;
        int row, col;

        Pair(int diff, int row, int col) {
            this.diff = diff;
            this.row = row;
            this.col = col;
        }

        @Override
        public int compareTo(Pair o) {
            if (this.diff == o.diff)
                return 0;
            return this.diff > o.diff ? 1 : -1;
        }
    }

    public int minimumEffortPath(int[][] heights) {
        int[][] minimumDifference = new int[heights.length][heights[0].length];
        for (int[] row : minimumDifference)
            Arrays.fill(row, Integer.MAX_VALUE);

        return dijkstra(heights, minimumDifference);
    }

    public int dijkstra(int[][] heights, int[][] minimumDifference) {
        PriorityQueue<Pair> q = new PriorityQueue<>();

        // initials
        q.add(new Pair(0, 0, 0));
        minimumDifference[0][0] = 0;

        while (!q.isEmpty()) {
            Pair peek = q.remove();

            if (peek.row == heights.length - 1 && peek.col == heights[0].length - 1) {
                continue; // here we are not returning ans as there might be chance that other node is
                          // present in queue and there is a possible shortest max abs diff path to the
                          // source that's why
            }

            // u r b l
            int[] rowMoves = { -1, 0, 1, 0 };
            int[] colMoves = { 0, 1, 0, -1 };

            for (int i = 0; i < 4; i++) {
                int currRow = peek.row + rowMoves[i];
                int currCol = peek.col + colMoves[i];

                if (currRow >= 0 && currCol >= 0 && currRow < heights.length && currCol < heights[0].length) {
                    /*
                     * First we have to take new difference of peek.locations - newLocations
                     * Then we have to find max abs diff of the path, so we will compare peek.diff
                     * and new diff
                     * If new diff is less then minimum difference of new locations then we will
                     * insert it in heap
                     */
                    int newDiff = Math.abs(heights[peek.row][peek.col] - heights[currRow][currCol]);
                    int newMaxAbsDiff = Math.max(newDiff, peek.diff);

                    if (newMaxAbsDiff < minimumDifference[currRow][currCol]) {
                        // we have to update new diff at 2 places:
                        // 1 is in the minimumDifference storage
                        // 2 is if existing pair of [currRow, currCol] is already present in the heap we
                        // have to update that too

                        minimumDifference[currRow][currCol] = newMaxAbsDiff;

                        Pair p = new Pair(peek.diff, currRow, currCol);
                        q.remove(p);

                        p.diff = newMaxAbsDiff;
                        q.add(p);
                    }
                }
            }
        }

        return minimumDifference[heights.length - 1][heights[0].length - 1];
    }
}
