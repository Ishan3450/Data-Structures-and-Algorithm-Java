package Backtracking;

import java.util.Arrays;

public class PrintMatrixAndPathMaze {
    public static void main(String[] args) {
        boolean[][] maze = {
                { true, true, true },
                { true, true, true },
                { true, true, true },
        };

        int[][] path = new int[maze.length][maze[0].length];

        printMatrixWithPath("", maze, 0, 0, path, 1);
    }

    static void printMatrixWithPath(String p, boolean[][] maze, int row, int col, int[][] path, int step) {
        // base condition
        if (row == maze.length - 1 && col == maze[0].length - 1) {
            // add the step
            path[row][col] = step; // adding a step because the for loop below is also a step
            // print the path
            for (int[] arr : path) {
                System.out.println(Arrays.toString(arr));
            }
            // print the processed string
            System.out.println(p);
            System.out.println();
            return;
        }

        // function body

        // considering this path in current block
        if (!maze[row][col]) {
            return;
        }

        maze[row][col] = false;
        path[row][col] = step;

        // down
        if (row < maze.length - 1) {
            printMatrixWithPath(p + "D", maze, row+1, col, path, step+1);
        }

        // right
        if (col < maze[0].length - 1) {
            printMatrixWithPath(p + "R", maze, row, col+1, path, step+1);
        }

        // up
        if (row > 0) {
            printMatrixWithPath(p + "U", maze, row-1, col, path, step+1);
        }

        // left
        if (col > 0) {
            printMatrixWithPath(p + "L", maze, row, col-1, path, step+1);
        }

        // backtracking
        // reverting the changes made in the maze array because of recursive calls
        maze[row][col] = true;
        path[row][col] = 0;
    }
}
