/*
 ? What is OrderAgnostic BinarySearch
 * Is is basically binary search applied on decending arrays or decreasing arrays.

 */

public class BinarySearchOrderAgnostic {
    public static void main(String[] args){
        int[] arr = {9,7,6,4,3,1};
        int target = 1;
        System.out.println(orderAgnosticBS(arr, target));

    }

    static int orderAgnosticBS(int[] arr, int target){
        int start = 0;
        int end=  arr.length - 1;

        while(start <= end){
            int mid = start + (end - start) / 2;

            if(target < arr[mid]){
                start = mid + 1;
            } else if(target > arr[mid]){
                end = mid - 1;
            } else{
                // we found our answer
                return mid;
            }
        }
        return -1;
    }
}
