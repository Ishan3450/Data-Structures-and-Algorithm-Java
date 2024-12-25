package Graphs;

public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image[sr][sc] == color) {
            return image;
        }

        int[][] clonedImage = image.clone();
        dfs(clonedImage, sr, sc, image[sr][sc], color);
        return clonedImage;
    }

    public void dfs(int[][] grid, int row, int col, int oldColor, int newColor) {
        grid[row][col] = newColor;

        // u r b l
        int[] rowMoves = { -1, 0, 1, 0 };
        int[] colMoves = { 0, 1, 0, -1 };

        for (int i = 0; i < 4; i++) {
            int newRow = row + rowMoves[i];
            int newCol = col + colMoves[i];

            if (newRow >= 0 && newCol >= 0 && newRow < grid.length && newCol < grid[0].length
                    && grid[newRow][newCol] == oldColor) {
                grid[newRow][newCol] = newColor;
                dfs(grid, newRow, newCol, oldColor, newColor);
            }
        }
    }
}
