package Graphs;

import java.util.HashMap;
import java.util.HashSet;

public class MaximumConnectedGroup {
    private final int[] directionRows = { -1, 0, 1, 0 };
    private final int[] directionCols = { 0, 1, 0, -1 };

    public int MaxConnection(int grid[][]) {
        HashMap<Integer, Integer> dp = new HashMap<>();
        int id = 2;
        int maxCount = 0;

        boolean allOnes = true;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != 1)
                    continue;

                int count = dfs(grid, i, j, id);
                dp.put(id, count);
                id++;
            }
        }

        HashSet<Integer> set = new HashSet<>();
        for (int r = 0; r < grid.length; r++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[r][j] != 0)
                    continue;

                if (allOnes) {
                    allOnes = false;
                }

                for (int i = 0; i < 4; i++) {
                    int newRow = r + directionRows[i];
                    int newCol = j + directionCols[i];

                    if (checkBounds(grid.length, newRow, newCol) && grid[newRow][newCol] != 0
                            && !set.contains(grid[newRow][newCol])) {
                        set.add(grid[newRow][newCol]);
                    }
                }

                int count = 1;
                for (int val : set) {
                    count += dp.get(val);
                }
                set.clear();
                maxCount = Math.max(maxCount, count);
            }
        }

        if (allOnes) {
            return (int) Math.pow(grid.length, 2);
        }
        return maxCount;
    }

    private int dfs(int[][] grid, int row, int col, int id) {
        grid[row][col] = id;

        int count = 1;
        for (int i = 0; i < 4; i++) {
            int newRow = row + directionRows[i];
            int newCol = col + directionCols[i];

            if (checkBounds(grid.length, newRow, newCol) && grid[newRow][newCol] == 1) {
                count += dfs(grid, newRow, newCol, id);
            }
        }

        return count;
    }

    private boolean checkBounds(int n, int row, int col) {
        return row >= 0 && row < n && col >= 0 && col < n;
    }
}
