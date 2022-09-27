package LeetCodeQuestions;

public class Q37 {
    public static void main(String[] args){
        char[][] board = new char[][]{
            {'5','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}
        };
        
        solveSudoku(board);

    }
    static void solveSudoku(char[][] board) {
        helper(board);
        display(board);
    }

    static boolean helper(char[][] board) {
        int row = -1;
        int col = -1;

        boolean isEmpty = true;

        // get the empty position if any
        for(int r = 0; r < board.length; r++){
            for(int c = 0; c < board.length; c++){
                if(board[r][c] == '.'){
                    row = r;
                    col = c;
                    isEmpty = false;
                    break;
                }
            }
            
            if(isEmpty == false){
                break;
            }
        }

        // checking if any position is left empty or not in the board
        if(isEmpty){
            return true; // sudoku is solved
        }

        // placing 1 to 9 numbers 
        for(int numbers = 1; numbers <= 9; numbers ++){
            if(isSafe(board, row, col, numbers)){
                board[row][col] = (char) (numbers + '0'); // coverting to char as board is in char form
                if(helper(board)){
                    return true;
                } else{
                    // backtracking: reverting back all the changes
                    board[row][col] = '.';
                }
            }
        }

        // sudoku not solved
        return false;
    }

    static boolean isSafe(char[][] board, int row, int col, int num){
        // row check
        for(int i=0; i<board.length; i++){
            if(board[row][i] == (char)(num + '0')){
                return false;
            }
        }

        // col check
        for(char[] r: board){
            if(r[col] == (char)(num + '0')){
                return false;
            }
        }

        // 3x3 box check
        int sqrt = (int)(Math.sqrt(board.length));

        int rowStart = row - row%sqrt;
        int colStart = col - col%sqrt;

        for(int r=rowStart; r<rowStart + sqrt; r++){
            for(int c=colStart; c<colStart + sqrt; c++){
                if(board[r][c] == (char)(num+'0')){
                    return false;
                }
            }
        }

        // master: else means it is safe to place the number at r,c position
        return true;
    }

    static void display(char[][] board){
        for(char[] row: board){
            for(char item: row){
                System.out.print(item + " ");
            }
            System.out.println();
        }
    }
}
