/*
 * Problem : Apply binary search on an array having size is infiniteee.
 * 
 * - take the array
 * - start a box or a chunk of points with start and end
 * - if we found the target in between that range then apply binary search on that chunk
 * - else move to next chunk of points having size double than the previous chunk of points
 */

package BinarySearchQuestions;

public class InfiniteArray {
    public static void main(String[] args) {
        int[] arr = { 3, 5, 7, 9, 10, 90,
                100, 130, 140, 160, 170 };
        int target = 9;
        System.out.println(ans(arr, target));
    }

    // function to double the size of chunk
    static int ans(int[] arr, int target) {
        // initially we will start with the 0 and 1
        int start = 0;
        int end = 1;

        // if target is greater than the end of the chunk then move to next chunk having
        // double size
        while (target > arr[end]) {
            int nextStart = end + 1;

            // end = previous end + (sizeOfBox) * 2;
            end = end + (end - start + 1) * 2; // adding + 1 in the sizeOfBox because of we are working on array (index things)
            start = nextStart;
        }

        // at this point we will have a range where the target belongs so now its time to apply the binary search
        return binarySearch(arr, target, start, end);
    }

    static int binarySearch(int[] arr, int target, int start, int end) {
        int mid = start + (end - start) / 2;

        while (start <= end) {
            if (target < arr[mid]) {
                end = mid - 1;
            } else if (target > arr[mid]) {
                start = mid + 1;
            } else {
                // ans found
                return mid;
            }

            mid = start + (end - start) / 2;
        }
        return -1;
    }

}
