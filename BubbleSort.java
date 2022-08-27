/*
 * Bubble Sort
 * 
 * - in bubble sort we will check for the adjacent values 
 * - ex : arr = {1,3,4,2,5}
 * - in first j will be at index 1 and we have to check for j-1 (if j-1 > j) {swap j and j - 1}
 * - we will need 2 loops 1 for i and 2nd for j
 * - in each pass the value will reach at its original value according to the ans
 * - so we will run arr.length - 1 passes to sort the array
 * - the first loop for i will be from 0 to the length of the array
 * - the second loop is for j will be from 1 to the lengthOfTheArray - i(i stands for pass)
 */

 import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args){
        int[] arr = {5,4,3,2,1};

        bubbleSort(arr);

        System.out.println(Arrays.toString(arr));
    }

    static void bubbleSort(int[] arr){
        boolean isSwapped = false;

        for(int i = 0; i<arr.length; i++){
            isSwapped = false;

            for(int j = 1; j < arr.length - i; j++){
                if(arr[j-1] > arr[j]){
                    // swap
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                    // telling that swapping took place
                    isSwapped = true;
                }
            }

            // checking is the swapping took place or not
            // if not it means the array is already sorted
            if(!isSwapped){
                break;
            }
        }
    }
}
