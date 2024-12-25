/*
 * Selection Sort
 * 
 * - in selection sort there will be 2 things needed
 * - 1 is to get the max element of the array
 * - 2 then swap the max element with the the last index element
 * - the loop will run from 0 to the length of the array
 * - and there are 2 methods :
 *      - 1 is to get the maximum element from the array which takes 2 arguement
 *          Args : 1 is the array itself, 2nd is the end position which will be depending to the loop variable(i) : arr.length - i
 *      - 2 is to swap the maxElement Index with the last element of the arary
 *          Args: 1 is the array, 2nd is the index1, 3rd is the index2
 *              : index1 and index2 is the swapping positions index1 will be the maxElementIndex and index2 will be the last index like : arr.length - i - 1
 * 
 */

import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args){
        int[] arr = {1,2};

        selectionSort(arr);
    }

    static void selectionSort(int[] arr){

        for(int i = 0; i<arr.length; i++){
            int max = getMax(arr, arr.length - i);

            swap(arr, max, arr.length - i - 1);
        }

        System.out.println(Arrays.toString(arr));
    }

    static int getMax(int[] arr, int endPos){
        int max = 0;

        for(int i=0; i<endPos; i++){
            if(arr[i] > arr[max]){
                max = i;
            }
        }
        return max;
    }

    static void swap(int[] arr, int i1, int i2){
        int temp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = temp;
    }
    
}
