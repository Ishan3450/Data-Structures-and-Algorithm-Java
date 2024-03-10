/* 
 * LC: https://leetcode.com/problems/sliding-window-maximum/description/
 * GFG: https://practice.geeksforgeeks.org/problems/deee0e8cf9910e7219f663c18d6d640ea0b87f87/1
 */

package Queues;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new LinkedList<>();
        List<Integer> list = new ArrayList<>();

        // first window of size k
        for (int i = 0; i < k; i++) {
            while (!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) {
                dq.removeLast();
            }

            dq.addLast(i);
        }

        // ans of the first window
        list.add(nums[dq.peekFirst()]);

        // processing rest of the windows
        for (int i = k; i < nums.length; i++) {
            // remove the out of the window elements
            while (!dq.isEmpty() && i - dq.getFirst() >= k) {
                dq.removeFirst();
            }

            // remove elements smaller then the curr elements
            while (!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) {
                dq.removeLast();
            }

            dq.addLast(i);

            // add ans of curr window in the list
            list.add(nums[dq.getFirst()]);
        }

        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }

        return ans;
    }
}
