/*
 * LC: 53 https://leetcode.com/problems/maximum-subarray/description/
 * 
 */

package Recursion;

import java.util.Arrays;

public class MaximumSubArray {
    /*
     * Method 2
     * TC: O(n)
     * SC: constant
     */
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int contigiousSubarraySum = nums[0];

        for(int i = 1 ; i < nums.length ; i ++) {
            // finding max either starts from current element or add it with the contigious sum and check
            contigiousSubarraySum = Math.max(nums[i], nums[i] + contigiousSubarraySum);
            maxSum = Math.max(maxSum, contigiousSubarraySum);
        }
        return maxSum;
    }


    /*
     * Method 1
     * TC: O(NlogN)
     * SC: O(logN)
     */
    public static int maxSubArrayy(int[] nums) {
        // base condition
        if (nums.length == 1) {
            // if only 1 element is there then we will consider it as the max element
            return nums[0];
        }

        // function body
        int mid = nums.length / 2;

        // left part max
        int left = maxSubArrayy(Arrays.copyOfRange(nums, 0, mid));

        // right part max
        int right = maxSubArrayy(Arrays.copyOfRange(nums, mid, nums.length));

        // accorss sum (maxLeftPart + maxRightPart) including mid
        int maxLeftSum, maxRightSum;
        maxLeftSum = maxRightSum = Integer.MIN_VALUE;

        int tempLeftSum, tempRightSum;
        tempLeftSum = tempRightSum = 0;

        // left part including mid
        for (int i = mid - 1; i >= 0; i--) {
            tempLeftSum += nums[i];
            maxLeftSum = tempLeftSum > maxLeftSum ? tempLeftSum : maxLeftSum;
        }

        // right part excluding mid
        for (int i = mid; i < nums.length; i++) {
            tempRightSum += nums[i];
            maxRightSum = tempRightSum > maxRightSum ? tempRightSum : maxRightSum;
        }

        int accrossSum = maxLeftSum + maxRightSum;

        return Math.max(left, Math.max(right, accrossSum));
    }

    
}
