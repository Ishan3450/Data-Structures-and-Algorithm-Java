/*
 * 26. Remove Duplicates from Sorted Array
 * 
 * 
 */
package LeetCodeQuestions;

import java.util.Arrays;

public class Q26 {
    public static void main(String[] args) {
        int[] arr = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
        // int[] arr = { 1, 1, 2 };

        System.out.println(removeDuplicates(arr));
    }

    static int removeDuplicates(int[] nums) {
        int i = 0;
        int swappedCount = 1;

        for (int j = 1; j < nums.length; j++) {
            if (nums[i] == nums[j]) {
                j++;
            } else {
                i++;
                swap(nums, i, j);
                swappedCount++;
                j++;
            }
        }
        System.out.println(Arrays.toString(nums));
        return swappedCount;
    }

    static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
