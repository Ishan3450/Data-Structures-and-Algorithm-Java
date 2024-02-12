package DynamicProgramming;

import java.util.Arrays;

public class MinimumSwapsToMakeArrayIncreasing {
    public int minSwap(int[] nums1, int[] nums2) {
        // int ans = recursive(nums1, nums2, 1, false);
        int[][] dp = new int[nums1.length][2];
        for (int[] row : dp)
            Arrays.fill(row, -1);

        // int ans = recursive(nums1, nums2, 1, false);
        int ans = memoization(nums1, nums2, 0, false, -1, -1, dp);
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    // tabulation remaining

    // memoization
    public int memoization(int[] nums1, int[] nums2, int idx, boolean swapped, int prev1, int prev2, int[][] dp) {
        // base condition
        if (idx >= nums1.length) {
            return 0;
        }

        if (dp[idx][swapped ? 1 : 0] != -1) {
            return dp[idx][swapped ? 1 : 0];
        }

        // function body

        // no swap
        int noSwap = Integer.MAX_VALUE;
        if (nums1[idx] > prev1 && nums2[idx] > prev2) {
            noSwap = memoization(nums1, nums2, idx + 1, false, nums1[idx], nums2[idx], dp);
        }

        // swap
        int swap = Integer.MAX_VALUE;
        if (nums1[idx] > prev2 && nums2[idx] > prev1) {
            swap = 1 + memoization(nums1, nums2, idx + 1, true, nums2[idx], nums1[idx], dp);
        }

        dp[idx][swapped ? 1 : 0] = Math.min(swap, noSwap);
        return dp[idx][swapped ? 1 : 0];
    }

    // recursive
    public int recursive(int[] nums1, int[] nums2, int idx, boolean swapped) {
        // base condition
        if (idx >= nums1.length) {
            return 0;
        }

        // function body
        int prev1 = nums1[idx - 1];
        int prev2 = nums2[idx - 1];

        if (swapped) {
            int temp = prev1;
            prev1 = prev2;
            prev2 = temp;
        }

        // no swap
        int noSwap = Integer.MAX_VALUE;
        if (nums1[idx] > prev1 && nums2[idx] > prev2) {
            noSwap = recursive(nums1, nums2, idx + 1, false);
        }

        // swap
        int swap = Integer.MAX_VALUE;
        if (nums1[idx] > prev2 && nums2[idx] > prev1) {
            swap = 1 + recursive(nums1, nums2, idx + 1, true);
        }

        return Math.min(swap, noSwap);
    }
}
