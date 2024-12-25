package Graphs;

import java.util.LinkedList;
import java.util.Queue;

/*
 * In this question BFS appraoch is preferred over DFS as we will be solving this questiosn level wise not depth wise at t point of time we will solve one complete level
 */
public class RottingOranges {
    private class Pair {
        int row, col;

        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public int orangesRotting(int[][] grid) {
        Queue<Pair> q = new LinkedList<>();
        int freshOrangesCount = 0;

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {

                if (grid[row][col] == 1) { // fresh orange found
                    freshOrangesCount++;
                }

                if (grid[row][col] == 2) { // rotten orange found
                    q.add(new Pair(row, col));
                }
            }
        }

        int ans = bfs(grid.clone(), q, freshOrangesCount);

        // * removed this below loop checking by passing a count of fresh oranges to the
        // bfs method
        // for(int row = 0; row < grid.length; row ++){
        // for(int col = 0; col < grid[0].length; col ++){
        // if(grid[row][col] == 1){
        // return -1;
        // }
        // }
        // }

        return ans;
    }

    public int bfs(int[][] grid, Queue<Pair> q, int freshOrangesCount) {
        int time = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            boolean newRotten = false;

            for (int itr = 0; itr < size; itr++) {
                Pair peek = q.remove();
                int row = peek.row;
                int col = peek.col;

                // u r b l
                int[] rowMoves = { -1, 0, 1, 0 };
                int[] colMoves = { 0, 1, 0, -1 };

                for (int i = 0; i < 4; i++) {
                    int newRow = row + rowMoves[i];
                    int newCol = col + colMoves[i];

                    if (newRow >= 0 && newCol >= 0 && newRow < grid.length && newCol < grid[0].length
                            && grid[newRow][newCol] == 1) {
                        q.add(new Pair(newRow, newCol));
                        grid[newRow][newCol] = 2;
                        newRotten = true;
                        freshOrangesCount--;
                    }
                }
            }

            if (newRotten)
                time++;
        }

        if (freshOrangesCount != 0) {
            return -1;
        }

        return time;
    }
}
