/*
 * Iterative:
 *  - TC: O(log n)
 *  - SC: O(1)
 * 
 * Recursive:
 *  - TC: O(log n)
 *  - SC: O(log n)
 */
public class BinarySearch {
    public static void main(String[] args){
        int[] arr = {1,2,3,4,5};
        int target = 3;

        System.out.println(binarySearch(arr, target));
    }

    static int binarySearch(int[] arr, int target){
        int start = 0;
        int end = arr.length - 1;

        int mid = start + (end - start) / 2; // this expression is basically to prevent the error of integer limit

        while(start <= end){

            if(target < arr[mid]){
                end = mid - 1;
            } else if(target > arr[mid]){
                start = mid + 1;
            } else{
                return mid;
            }

            mid = start + (end - start) / 2;
        }

        return -1;
    }
}
