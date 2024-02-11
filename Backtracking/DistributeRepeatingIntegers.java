/*
 * LC 1655. Distribute Repeating Integers 
 * https://leetcode.com/problems/distribute-repeating-integers/description/
 * TC: O(2^N)
 * SC: O(N)
 */
package Backtracking;

import java.util.Arrays;
import java.util.HashMap;

public class DistributeRepeatingIntegers {
    public static void main(String[] args) {
        int[] nums = {1,1,2,2,3,3,4,4,5,5,6,6,7,7,8,8,9,9,10,10,11,11,12,12,13,13,14,14,15,15,16,16,17,17,18,18,19,19,20,20,21,21,22,22,23,23,24,24,25,25,26,26,27,27,28,28,29,29,30,30,31,31,32,32,33,33,34,34,35,35,36,36,37,37,38,38,39,39,40,40,41,41,42,42,43,43,44,44,45,45,46,46,47,47,48,48,49,49,50,50};
        int[] quantity = {2,2,2,2,2,2,2,2,2,3};

        System.out.println(canDistribute(nums, quantity));
    }

    public static boolean canDistribute(int[] nums, int[] quantity) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int elem : nums) {
            map.put(elem, map.getOrDefault(elem, 0) + 1);
        }
        int[] count = new int[map.size()];
        int idx = 0;

        for (int value : map.values()) {
            count[idx++] = value;
        }

        // * passing currCustomer as the very last element index of the quantity array,
        // because if we start from bigger values and if that bigger value is unable to
        // fulfill the quantity value then rest of the left side values will definately
        // unable to do so, so no further call will be made and the code will be MINOR
        // MORE OPTIMIZED :)
        Arrays.sort(quantity);
        return helper(count, quantity, quantity.length - 1);
    }

    public static boolean helper(int[] count, int[] quantity, int currCustomer) {
        // base condition
        if (currCustomer < 0) {
            return true;
        }

        // function body
        for (int j = 0; j < count.length; j++) {
            if (quantity[currCustomer] <= count[j]) {
                count[j] -= quantity[currCustomer];

                // recursive call
                if (helper(count, quantity, currCustomer - 1)) {
                    return true;
                }

                // backtracking
                count[j] += quantity[currCustomer];
            }
        }
        return false;
    }
}
