/*
 * https://www.geeksforgeeks.org/sum-minimum-maximum-elements-subarrays-size-k/
 */

package Queues;

import java.util.*;

public class SumOfMinimumAndMaximumSubarrayOfK {

    public static int solve(int[] arr, int k) {
        int n = arr.length;
        int ans = 0;

        Deque<Integer> max = new LinkedList<>();
        Deque<Integer> min = new LinkedList<>();

        // first window
        for (int i = 0; i < k; i++) {

            // max queue
            while (!max.isEmpty() && arr[max.getLast()] <= arr[i]) {
                max.removeLast();
            }

            // min queue
            while (!min.isEmpty() && arr[min.getLast()] >= arr[i]) {
                min.removeLast();
            }

            max.addLast(i);
            min.addLast(i);
        }

        ans += arr[max.getFirst()] + arr[min.getFirst()];

        // processing rest of the windows
        for (int i = k; i < n; i++) {
            // remove the out of window elements
            while (!min.isEmpty() && i - min.getFirst() >= k) {
                min.removeFirst();
            }
            while (!max.isEmpty() && i - max.getFirst() >= k) {
                max.removeFirst();
            }

            // consider min and max of curr window
            // max queue
            while (!max.isEmpty() && arr[max.getLast()] <= arr[i]) {
                max.removeLast();
            }

            // min queue
            while (!min.isEmpty() && arr[min.getLast()] >= arr[i]) {
                min.removeLast();
            }

            max.addLast(i);
            min.addLast(i);

            // add the sum of min and max to the ans var
            ans += arr[max.getFirst()] + arr[min.getFirst()];
        }

        return ans;
    }

    public static void main(String[] args) {
        int arr[] = { 2, 5, -1, 7, -3, -1, -2 };
        int k = 4;
        System.out.println(solve(arr, k));
    }
}
