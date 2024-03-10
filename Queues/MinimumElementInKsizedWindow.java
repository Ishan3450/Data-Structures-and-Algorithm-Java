/*
 ! Not solved
 * **** Self implemented logic. *****
 */

package Queues;

import java.util.*;

public class MinimumElementInKsizedWindow {
    public static int[] minInKSizeWindow(int[] arr, int n, int k) {
        Deque<Integer> dq = new LinkedList<>();
        // * used stack here cause we are traversing the array from the back, so at last it will take only O(N) to get the answer
        Stack<Integer> ans = new Stack<>();

        // getting the answer of first window from the back side
        for (int i = n - 1; i >= n - k; i--) {
            // this loop will take the last two elements of the array
            if (dq.isEmpty()) {
                dq.add(i);
            } else if (!dq.isEmpty() && arr[i] < arr[dq.getFirst()]) {
                dq.removeFirst();
                dq.addLast(i);
            }
        }

        // adding the initial windows answer
        if (dq.size() > 0) {
            ans.push(arr[dq.getFirst()]);
        } else {
            ans.push(0);
        }

        // here in the initialization part n-k-1 is the starting point as the from n-1 till n-k th window is already processed
        for (int i = ((n-k)-1); i >= 0; i--) {
            /*
             * - first remove all the out of the window elements and add the new elements which resides in the current window.
             * - subtracting the first of the queue from the current iterator i becasue the index from the queue will always be bigger as we are starting from the back side of the array.
             */
            if (!dq.isEmpty() && (dq.getFirst() - i) >= k) { 
                dq.removeFirst(); // here element which is out of the window will be removed from the last as we are iterating the array from back side
            }

            if (dq.isEmpty()) {
                dq.add(i);
            } else {
                dq.removeFirst();
                dq.addLast(i);
            }

            if (dq.size() > 0) {
                ans.push(arr[dq.getFirst()]);
            } else {
                ans.push(0);
            }
        }

        int ansStackSize = ans.size();
        int[] arrAns = new int[ansStackSize];

        for(int i=0; i<ansStackSize; i++){
            arrAns[i] = ans.pop();
        }

        return arrAns;
    }

    public static void main(String[] args) {
        int[] arr = {5,2,6,3,67,8,5,34,576};
        int n = arr.length;
        int k = 4;

        System.out.println(Arrays.toString(minInKSizeWindow(arr, n, k)));
    }
}
