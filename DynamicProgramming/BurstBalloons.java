package DynamicProgramming;

public class BurstBalloons {
    public int maxCoins(int[] nums) {
        // return recursive(nums, 0, nums.length-1);

        // int[][] dp = new int[nums.length][nums.length];
        // for(int[] row: dp) Arrays.fill(row, -1);
        // return memoization(nums, 0, nums.length-1, dp);

        return tabulation(nums);
    }

    // space optimization is not possible

    // tabulation
    public int tabulation(int[] nums) {
        int[][] dp = new int[nums.length + 1][nums.length + 1];

        for (int start = nums.length - 1; start >= 0; start--) {
            // note here starting the end from the start in the inner loop otherwise no
            // answer will be made
            for (int end = start; end < nums.length; end++) {
                /*
                 * +1 adjustment is made for the end variable
                 */

                // commented below condition because we've started end from start only
                // if(start > end) continue;

                int coins = Integer.MIN_VALUE;

                for (int i = start; i <= end; i++) {
                    int left = start - 1 < 0 ? 1 : nums[start - 1];
                    int right = end + 1 >= nums.length ? 1 : nums[end + 1];

                    coins = Math.max(coins, (left * right * nums[i]) + dp[start][i - 1 + 1] + dp[i + 1][end + 1]);
                }

                dp[start][end + 1] = coins;
            }
        }
        return dp[0][nums.length];
    }

    // memoization
    public int memoization(int[] nums, int start, int end, int[][] dp) {
        // base condition
        if (start > end) {
            return 0;
        }

        if (dp[start][end] != -1) {
            return dp[start][end];
        }

        // function body
        int coins = Integer.MIN_VALUE;
        for (int i = start; i <= end; i++) {
            int left = start - 1 < 0 ? 1 : nums[start - 1];
            int right = end + 1 >= nums.length ? 1 : nums[end + 1];

            coins = Math.max(coins,
                    (left * right * nums[i]) + memoization(nums, start, i - 1, dp) + memoization(nums, i + 1, end, dp));
        }
        dp[start][end] = coins;
        return coins;
    }

    // recursive
    public int recursive(int[] nums, int start, int end) {
        // base condition
        if (start > end) {
            return 0;
        }

        // function body
        int coins = Integer.MIN_VALUE;
        for (int i = start; i <= end; i++) {
            int left = start - 1 < 0 ? 1 : nums[start - 1];
            int right = end + 1 >= nums.length ? 1 : nums[end + 1];

            coins = Math.max(coins,
                    (left * right * nums[i]) + recursive(nums, start, i - 1) + recursive(nums, i + 1, end));
        }
        return coins;
    }
}
