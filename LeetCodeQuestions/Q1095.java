/*
 ! SELF NOTE: This question is remaing for submission on LeetCode as it uses Interfaces which I don't know for now
 
 * https://leetcode.com/problems/find-in-mountain-array/
 * 
 * 1095. Find in Mountain Array - LEETCODE HARD Question
 * 
 * - first get the array
 * - then get the peak element of the array
 * - then apply binary search passing the index of peak element and start
 * - if target not found in the first try apply agnostic binary search starting from peak index to the length of the array -1
 */

package LeetCodeQuestions;

public class Q1095 {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 3, 1 };
        int target = 3;

        System.out.println(search(arr, target));

        // System.out.println(getPeakElementIndex(arr));

    }

    static int search(int[] arr, int target) {
        // getting the peak element of the array
        int peak = getPeakElementIndex(arr);

        // trying to search target in 1st part of array which is ascending array
        int firstTryAns = binarySearch(arr, target, 0, peak);

        if (firstTryAns != -1) {
            return firstTryAns;
        }

        // in case we didn't found our answer in firstTry
        // then we will find our target in second part of the array which is descending
        // array
        return orderAgnosticBS(arr, target, peak, arr.length - 1);

    }

    static int getPeakElementIndex(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] > arr[mid + 1]) {
                // we are in decreasing part of the array
                end = mid;
            } else {
                // we are in increasing part of the array
                start = mid + 1;
            }
        }

        return start;
    }

    static int binarySearch(int[] arr, int target, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (target > arr[mid]) {
                start = mid + 1;
            } else if (target < arr[mid]) {
                end = mid - 1;
            } else {
                // ans found
                return mid;
            }
        }
        return -1;
    }

    static int orderAgnosticBS(int[] arr, int target, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (target < arr[mid]) {
                start = mid + 1;
            } else if (target > arr[mid]) {
                end = mid - 1;
            } else {
                // we found our answer
                return mid;
            }
        }
        return -1;
    }

}
