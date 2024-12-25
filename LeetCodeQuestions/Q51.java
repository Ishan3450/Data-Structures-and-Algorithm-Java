/*
 * 51. N-Queens
 * LeetCode Hard Question
 */

package LeetCodeQuestions;

import java.util.ArrayList;
import java.util.List;

public class Q51 {
    public static void main(String[] args){
        System.out.println(solveNQueens(4));
    }

    static List<List<String>> solveNQueens(int n) {
        List<List<String>> mainAns = new ArrayList<>();
        boolean[][] board = new boolean[n][n];
        placeQueens(mainAns, board, 0);

        return mainAns;
    }

    /*
     * True: Queen Places
     * False: Queen not placed
     */
    static int placeQueens(List<List<String>> mainAns, boolean[][] board, int row){
        // base condition
        if(row == board.length){ // if this condition is true it means all the queens are placed
            displayBoard(mainAns, board);
            System.out.println();
            return 1; // returning 1 for count purpose
        }

        // function body
        int count = 0;

        // now trying to place all the queens in possible manner
        for(int col=0; col<board.length; col++){
            // checking if it is safe or not to place the queen at the current (row, col) position
            if(isSafe(board, row, col)){ 
                // if it is safe then placee the queen
                board[row][col] = true;
                count += placeQueens(mainAns, board, row+1);

                // backtracking: reverting back
                board[row][col] = false;
            }
        }

        return count;
    }

    static boolean isSafe(boolean[][] board, int row, int col){
        /*
         * To check wheter the curret (r,c) place is safe to place a queen or not, we have to check in three directions or condition:
         * 
         * 1. from 0 till the current row (vertical row)
         * 2. left diagonal
         * 3. right diagonal
         * 
        */

        // vertical row
        for(int i=0; i<row; i++){
            // cheking if there is already a queen placed or not
            if(board[i][col]){
                // if true, it means there is already a queen placed, so it is not possible to place queen at this row
                return false;
            }
        }

        // left diagonal
        int left = Math.min(row, col); // we have to go till the min(row, col) elements
        for(int i=1; i<=left; i++){
            // checking for each diagonal at left side, if it is possible to place a new queen or not
            if(board[row-i][col-i]){
                // if this condition is true, it means there is already a queen up there in left diagonal, so we can't place a new queen at curr position
                return false;
            }
        }

        // right diagonal
        int right = Math.min(row, board.length - col - 1); // we have to goo till the min of the elements at left side of current position and element at the board.length - col - i which is right side of the current position
        for(int i=1; i<=right; i++){
            // checking for each diagonal at right side, if it is possible to place a new queen or not
            if(board[row-i][col+i]){
                // if this condition is true, it means there is already a queen right side up.
                return false;
            }
        }

        
        /*
         * If all the above checks :
         * 
         * 1. Vertical row
         * 2. Left Diagonal
         * 3. Right Diagonal
         * 
         * are false it means it is possible to place our queen at the current (row, col) position,
         * so it is safe to place the queen
         */
        return true;
    }

    static void displayBoard(List<List<String>> mainAns, boolean[][] board){
        ArrayList<String> track = new ArrayList<>();
        for(boolean[] arr: board){
            String s = new String();
            for(boolean item: arr){
                if(item){
                    s += "Q";
                } else{
                    s += ".";
                }
            }
            track.add(s);
        }
        mainAns.add(track);
    }
}