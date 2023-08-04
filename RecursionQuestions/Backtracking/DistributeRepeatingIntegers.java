/*
 * LC 1655. Distribute Repeating Integers 
 * https://leetcode.com/problems/distribute-repeating-integers/description/
 * TC: O(2^N)
 * SC: O(N)
 */
package RecursionQuestions.Backtracking;

import java.util.Arrays;
import java.util.HashMap;

public class DistributeRepeatingIntegers {
    public boolean canDistribute(int[] nums, int[] quantity) {
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

    public boolean helper(int[] count, int[] quantity, int currCustomer) {
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
