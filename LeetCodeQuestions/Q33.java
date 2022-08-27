/*
 * 33. Search in Rotated Sorted Array

 * - take the input array and target
 * - first get the pivot element of the array in mainly 4 cases to get the pivot element:
 *      - ex : array is [3,4,5,6,1,2]
 *      - if the mid element(6) is > than mid+1(1) then return mid and we found pivot element
 *      - if the mid element(6) is < than mid-1(5) then return mid - 1 element and we found pivot element
 *      - if the start element(3) is > then the mid(6) element then move the end pointer to mid-1
 *          - moving the end pointer as we found that start is greater than mid so all the element to the right side of mid will be smaller as of rotated array
 *      - else move the start pointer to mid+1
 *          - moving the start pointer as we found that start is smaller than mid so now all the element to the left side of the mid element will be small as of rotated array
 *      - through this above 4 checks we will get the pivot element of the rotated array
 * 
 * - then apply binary search on the array in two tries : 
 * 	    - though its an rotated array the 1st part will be decending array
 * 	    - and second part will be of ascending array
 *  
 * 	    - apply binary search on first half
 * 	    - if target not found in first try then do normal BS on non-decreasing part
 */
package LeetCodeQuestions;

public class Q33 {
    public static void main(String[] args) {
        // int[] arr = {4,5,6,7,0,1,2};
        int[] arr = { 3, 5, 1 };
        int target = 3;

        System.out.println(search(arr, target));
    }

    static int getPivotElement(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        int mid = start + (end - start) / 2;

        while (start <= end) {
            if (mid < end && arr[mid] > arr[mid + 1]) {
                return mid;
            }
            if (mid > start && arr[mid] < arr[mid - 1]) {
                return mid - 1;
            }

            // * below code is to deal with the arrays having duplicates
            // if all the pointers(start, end, and middle) points the elements having equal values then just skip duplicates
            if(arr[start] == arr[mid] && arr[end] == arr[mid]){
                // skip the start and end pointers
                // NOTE : what if the start and end pointers are the pivots?
                // so before skipping we must check the start and end pointers

                if(arr[start] > arr[start + 1]){
                    return start;
                }
                // else
                start ++;

                if(arr[end] < arr[end - 1]){
                    return end - 1;
                }
                // else 
                end --;

            } else if(arr[start] < arr[mid] || (arr[start] == arr[mid] && arr[mid] > arr[end])){
                start = mid + 1;
            } else{
                end = mid -1;
            }

            // ! below code is same as upper but it will not work with arrays having duplicates
            // if (arr[mid] <= arr[start]) { // start is bigger than mid
            //     end = mid - 1;
            // } else { // start is smaller than mid
            //     start = mid + 1;
            // }
        }

        return -1;
    }

    static int search(int[] nums, int target) {
        int pivot = getPivotElement(nums);

        // if pivot is -1 then we can say that the array is not rotated hence apply
        // simple binary search
        if (pivot == -1) {
            return binarySearch(nums, target, 0, nums.length - 1);
        }

        // if pivot is found we have now 2 ascending arrays to search for targets
        // case 1
        if (nums[pivot] == target) {
            return pivot;
        }

        // case 2
        if (target >= nums[0]) {
            return binarySearch(nums, target, 0, pivot - 1);
        }

        // case 3
        return binarySearch(nums, target, pivot + 1, nums.length - 1);

    }

    static int binarySearch(int[] arr, int target, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;

            // non-decreasing array
            if (target < arr[mid]) {
                end = mid - 1;
            } else if (target > arr[mid]) {
                start = mid + 1;
            } else {
                // ans found
                return mid;
            }

        }
        return -1;
    }

}
