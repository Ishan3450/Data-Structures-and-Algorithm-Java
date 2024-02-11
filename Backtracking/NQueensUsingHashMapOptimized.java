/*
 * Optimized approach than the default one but taking some amount of space in return.
 * This approach makes the Time Complexity of the isSafe() method from LINEAR to CONSTANT.
 * We are placing the queen row size, rather than column wise, although both the ways are possible
 * 
 * In this we have used 3 hashmap
 *  - 1st is to store col number in which the queen is present if queen is found then we will put that col number in the map
 *  
 *  - Now the leftDiagonal and the rightDiagonal maps are important to understand:
 *  - for the rightDiagonal map: if we sum the (row+col) for every cell of the board will see a pattern that from a element all the right diagonal will having the same value, so if a queen is found at that place then will add in the rightDiagonal map having key (row+col) and value as true
 *  - now for the leftDiagonal the concept is same that left diagonal values will be same but the difference is in rightDiagonal we weere doing row+col but in this we have to do (n+(row-col)) or (n+(col-row)) or simply (row-col), but to prevent the negative values we are preventing the (row-col) formula.
 * 
 * SC: O(N)
 */
package Backtracking;

import java.util.HashMap;

public class NQueensUsingHashMapOptimized {
    // hashmaps to reduce the TC of isSafe() method
    static HashMap<Integer, Boolean> colMap = new HashMap<>();
    static HashMap<Integer, Boolean> leftDiagonalMap = new HashMap<>();
    static HashMap<Integer, Boolean> rightDiagonalMap = new HashMap<>();

    public static void main(String[] args) {
        solveNQueens(4);
    }

    public static void solveNQueens(int n) {
        boolean[][] board = new boolean[n][n];
        placeQueens(board, n, 0);
    }

    public static void placeQueens(boolean[][] board, int n, int row) {
        // base condition
        if (row == n) {
            printBoard(board);
            return;
        }

        // function body
        for (int col = 0; col < n; col++) {
            if (isSafe(board, n,row, col)) {
                // curr position (row,col) is safe for the queen to be placed
                board[row][col] = true;
                colMap.put(col, true);
                rightDiagonalMap.put(row + col, true);
                leftDiagonalMap.put(n + (row - col), true);

                // recursive call
                placeQueens(board, n, row + 1);

                // reverting back the changed made before the recursive call i.e. Backtracking
                board[row][col] = false;
                colMap.remove(col);
                rightDiagonalMap.remove(row + col);
                leftDiagonalMap.remove(n + (row - col));
            }
        }
    }

    public static boolean isSafe(boolean[][] board, int n, int row, int col) {
        // curr col check
        if (colMap.containsKey(col) && colMap.get(col)) {
            return false;
        }

        // left diagonal check
        if (leftDiagonalMap.containsKey(n + (row - col)) && leftDiagonalMap.get(n + (row - col))) {
            return false;
        }

        // right diagonal check
        if (rightDiagonalMap.containsKey(row + col) && rightDiagonalMap.get(row + col)) {
            return false;
        }

        return true;
    }

    public static void printBoard(boolean[][] board) {
        for (boolean[] row : board) {
            for (boolean item : row) {
                System.out.print(item ? "Q" : ".");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
    }
}
