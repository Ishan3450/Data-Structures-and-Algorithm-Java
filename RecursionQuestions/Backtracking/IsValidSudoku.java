/*
 * Is Valid Sudoku
 * 
 * - we have check whether the current given matrix is valid or not 
 * - we don't have to fill or anything like that we have to just check the validity of current given congiguration
 */

package RecursionQuestions.Backtracking;

public class IsValidSudoku {

    public static void main(String[] args) {
        int[][] board = new int[][] {
            {3, 0, 6, 5, 0, 8, 4, 0, 0},
            {5, 2, 0, 0, 0, 0, 0, 0, 0},
            {0, 8, 7, 0, 0, 0, 0, 3, 1},
            {0, 0, 3, 0, 1, 0, 0, 8, 0},
            {9, 0, 0, 8, 6, 3, 0, 0, 5},
            {0, 5, 0, 0, 9, 0, 6, 0, 0},
            {1, 3, 0, 0, 0, 0, 2, 5, 0},
            {0, 0, 0, 0, 0, 0, 0, 7, 4},
            {0, 0, 5, 2, 0, 6, 3, 0, 0},
        };

        System.out.println(isItSudoku(board));

    }

    public static boolean isItSudoku(int matrix[][]) {
        // Write your code here.
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] != 0 && !isValid(matrix, i, j, matrix[i][j])) {
                    return false;
                }
            }
        }

        return true;
    }

    static boolean isValid(int[][] matrix, int row, int col, int target) {
        // row check
        for (int i = 0; i < matrix.length; i++) {
            if (i != col && matrix[row][i] == target) {
                return false;
            }
        }

        // col check
        for (int i = 0; i < matrix.length; i++) {
            if (i != row && matrix[i][col] == target) {
                return false;
            }
        }

        // 3x3 box check
        int sqrt = (int) (Math.sqrt(matrix.length));

        int rowStart = row - row % sqrt;
        int colStart = col - col % sqrt;

        for (int i = rowStart; i < rowStart + sqrt; i++) {
            for (int j = colStart; j < colStart + sqrt; j++) {
                if (i != row && j != col && matrix[i][j] == target) {
                    return false;
                }
            }
        }

        // else
        return true;
    }
}
