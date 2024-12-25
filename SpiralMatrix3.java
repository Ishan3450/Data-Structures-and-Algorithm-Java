public class SpiralMatrix3 {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int[][] traversal = new int[rows * cols][2];
        traversal[0][0] = rStart;
        traversal[0][1] = cStart;
        int idx = 1;

        int step = 0;
        while (idx < traversal.length) {
            // east (step incr)
            step++;
            for (int i = 1; idx < traversal.length && i <= step; i++) {
                // same row variable col
                cStart++;
                idx = addIfSafe(traversal, rStart, cStart, rows, cols, idx);
            }

            // south
            for (int i = 1; idx < traversal.length && i <= step; i++) {
                // variable row same col
                rStart++;
                idx = addIfSafe(traversal, rStart, cStart, rows, cols, idx);
            }

            // west -- rev (step incr)
            step++;
            for (int i = 1; idx < traversal.length && i <= step; i++) {
                // col variable rev same row
                cStart--;
                idx = addIfSafe(traversal, rStart, cStart, rows, cols, idx);
            }

            // north -- rev
            for (int i = 1; idx < traversal.length && i <= step; i++) {
                // row variable rev and col same
                rStart--;
                idx = addIfSafe(traversal, rStart, cStart, rows, cols, idx);
            }
        }
        return traversal;
    }

    private int addIfSafe(int[][] traversal, int currRow, int currCol, int rows, int cols, int idx) {
        if (currRow < 0 || currCol < 0 || currRow >= rows || currCol >= cols) {
            return idx;
        }
        traversal[idx][0] = currRow;
        traversal[idx][1] = currCol;
        return idx + 1;
    }
}
