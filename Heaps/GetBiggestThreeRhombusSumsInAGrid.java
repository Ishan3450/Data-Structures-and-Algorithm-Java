package Heaps;

import java.util.Collections;
import java.util.HashSet;
import java.util.PriorityQueue;

public class GetBiggestThreeRhombusSumsInAGrid {
    private class Pair {
        int row, col;

        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public int[] getBiggestThree(int[][] grid) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        HashSet<Integer> track = new HashSet<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                addRhombusesSums(grid, i, j, pq, track);
            }
        }

        int[] ans = new int[pq.size() >= 3 ? 3 : pq.size()];
        int idx = 0;

        while (!pq.isEmpty() && idx < 3) {
            ans[idx++] = pq.remove();
        }

        return ans;
    }

    private void addRhombusesSums(int[][] grid, int row, int col, PriorityQueue<Integer> pq, HashSet<Integer> set) {
        int sum = grid[row][col];

        if (!set.contains(sum)) {
            pq.add(sum);
            set.add(sum);
        }

        // points of rhombus (alphabetically clock-wise)
        Pair a = new Pair(row - 1, col);
        Pair b = new Pair(row, col + 1);
        Pair c = new Pair(row + 1, col);
        Pair d = new Pair(row, col - 1);

        while (arePointsInRange(grid, a, b, c, d)) {
            int currRhombusSum = 0;

            int tr, tc; // temp row and col iterators

            // counting border from a to b (r++, c++)
            tr = a.row;
            tc = a.col;

            while (tr < b.row && tc < b.col) {
                currRhombusSum += grid[tr][tc];
                tr++;
                tc++;
            }

            // counting border from b to c (r++, c--)
            tr = b.row;
            tc = b.col;

            while (tr < c.row && tc > c.col) {
                currRhombusSum += grid[tr][tc];
                tr++;
                tc--;
            }

            // counting border from c to d (r--, c--)
            tr = c.row;
            tc = c.col;

            while (tr > d.row && tc > d.col) {
                currRhombusSum += grid[tr][tc];
                tr--;
                tc--;
            }

            // counting border from d to a (r--, c++)
            tr = d.row;
            tc = d.col;

            while (tr > a.row && tc < a.col) {
                currRhombusSum += grid[tr][tc];
                tr--;
                tc++;
            }

            if (!set.contains(currRhombusSum)) {
                pq.add(currRhombusSum);
                set.add(currRhombusSum);
            }

            // expanding the curr rhombus to a single point bigger one
            a.row--;
            b.col++;
            c.row++;
            d.col--;
        }
    }

    private boolean arePointsInRange(int[][] grid, Pair a, Pair b, Pair c, Pair d) {
        int n = grid.length;
        int m = grid[0].length;

        if (!isPointInRange(n, m, a) ||
                !isPointInRange(n, m, b) ||
                !isPointInRange(n, m, c) ||
                !isPointInRange(n, m, d)) {
            return false;
        }

        return true;
    }

    private boolean isPointInRange(int n, int m, Pair point) {
        if (point.row < 0 || point.row >= n || point.col < 0 || point.col >= m) {
            return false;
        }
        return true;
    }
}

// rhombus only possible for i > 0, j > 0, i <= n-1, j < n-1