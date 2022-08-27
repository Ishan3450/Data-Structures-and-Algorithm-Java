/*
 * 153. Find Minimum in Rotated Sorted Array
 * 
 * - Medium Question :) (its easy though)
 * - same question as of GeeksOfGeeks's RotationsInRotatedArray1.java file
 * - the difference is in this we have to return the minimum element of the rotated array
 * 
 * - now let's talk about approach
 * - its very easy like just get the pivot element index
 * - then get the pivot element index + 1 element of the array 
 * - and by doing this simple 2 steps we got our answer
 */

package LeetCodeQuestions;

public class Q153 {
    public int findMin(int[] nums) {
        int pivotElementIndex = getPivot(nums);
        return nums[pivotElementIndex + 1];
    }
    
    public int getPivot(int[] arr){
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
