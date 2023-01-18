/*
 * LeetCode 54
 * 
 * TC: O(NxM)
 */

import java.util.*;

public class SpiralPrintMatrix {
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int n = matrix.length, m = matrix[0].length;

        // initial indices
        int count = 0;
        int startingRow = 0, startingCol = 0;
        int endingRow = n - 1, endingCol = m - 1;

        while (count < n * m) {

            // step1: print the starting row
            for (int i = startingCol; count < n * m && i <= endingCol; i++) {
                ans.add(matrix[startingRow][i]);
                count++;
            }
            startingRow++;

            // step2: print the ending column
            for (int i = startingRow; count < n * m && i <= endingRow; i++) {
                ans.add(matrix[i][endingCol]);
                count++;
            }
            endingCol--;

            // step3: print the ending row
            for (int i = endingCol; count < n * m && i >= startingCol; i--) {
                ans.add(matrix[endingRow][i]);
                count++;
            }
            endingRow--;

            // step4: print the starting column
            for (int i = endingRow; count < n * m && i >= startingRow; i--) {
                ans.add(matrix[i][startingCol]);
                count++;
            }
            startingCol++;
        }
        return ans;
    }

    public static void main(String[] args) {
        // int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        int[][] matrix = {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};

        System.out.println(spiralOrder(matrix));
    }
}
