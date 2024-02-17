package DynamicProgramming;

public class CombinationSum4 {
    public int combinationSum4(int[] nums, int target) {
        // return recursive(nums, target);

        // int[] dp = new int[target+1];
        // Arrays.fill(dp, -1);
        // return memoization(nums, target, dp);

        return tabulation(nums, target);
    }

    // tabulation
    public int tabulation(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;

        for (int currTarget = 1; currTarget <= target; currTarget++) {
            int totalWays = 0;
            for (int i = 0; i < nums.length; i++) {
                if (currTarget - nums[i] >= 0)
                    totalWays += dp[currTarget - nums[i]];
            }
            dp[currTarget] = totalWays;
        }
        return dp[target];
    }

    // memoization
    public int memoization(int[] nums, int target, int[] dp) {
        // base condition
        if (target == 0) {
            return 1;
        }

        if (target < 0) {
            return 0;
        }

        if (dp[target] != -1) {
            return dp[target];
        }

        // function body
        int totalWays = 0;
        for (int i = 0; i < nums.length; i++) {
            totalWays += memoization(nums, target - nums[i], dp);
        }
        return dp[target] = totalWays;
    }

    // recursive
    public int recursive(int[] nums, int target) {
        // base condition
        if (target == 0) {
            return 1;
        }

        if (target < 0) {
            return 0;
        }

        // function body
        int totalWays = 0;
        for (int i = 0; i < nums.length; i++) {
            totalWays += recursive(nums, target - nums[i]);
        }
        return totalWays;
    }
}
