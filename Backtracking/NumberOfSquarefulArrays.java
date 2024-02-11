/*
 * LC 996 https://leetcode.com/problems/number-of-squareful-arrays/description/
 */
package Backtracking;

import java.util.HashSet;

public class NumberOfSquarefulArrays {
    public static int count;

    public static int numSquarefulPerms(int[] nums) {
        if (nums.length < 2) {
            return 1;
        }

        permute(nums, 0);

        return count;
    }

    public static void permute(int[] nums, int idx) {
        // base condition
        if (idx == nums.length) {
            // System.out.println(Arrays.toString(nums));
            count++;
            return;
        }

        // function body using a set to prevent duplicates, you can get the idea of using the set by drawing the recursive tree in which the duplicates will have the duplication of a answer
        HashSet<Integer> set = new HashSet<>(); // here this set is only for the current scope of the recursive call not for all the calls as this set is not reference to all the call instead this is in the valid scope of the current method call

        for (int i = idx; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                continue;
            }

            swap(nums, idx, i);

            if (idx == 0 || isPerfectSquare(nums[idx], nums[idx - 1])) {
                permute(nums, idx + 1);
            }
            // reverting back the changes made before the recursive call i.e Backtracking
            swap(nums, idx, i);

            // adding the curr element to the set after the backtracking call so the
            // original element to be added will be at the correct position
            set.add(nums[i]);
        }
    }

    /*
     * Logic behind this isPerfectSquare() method:
     * - let n1 = 2 and n2 = 5 then sqrt = 2.645751311064591
     * - we are subtracting 2.645751311064591 - (int) sqrt which is 2 which is not
     * 0, means x+y is not a perfect square
     * 
     * = another example:
     * - let take n1=n2=4 then sqrt = sqrt(4+4) = 4
     * - now subtracting it with the int part which is 4 then 4-4 == 0 true so it is
     * a perfect square
     * 
     */
    public static boolean isPerfectSquare(int n1, int n2) {
        double sqrt = Math.sqrt(n1 + n2);
        return (sqrt - (int) sqrt) == 0 ? true : false;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {1, 17, 8};

        System.out.println(numSquarefulPerms(arr));

    }
}
