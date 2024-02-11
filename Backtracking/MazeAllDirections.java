/*
 * Solved using backtracking
 */

package Backtracking;

public class MazeAllDirections {
    public static void main(String[] args) {
        boolean[][] maze = {
                { true, true, true },
                { true, true, true },
                { true, true, true },
        };

        mazeWithObstacles("", maze, 0, 0);
    }

    static void mazeWithObstacles(String p, boolean[][] maze, int row, int col) {
        // base condition
        if (row == maze.length - 1 && col == maze[0].length - 1) {
            System.out.println(p);
            return;
        }

        // function body

        if (!maze[row][col]) { // checking for obstacle
            // if current position is obstacle then stop the recrusion for current call
            return;
        }

        // considering this path in my block
        maze[row][col] = false;

        if (row < maze.length - 1) {
            mazeWithObstacles(p + "D", maze, row + 1, col);
        }

        if (col < maze[0].length - 1) {
            mazeWithObstacles(p + "R", maze, row, col + 1);
        }

        if (row > 0) {
            mazeWithObstacles(p + "U", maze, row - 1, col);
        }

        if (col > 0) {
            mazeWithObstacles(p + "L", maze, row, col - 1);
        }

        // this is the point where all the recursion calls exits or comes out
        // so undoing or reverting back the changes that were made in above recursion
        // calls i.e Backtracking
        maze[row][col] = true;
    }
}
