/* 
 * TC: Exponential O(4^(m*n))
 * where m is rows and n is columns
 * at each level we have 4 calls to be made up, down, left and right
 * and 4 calls made for each cell, total cells are: m*n
 * 
 * SC: O(m*n)
 * Visited array created: O(m*n) + O(m*n) = 2O(m*n)
 * ignoring 2 as constant so SC is O(m*n)
 * as the worst case is to visited all the elements of the matrix
*/

package RecursionQuestions.Backtracking;

import java.lang.StringBuilder;
import java.util.ArrayList;

public class RatInAMaze {
    public static void main(String[] args) {
        /*
         * True in matrix -> can be visited
         * False in matrix -> Obstacle at that position
         */
        boolean[][] maze = {
                { true, true, false, true },
                { true, true, false, true },
                { false, true, true, true },
                { false, false, true, true }
        };

        // edge case 1
        if (maze[0][0] == false) {
            System.out.println("No Solution Found");
            return;
        }

        System.out.println("Method simply printing all the paths: ");
        findDestination(maze, "", 0, 0);

        System.out.println("Method returning the arraylist with all the paths: ");
        System.out.println(findDestinationR(maze, "", 0, 0));
    }

    /*
     * Method with no void return type in the signature
     */
    public static void findDestination(boolean[][] maze, String s, int row, int col) {
        // base condition
        if (row == maze.length - 1 && col == maze[0].length - 1) {
            // edge case
            if (s.length() == 0) {
                System.out.println("No Solution Found");
            } else {
                System.out.println(s);
            }
            return;
        }

        // function body

        // marking the current standing position as visited
        maze[row][col] = false;

        // up call
        if (row - 1 >= 0 && maze[row - 1][col]) {
            findDestination(maze, s + 'U', row - 1, col);
        }

        // right call
        if (col + 1 < maze[0].length && maze[row][col + 1]) {
            findDestination(maze, s + 'R', row, col + 1);
        }

        // down call
        if (row + 1 < maze.length && maze[row + 1][col]) {
            findDestination(maze, s + 'D', row + 1, col);
        }

        // left call
        if (col - 1 >= 0 && maze[row][col - 1]) {
            findDestination(maze, s + 'L', row, col - 1);
        }

        // reverting back the visited changed before all the calls i.e Backtracking
        maze[row][col] = true;

    }

    /*
     * Method returning ArrayList<>
     */
    public static ArrayList<String> findDestinationR(boolean[][] maze, String s, int row, int col) {
        // base condition
        if (row == maze.length - 1 && col == maze[0].length - 1) {
            // edge case
                ArrayList<String> list = new ArrayList<>();
                list.add(s);
                return list;
        }

        // function body

        ArrayList<String> list = new ArrayList<>();
        // marking the current standing position as visited
        maze[row][col] = false;

        // up call
        if (row - 1 >= 0 && maze[row - 1][col]) {
            list.addAll(findDestinationR(maze, s + 'U', row - 1, col));
        }

        // right call
        if (col + 1 < maze[0].length && maze[row][col + 1]) {
            list.addAll(findDestinationR(maze, s + 'R', row, col + 1));
        }

        // down call
        if (row + 1 < maze.length && maze[row + 1][col]) {
            list.addAll(findDestinationR(maze, s + 'D', row + 1, col));
        }

        // left call
        if (col - 1 >= 0 && maze[row][col - 1]) {
            list.addAll(findDestinationR(maze, s + 'L', row, col - 1));
        }

        // reverting back the visited changed before all the calls i.e Backtracking
        maze[row][col] = true;

        return list;
    }
}
