/*
 * Sudoku Solver
 * 
 * - To solve a sudoku:
 * 
 * 1. we have to get the empty position
 * 2. now apply any number from 1 till 9 with the sudoku's rules
 * 
 */

package Backtracking;

public class Sudoku {
    public static void main(String[] args){
        int[][] board = new int[][]{
            {3, 0, 6, 5, 0, 8, 4, 0, 0},
            {5, 2, 0, 0, 0, 0, 0, 0, 0},
            {0, 8, 7, 0, 0, 0, 0, 3, 1},
            {0, 0, 3, 0, 1, 0, 0, 8, 0},
            {9, 0, 0, 8, 6, 3, 0, 0, 5},
            {0, 5, 0, 0, 9, 0, 6, 0, 0},
            {1, 3, 0, 0, 0, 0, 2, 5, 0},
            {0, 0, 0, 0, 0, 0, 0, 7, 4},
            {0, 0, 5, 2, 0, 6, 3, 0, 0}
        };

        if(solve(board)){
            display(board);
        } else{
            System.out.println("Not a valid sudoku !!");
        }
        
    }

    static boolean solve(int[][] board){
        int n = board.length;

        int row = -1;
        int col = -1;

        boolean isEmptyLeft = true;

        // below loop is how we are replacing row and col from function arguements
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(board[i][j] == 0){
                    row = i;
                    col = j;
                    isEmptyLeft = false;  // basically isEmpty will be used to search for the current empty element position's answer
                    break;
                }
            }

            // if we found some empty element in row, break the loop
            if(isEmptyLeft == false){
                break;
            }
        }

        if(isEmptyLeft){ // if not a single position is left empty it means our sudoku is solved
            return true;
            // our sudoku is solved
        }

        // backtracking the current empty r,c position
        for(int number = 1; number <= 9; number ++){
            if(isSafe(board, row, col, number)){ // check for if it is safe to place the current number at r,c position
                board[row][col] = number;
                if(solve(board)){
                    // found the answer
                    return true;
                } else{
                    // backtracking: reverting the changes back
                    board[row][col] = 0;
                }

            }
        }

        // not able to solve the sudoku
        return false;
    }

    static boolean isSafe(int[][] board, int row, int col, int num){
        /*
         * To get that is it safe to place num at row,col we have to check:
         * 
         * 1. current row
         * 2. current col
         * 3. the current 3x3 box
         */

        // checking current row if it is safe or not to place the number
        for(int i=0; i<board.length; i++){
            if(board[row][i] == num){ // checking if number is present or not in the current row
                return false;
            }
        }

        // checking current col if it is safe or not to place the number
        for(int[] r: board){
            if(r[col] == num){ // checking row by row at col position
                return false;
            }
        }

        // Now cheking for the current 3x3 matrix:
        
        /*
         * 1st we have to get the square root of the matrix to determine the starting positions of various boxes
         * like: for 9x9 -> sqrt will be 3x3 or simply 3
        */
        int sqrt = (int) (Math.sqrt(board.length));

        // after getting the sqrt we have to get the starting position of r,c for the current box

        /*
         * We can get it like:
         * For:
         * 1. 
         * r=0, c=2
         * r = r - r%sqrt
         *   = 0 - 0%3
         * r = 0
         * 
         * c = c - c%sqrt
         *   = 2 - 2%3
         *   = 2 - 2
         * c = 0
         * 
         * 2. 
         * r=5, c=3
         * r = r - r%sqrt
         *   = 5 - 5%3
         *   = 5  - 2
         * r = 3
         * 
         * c = c - c%sqrt
         *   = 3 - 3%3
         *   = 3 - 0
         * c = 3
         */

        int rowStart = row - row%sqrt;
        int colStart = col - col%sqrt;

        for(int r=rowStart; r<rowStart + sqrt; r++){
            for(int c = colStart; c < colStart + sqrt; c++){
                if(board[r][c] == num){
                    return false;
                }
            }
        }

        // if all the above conditions are false it means it is safe to place number at r,c 
        return true;
    }

    static void display(int[][] board){
        for(int[] row: board){
            for(int element: row){
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}
