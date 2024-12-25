/*
 ! Do revise in the future
 */

package Arrays;

public class RotatedBinarySearch {
    public static void main(String[] args){
        int[] arr = {5,6,7,1,2,3,4};
        // int[] arr = {5,6,7,8,9,1,2,3,4};
        int target = 6;

        System.out.println(search(arr,target,0, arr.length - 1));
    }

    static int search(int[] arr, int target, int start, int end){
        // base condition
        if(start > end){
            return -1;
        }

        // function body + recursive condition
        int mid = start + (end - start ) / 2;

        if(arr[mid] == target){
            return mid;
        }

        // 1st checking if the array from start till mid is sorted or not
        if(arr[start] <= arr[mid]){
            // array till mid is sorted

            // now checking if the target lies in the range from start till mid
            if(target >= arr[start] && target <= arr[mid]){
                // yes, target lies in the range till mid
                return search(arr, target, start, mid-1);
            } else{
                return search(arr, target, mid+1, end);
            }
        }

        // 2ndly checking if the target lies from mid till end
        if(target >= arr[mid] && target <= arr[end]){
            return search(arr, target, mid+1, end);
        } 
        
        return search(arr, target, start, mid-1);
    }

}
