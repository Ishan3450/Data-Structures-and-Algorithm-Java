package Backtracking;

public class Maze {
    public static void main(String[] args){
        System.out.println(countWays(3,3));
    }

    static int countWays(int row, int col){
        /*
         * To reach to the target:
         * 
         * - A person can move only right and down side
         * - so we will return a count when either row or col is 1 as of only one way is remaining either down or right sides
         */
    
        // base condition
        if(row == 1 || col == 1){
            return 1;
        }

        // function body

        int moveDown = countWays(row-1, col);
        int moveRight = countWays(row, col-1);

        // Use this logs to understand and also do the recursion tree alongside to grasp all the things in better way
        // System.out.println("(" + row + " , " + col + ")");
        // System.out.println("Left Part: " + moveDown);
        // System.out.println("Right Part: " + moveRight);

        return moveDown + moveRight;
    }
}
