/*
 * N-Queens
 * 
 * - Solved using Backtracking
 * - Read the comments in between the code to understand the question
 * - Time Complexity: O(N!) or O(N^N) (O(N^N) as for every queen we have n choice regardless of safe position)
 *  - TC explaination:
 *  - in the first row we have all the place available so n choices
 *  - in second row we have 1 place queen in previous so we can't put queen in that row or column so n-1 choice
 *  - next row we have n-3, next n-4 till 1
 *  - so n + (n-1) + (n-2) + (n-3) + (1) so the TC is N!
 *  - NOTE: WE HAVE IGNORED THE DIAGONAL PART BECAUSE IT MAKES THE PROCESS OF TC COMPLICATED, SO TO MAKE A GENERALIZED FORMULA WE HAVE IGNORED THE DIAGONAL PART.
 *  
 * - SC: O(N^2) to store answer in the board
 */

package RecursionQuestions.Backtracking;

public class NQueens {
    public static void main(String[] args){
        int n = 1;
        boolean[][] board = new boolean[n][n];
        System.out.println(placeQueens(board, 0));
    }

    /*
     * True: Queen Places
     * False: Queen not placed
     */
    static int placeQueens(boolean[][] board, int row){
        // base condition
        if(row == board.length){ // if this condition is true it means all the queens are placed
            displayBoard(board);
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
                count += placeQueens(board, row+1);

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

    static void displayBoard(boolean[][] board){
        for(boolean[] arr: board){
            for(boolean item: arr){
                if(item){
                    System.out.print("Q ");
                } else{
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
    }
}
