/*
 * LC 37 
 * TC: O(9^(m*n))
 * m rows and n colmns 
 * for each cell we have to call 9 method calls so 9 ^ (total number of cells i.e m*n)
 * 
 * SC: O(m*n)
 */
package RecursionQuestions.Backtracking;

public class SudokuByBabbar{
    public static void main(String[] args){
        char[][] board = new char[][]{
            {'3', '.', '6', '5', '.', '8', '4', '.', '.'},
            {'5', '2', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '8', '7', '.', '.', '.', '.', '3', '1'},
            {'.', '.', '3', '.', '1', '.', '.', '8', '.'},
            {9, '.', '.', '8', '6', '3', '.', '.', '5'},
            {'.', '5', '.', '.', 9, '.', '6', '.', '.'},
            {'1', '3', '.', '.', '.', '.', '2', '5', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '7', '4'},
            {'.', '.', '5', '2', '.', '6', '3', '.', '.'}
        };

        solveSudoku(board);

        display(board);
    }

    static void display(char[][] board){
        for(char[] row: board){
            for(char element: row){
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    public static void solveSudoku(char[][] board) {
        solve(board, 9);
    }

    public static boolean solve(char[][] board, int n){
        // in this case of this solution no base case for recursion is required.

        // searching for an empty place in the board
        for(int i = 0 ; i < n; i ++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == '.'){ // empty position found at i,j cell
                    for(char c='1'; c<='9'; c++){ // trying to place 1 to 9 in that cell
                        if(isSafe(board, n, c, i, j)){
                            // placing the value c at i,j cell
                            board[i][j] = c;
                            
                            // recursive call
                            boolean aageKaSolution = solve(board, n);

                            // if aageKaSolution returns true means that we have found a solution, so no need to get another solution as in question only 1 solution exists
                            // due to this check base check is not required
                            if(aageKaSolution){ // means we have solved the sudoku
                                return true;
                            }

                            // if not solved then, backtracking
                            board[i][j] = '.';
                        }
                    }

                    // if unable to put any of the value from 1 till 9 it means previous calls have some mistake in placing the values from 1 till 9 
                    return false;
                }
            }
        }
        
        /*  
         * the code will reach here on 2 cases:
         * 1. when all the cells are filled
         * 2. as all the cells are filled the main row and col loop will simply just run and exit on the completion condition
         * So we have solved the sudoku, that's why returning true
         * This will also help in achieving aageKaSolution boolean variable up there
        */ 
        return true;
    }

    public static boolean isSafe(char[][] board, int n, char value, int currRow, int currCol){
        // curr col check
        for(int row=0; row<n; row++){
            if(board[row][currCol] == value){
                return false;
            }
        }

        // curr row check
        for(int col=0; col < n; col++){
            if(board[currRow][col] == value){
                return false;
            }
        }

        // curr 3x3 matrix check
        int sqrt = 3; // sqrt of n i.e size of the board
        int rowStart = currRow - currRow%sqrt;
        int colStart = currCol - currCol%sqrt;

        for(int row=rowStart; row < rowStart+3; row ++){
            for(int col=colStart; col < colStart+3; col ++){
                if(board[row][col] == value){
                    return false;
                }
            }
        }

        return true;
    }
}