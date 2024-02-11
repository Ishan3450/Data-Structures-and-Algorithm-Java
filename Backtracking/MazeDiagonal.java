package Backtracking;

public class MazeDiagonal {
    public static void main(String[] args) {
        printPath("", 3, 3);
    }

    static void printPath(String p, int row, int col) {
        // base condition
        if (row == 1 && col == 1) {
            System.out.println(p);
            return;
        }

        // function body + recursive calls
        /*
         * Shorts:
         * Di -> Diagonal Moves
         * D -> Down Moves
         * R -> Right Moves
         */

        if (row > 1 && col > 1) {
            printPath(p + "Di", row - 1, col - 1);
        }

        if (row > 1) {
            printPath(p + 'D', row - 1, col);
        }

        if (col > 1) {
            printPath(p + 'R', row, col - 1);
        }

    }
}
