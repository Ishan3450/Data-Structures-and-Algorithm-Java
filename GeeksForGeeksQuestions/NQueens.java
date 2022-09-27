import java.util.ArrayList;

public class NQueens {
    public static void main(String[] args){
        System.out.println(nQueen(4));
    }

    static ArrayList<ArrayList<Integer>> nQueen(int n) {
        // code here
        ArrayList<ArrayList<Integer>> allBoards = new ArrayList<>();
        boolean[][] board = new boolean[n][n];

        placeQueens(allBoards, board, 0);
        
        return allBoards;
    }

    static void placeQueens(ArrayList<ArrayList<Integer>> allBoards, boolean[][] board, int row){
        // base condition
        if(row == board.length){
            // createBoards(allBoards, board);
            createBoards(allBoards, board);
            return;
        }

        // function body
        for(int col = 0; col < board[0].length; col++){
            if(isSafe(board, row, col)){
                board[row][col] = true;
                placeQueens(allBoards, board, row+1);
                // backtrackint: reverting back all the changes
                board[row][col] = false;
            }
        }
    }

    static boolean isSafe(boolean[][] board, int row, int col){
        // vertical row check
        for(int i=0; i<row; i++){
            if(board[i][col]){
                return false;
            }
        }

        // left diagonal check
        int left = Math.min(row, col);
        for(int i=1; i<=left; i++){
            if(board[row-i][col-i]){
                return false;
            }
        }

        // right diagonal check
        int right = Math.min(row, board.length - col - 1);
        for(int i=1; i<=right; i++){
            if(board[row-i][col+i]){
                return false;
            }
        }

        // master else
        return true;

    }

    static void createBoards(ArrayList<ArrayList<Integer>> allBoards, boolean[][] board){
        ArrayList<Integer> list = new ArrayList<>();
        for(int row=0; row<board.length; row++){
            for(int col=0; col<board[0].length; col++){
                if(board[row][col]){
                    list.add(col+1);
                }
            }
        }
        allBoards.add(list);
    }
    
}
