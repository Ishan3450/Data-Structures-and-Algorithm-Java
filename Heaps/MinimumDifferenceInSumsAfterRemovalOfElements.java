package Heaps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class MinimumDifferenceInSumsAfterRemovalOfElements {
    public long minimumDifference(int[] nums) {
        int n = nums.length / 3;

        long sum = 0;

        // Computing Part A
        PriorityQueue<Long> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        ArrayList<Long> prefixSum = new ArrayList<>();

        // initial n size heap
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            maxHeap.add((long) nums[i]);

            if (i < n - 1) {
                prefixSum.add(-1L);
            }
        }

        prefixSum.add(sum);

        // processing rest of array elements for part A
        for (int i = n; i < nums.length; i++) {
            sum += nums[i];
            maxHeap.add((long) nums[i]);

            sum -= maxHeap.remove();
            prefixSum.add((long) sum);
        }

        // Computing Part B
        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        ArrayList<Long> suffixSum = new ArrayList<>();
        sum = 0;

        // initial: length-1 to >= length-n
        for (int i = nums.length - 1; i >= nums.length - n; i--) {
            sum += nums[i];
            minHeap.add((long) nums[i]);

            if (i > nums.length - n) {
                suffixSum.add(-1L);
            }
        }

        suffixSum.add(sum);

        // after: length-n-1 to 0
        for (int i = nums.length - n - 1; i >= 0; i--) {
            sum += nums[i];
            minHeap.add((long) nums[i]);

            sum -= minHeap.remove();
            suffixSum.add(sum);
        }

        Collections.reverse(suffixSum);

        int idx = 0;

        long minDiff = Long.MAX_VALUE;

        while (idx < prefixSum.size() && idx + 1 < suffixSum.size()) {
            long prefixElem = prefixSum.get(idx);
            long suffixElem = suffixSum.get(idx + 1);

            idx++;

            if (prefixElem == -1 || suffixElem == -1) {
                continue;
            }

            minDiff = Math.min(minDiff, prefixElem - suffixElem);
        }

        return minDiff;
    }

    // - n = nums.length / 3
    // - to remove n elements from nums such that A - B is minimum possible
    // - Where we have to get A minimum possible and B maximum possible
    // - For A we make a min heap and traverse the array from left to right
    // - For B we will make a max heap and traverse the array from right to left
    // - Traversing A from ltor and b from rtol because let's take a idx 3, so for A
    // it will contain min possible sum from 0 till 3 and for B we will take idx 4
    // because we cannot use the idx 3 element multiple times.

}
