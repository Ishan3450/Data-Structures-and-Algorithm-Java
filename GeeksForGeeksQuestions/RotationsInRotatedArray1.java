// https://practice.geeksforgeeks.org/problems/rotation4723/1
/*
 * Rotation
 * 
 * - easy question
 * - passed 340 testcases in 1st attemp ;)
 * - get the pivot element of the array
 * - return the index of the pivot element + 1
 */
package GeeksForGeeksQuestions;

public class RotationsInRotatedArray1 {
    int findKRotation(int arr[], int n) {
        // code here
        return getPivot(arr) + 1;
    }
    
    static int getPivot(int[] arr){
        int start= 0;
        int end = arr.length - 1;


        while(start <= end){
            int mid = start + (end - start) / 2;

            // case 1
            if(mid < end && arr[mid] > arr[mid + 1]){
                return mid;
            }

            // case 2
            if(mid > start && arr[mid] < arr[mid - 1]){
                return mid - 1;
            }

            // case 3
            if(arr[start] > arr[mid]){
                end = mid - 1;
            } else{
                start = start + 1;
            }

        }

        return -1;
    }
}
