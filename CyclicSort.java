/*
 * Cyclic Sort
 * 
 * - NOTE: Whenever in question (1 to n) or (0 to n) range is given immediately apply Cyclic sort.
 * - In cyclic sort the index of the elements of array is values it self.
 * - Like, 
 *      - for 5 : 0-based index will be 5 and 1-based index will be 4.
 *      - for 0 : 0-based index will be 0 and 1-based will not be there as range 1 to n is given but the index will be -1.
 */

import java.util.Arrays;

public class CyclicSort {
    public static void main(String[] args){
        int[] arr = {5,4,3,2,1}; // worst case input

        cyclicSort(arr);
    }

    static void cyclicSort(int[] arr){
        int i = 0;

        while(i < arr.length){
            int correctIndex = arr[i] - 1;

            if(arr[i] != arr[correctIndex]){
                // swap
                swap(arr, i, correctIndex);
            } else{
                // move forward
                i++;
            }
        }

        System.out.println(Arrays.toString(arr));
    }

    static void swap(int[] arr, int i, int correctIndex){
        int temp = arr[i];
        arr[i] = arr[correctIndex];
        arr[correctIndex] = temp;
    }
}
