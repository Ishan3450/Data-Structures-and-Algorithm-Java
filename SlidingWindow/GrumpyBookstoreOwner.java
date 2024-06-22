package SlidingWindow;

import java.util.LinkedList;
import java.util.Queue;

public class GrumpyBookstoreOwner {
    /*
     * Approach:
     * 
     * 1. Will use sliding window approach for getting the max possible minutes size
     * window which will contain unsatisfied customers
     * 2. After that will simply add unsatisfied customers with the satisfied ones
     */
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        Queue<Integer> q = new LinkedList<>(); // will track grumpy indices only
        int maxSum = 0;
        int windowSum = 0;

        // processing initial window of size minutes
        for (int i = 0; i < minutes; i++) {
            if (grumpy[i] == 1) {
                q.add(i);
                windowSum += customers[i];
            }
        }
        maxSum = windowSum;

        // processing rest of the window of size minutes
        for (int i = minutes; i < customers.length; i++) {
            // removing out of window element
            if (!q.isEmpty() && i - q.peek() >= minutes) {
                windowSum -= customers[q.remove()];
            }

            if (grumpy[i] == 0) {
                continue;
            }

            // adding curr window element
            q.add(i);
            windowSum += customers[i];

            // updating the max sum (if possible)
            if (windowSum > maxSum) {
                maxSum = windowSum;
            }
        }

        // now we got the max window of size minutes in which the shopkeeper will keep
        // the customers happy despite being grumpy, and then counting rest of the
        // customers which were satisfied when shopkeeper was not grumpy

        int satisfiedCustomers = maxSum;

        for (int i = 0; i < grumpy.length; i++) {
            if (grumpy[i] == 0) {
                satisfiedCustomers += customers[i];
            }
        }

        return satisfiedCustomers;
    }
}