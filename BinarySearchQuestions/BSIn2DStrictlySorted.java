/*
 ! Not Completely Solved Question
 */

package BinarySearchQuestions;

import java.util.Arrays;

public class BSIn2DStrictlySorted {
    public static void main(String[] args){
        int[][] arr ={
            {1,2,3,4},
            {5,6,7,8},
            {9,10,11,12},
            {13,14,15,16}
        };

        System.out.println(Arrays.toString(search(arr, 3)));
    }

    static int[] search(int[][] arr, int target){
        
        int start = 0; // row
        int end = arr[start].length - 1; // column

        while(start <= end || start == arr.length || end == arr.length){
            int mid = start + (end - start) / 2;
            end = arr[start].length - 1;


            if(target == arr[start][end]){
                // ans found
                return new int[]{start, end};
            }

            if(target > arr[start][end]){
                start ++;
                continue;
            }

            if(target < arr[start][0]){
                start --;
                continue;
            }

            if(target < arr[start][mid]){
                end = mid - 1;
            }else{
                start = mid + 1;
            }

            
        }
        return new int[]{-1,-1};
    }


}
