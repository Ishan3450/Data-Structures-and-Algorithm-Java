/* 
 * Approach 1
    * - take the input parameters of method i.e arr and target
    * - apply binary search to the array and get the number == target or close to the target
    * - if the number is equal to the target then return that number else return the very next element of that number in the array

 */

package BinarySearch;

public class CeilingOfANumber {
    public static void main(String[] args){
        // int[] arr = {2,3,5,9,14,16,17,18};
        int[] arr = {1,2,4,5,6};

        System.out.println(ceilingOfNumber(arr, 3));
    }

    static int ceilingOfNumber(int[] arr, int target){
        int start = 0;
        int end = arr.length - 1;

        // what if the target is greater than the greatest element of the array
        if(target > arr[end]){ return -1; }


        int mid = start + (end - start) / 2;

        while(start <= end){
            //* Condition 1 
            // if(target == arr[mid]){
            //     break;
            // } else if(target > arr[mid]){
            //     start = mid + 1;
            // } else {
            //     end = mid - 1;
            // }

            // Condition 2
            if(target > arr[mid]){
                start = mid + 1;
            } else {
                end = mid - 1;
            }

            System.out.println("Start: " + start);
            System.out.println("Mid: " + mid);
            System.out.println("End: " + end);

            mid = start + (end - start) / 2;
        }

        // when the loop condition violates we have to return the larger number or equal to the target which will reside at start pointer
        return arr[start];
    }
}
