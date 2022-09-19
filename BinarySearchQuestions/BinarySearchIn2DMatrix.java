/* 
    * https://www.youtube.com/watch?v=enI_KyGLYPo&list=PL9gnSGHSqcnr_DxHsP7AW9ftq0AtAyYqJ&index=18
    * NOTE : Matrix is not strictly sorted. Matrix is sorder in row and col wise manner.
*/

package BinarySearchQuestions;

import java.util.Arrays;

public class BinarySearchIn2DMatrix {
    public static void main(String[] args) {
        int[][] arr = {
                { 10, 20, 30, 40 },
                { 15, 25, 35, 45 },
                { 28, 29, 37, 49 },
                { 33, 34, 38, 50 }
        };

        int target = 33;
        System.out.println(Arrays.toString(search(arr, 33)));
    }

    static int[] search(int[][] matrix, int target) {
        int row = 0; // max row in our case will be 4
        int col = matrix.length - 1; // col also will be 4

        while(row < matrix.length && col >= 0){
            if(matrix[row][col] == target){
                return new int[] {row, col};
            }

            if(matrix[row][col] > target){
                col --;
            } else{
                row++;
            }
        }

        return new int[] { -1, -1 };
    }
}
