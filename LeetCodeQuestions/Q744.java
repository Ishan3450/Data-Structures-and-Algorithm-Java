/*
 * 744. Find Smallest Letter Greater Than Target
 * 
 * - get the target and the array from the method arguement
 * - apply binary search and return the element which is greater than or equal to the target
 *  - also keep in mid the wrap around feature
 */

package LeetCodeQuestions;

public class Q744 {
    public static void main(String[] args) {
        char[] arr = { 'c', 'f', 'j' };
        char target = 'c';
        System.out.println(ceilingOfNumber(arr, target));
    }

    static char ceilingOfNumber(char[] arr, char target) {
        int start = 0;
        int end = arr.length - 1;

        // in the question they have mentioned the wrap around feature which is like if the target is greater than or equal to the greatest char of the array then return the first index of the array
        if (target >= arr[end]) {
            return arr[start];
        }

        int mid = start + (end - start) / 2;

        while (start <= end) {
            if (target >= arr[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }

            mid = start + (end - start) / 2;
        }

        // when the loop condition violates we have to return the larger number or equal
        // to the target which will reside at start pointer
        return arr[start];
    }
}