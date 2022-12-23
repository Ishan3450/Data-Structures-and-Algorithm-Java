/*
 ! Not solved
 * Code is based on:
 * - QueueQuestions/FirstNegativeIntegerInEveryWindowOfSizeK.java
 * - QueueQuestions/MaximumElementInKSizeWindow.java
 * - QueueQuestions/MinimumElementInKsizedWindow.java
 * 
 */

package QueueQuestions;

import java.util.*;

public class SumOfMaximumAndMinimumElementOfKSizeWindow {
    public static int[] MaximumElementInWindow(int[] arr, int n, int k) {
        Deque<Integer> dq = new LinkedList<>();
        ArrayList<Integer> ans = new ArrayList<>();

        // processing the first window
        for (int i = 0; i < k; i++) {
            if (dq.isEmpty()) {
                dq.add(i);
            } else if (!dq.isEmpty() && arr[i] > arr[dq.getFirst()]) {
                dq.removeFirst();
                dq.addLast(i);
            }
        }

        // adding the initial window's answer in the answer list
        if (dq.size() > 0) {
            ans.add(arr[dq.getFirst()]);
        } else {
            ans.add(0);
        }

        // now processing rest of the windows
        for (int i = k; i < n; i++) {
            // first remove the out of the window elements and add the new elements for the
            // new window
            if (!dq.isEmpty() && i - dq.getFirst() >= k) {
                dq.removeFirst();
            }

            if (dq.isEmpty()) {
                dq.add(i);
            } else if (!dq.isEmpty() && arr[i] > arr[dq.getFirst()]){
                dq.removeFirst();
                dq.addLast(i);
            }

            if (dq.size() > 0) {
                ans.add(arr[dq.getFirst()]);
            } else {
                ans.add(0);
            }
        }

        int[] ansArr = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            ansArr[i] = ans.get(i);
        }

        return ansArr;
    }

    public static int[] MimimumElementInWindow(int[] arr, int n, int k) {
        Deque<Integer> dq = new LinkedList<>();
        Stack<Integer> st = new Stack<>();

        // obtaining the last 2 elements as the very first window
        for (int i = n - 1; i >= n - k; i--) {
            if (dq.isEmpty()) {
                dq.add(i);
            } else if (!dq.isEmpty() && arr[i] < arr[dq.getFirst()]) {
                dq.removeFirst();
                dq.addLast(i);
            }
        }

        if (dq.size() > 0) {
            st.push(arr[dq.getFirst()]);
        } else {
            st.push(0);
        }

        // now processing the rest of the windows
        for (int i = ((n - k) - 1); i >= 0; i--) {
            // remove the old window elements
            if (!dq.isEmpty() && dq.getFirst() - i >= k) {
                dq.removeLast();
            }

            // get the minimum of the curr window
            if (dq.isEmpty()) {
                dq.add(i);
            } else if (!dq.isEmpty() && arr[i] < arr[dq.getFirst()]) {
                dq.removeLast();
                dq.addFirst(i);
            }

            // add the answer
            if (dq.size() > 0) {
                st.push(arr[dq.getFirst()]);
            } else {
                st.push(0);
            }
        }

        int stackSize = st.size();
        int[] ansArr = new int[stackSize];

        for (int i = 0; i < stackSize; i++) {
            ansArr[i] = st.pop();
        }

        return ansArr;
    }

    // public static int SumOfKsubArray(int arr[], int k) {

    // }

    public static void main(String[] args) {
        int[] arr = { 2, 5, -1, 7, -3, -1, -2 };
        int n = arr.length;
        int k = 4;

        System.out.println("Maximum : " + Arrays.toString(MaximumElementInWindow(arr, n, k)));
        System.out.println("Minimum : " + Arrays.toString(MimimumElementInWindow(arr, n, k)));
    }
}
