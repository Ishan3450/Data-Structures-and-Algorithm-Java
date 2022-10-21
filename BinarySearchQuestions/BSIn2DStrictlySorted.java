/*
 ! Not Completely Solved Question
 */

package BinarySearchQuestions;

import java.util.Arrays;

public class BSIn2DStrictlySorted {
    public static void main(String[] args){
        int[][] arr = {
            {1,2,3,4},
            {5,6,7,8},
            {9,10,11,12},
            {13,14,15,16}
        };

        System.out.println(Arrays.toString(search(arr, 3)));
    }

    static int[] search(int[][] arr, int target){
        
        int row = 0; // row
        int col = arr[row].length - 1; // column

        while(row <= col || row == arr.length || col == arr.length){
            int mid = row + (col - row) / 2;
            col = arr[row].length - 1;


            if(target == arr[row][col]){
                // ans found
                return new int[]{row, col};
            }

            if(target > arr[row][col]){
                row ++;
                continue;
            }

            if(target < arr[row][0]){
                row --;
                continue;
            }

            if(target < arr[row][mid]){
                col = mid - 1;
            }else{
                row = mid + 1;
            }

            
        }
        return new int[]{-1,-1};
    }


}
