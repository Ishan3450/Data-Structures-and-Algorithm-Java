/*
 * Obstacles: 
 * false -> obstacle
 */

package Backtracking;

import java.util.ArrayList;

public class MazeWithObstacles {
    public static void main(String[] args){
        boolean[][] maze = {
            {true, true, true},
            {true, false, true},
            {true, true, true},
        };

        mazeWithObstacles("", maze, 0, 0);

        System.out.println(mazeWithObstaclesList("", maze, 0, 0));

    }

    static void mazeWithObstacles(String p, boolean[][] maze, int row, int col){
        // base condition
        if(row == maze.length-1 && col == maze[0].length - 1){
            System.out.println(p);
            return;
        }

        // function body

        if(!maze[row][col]){ // checking for obstacle
            // if current position is obstacle then stop the recrusion for current call
            return;
        }

        if(row < maze.length - 1){
            mazeWithObstacles(p + "D", maze, row+1, col);
        }

        if(col < maze[0].length - 1){
            mazeWithObstacles(p + "R", maze, row, col+1);
        }
    }

    static ArrayList<String> mazeWithObstaclesList(String p, boolean[][] maze, int row, int col){
        // base condition
        if(row == maze.length-1 && col == maze[0].length - 1){
            ArrayList<String> ans = new ArrayList<>();
            ans.add(p);
            return ans;
        }

        // function body
        ArrayList<String> list = new ArrayList<>();

        if(!maze[row][col]){ // checking for obstacle
            // if current position is obstacle then stop the recrusion for current call
            return list;
        }

        if(row < maze.length - 1){
            list.addAll(mazeWithObstaclesList(p + "D", maze, row+1, col));
        }

        if(col < maze[0].length - 1){
            list.addAll(mazeWithObstaclesList(p + "R", maze, row, col+1));
        }

        return list;
    }

}
