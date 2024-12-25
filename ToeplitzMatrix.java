public class ToeplitzMatrix {
    public boolean isToeplitzMatrix(int[][] mat) {
        int row = 0, col = mat[0].length - 1;

        while (row < mat.length && col >= 0) {
            int tRow = row + 1;
            int tCol = col + 1;

            // checking diagonal (l to r)
            while (tRow < mat.length && tCol < mat[0].length) {
                if (mat[tRow][tCol] != mat[row][col]) {
                    return false;
                }
                tRow++;
                tCol++;
            }

            if (col == 0) {
                row++;
            } else {
                col--;
            }
        }
        return true;
    }
}
