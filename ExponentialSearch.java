/*
 * FROM: 15:00 around -> course
 * Applications:
 *  - Search in an infinite array or unbounded array
 *  - Better than binary search when x is near beginning
 */

public class ExponentialSearch {
    public static int bs(int[] arr, int start, int end, int target) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                return mid;
            }

            if (arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    /* 
     * Main Part of the exponential serach
     */
    public static int exponentialSearch(int[] arr, int n, int x) {
        if (arr[0] == x) {
            return 0;
        }

        int i = 1;

        while (i < n && arr[i] <= x) {
            i <<= 1; // or i *= 2;
        }

        return bs(arr, i / 2, Math.min(i, n - 1), x);
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };

        System.out.println(exponentialSearch(arr, arr.length, 5));
    }
}
