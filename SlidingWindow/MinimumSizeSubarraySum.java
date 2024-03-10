package SlidingWindow;

public class MinimumSizeSubarraySum {
    // * VARIABLE SIZE SLIDING WINDOW APPROACH
    public int minSubArrayLen(int target, int[] nums) {
        int i = 0;
        int j = 0;

        int sum = 0;
        int minLength = Integer.MAX_VALUE;

        while (j < nums.length) {
            sum += nums[j];

            while (sum >= target) {
                minLength = Math.min(minLength, j - i + 1);
                sum -= nums[i];
                i++;
            }
            j++;
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}
