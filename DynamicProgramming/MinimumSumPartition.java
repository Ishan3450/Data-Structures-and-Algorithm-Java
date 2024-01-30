package DynamicProgramming;

public class MinimumSumPartition {
    public int minDifference(int nums[], int b) {
        int n = nums.length / 2;
        int sum = 0;
        for (int val : nums)
            sum += val;

        boolean[][] dp = new boolean[nums.length][Math.abs(sum + 1)];
        bottomUpTabulation(nums, sum, dp);

        int minDiff = Integer.MAX_VALUE;

        for (int i = 0; i <= sum; i++) {
            if (dp[b - 1][i]) {
                int other = sum - i;

                if (dp[b - 1][other]) {
                    minDiff = Math.min(minDiff, Math.abs(i - other));
                }
            }
        }

        return minDiff;
    }

    // tabulation to check how many numbers from range 1 to target is possible
    public void bottomUpTabulation(int[] nums, int target, boolean[][] dp) {
        if (nums[0] >= 0 && nums[0] <= target) {
            dp[0][nums[0]] = true;
        }

        for (int i = 0; i < nums.length; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i < nums.length; i++) {
            for (int ct = 1; ct <= target; ct++) {
                boolean include = false;

                if (nums[i] <= ct) {
                    include = dp[i - 1][ct - nums[i]];
                }

                boolean exclude = dp[i - 1][ct];

                dp[i][ct] = include || exclude;
            }
        }
    }

    // recursive approach
    public int recursive(int[] nums, int n, int idx, int includeSum, int includeSize, int excludeSum, int excludeSize) {
        // base condition
        if (idx >= nums.length) {
            return Math.abs(includeSum - excludeSum);
        }

        // function body
        int currElem = nums[idx];

        int include = Integer.MAX_VALUE;
        int exclude = Integer.MAX_VALUE;

        if (includeSize < n) {
            include = recursive(nums, n, idx + 1, includeSum + currElem, includeSize + 1, excludeSum, excludeSize);
        }

        if (excludeSize < n) {
            exclude = recursive(nums, n, idx + 1, includeSum, includeSize, excludeSum + currElem, excludeSize + 1);
        }

        return Math.min(include, exclude);
    }
}
