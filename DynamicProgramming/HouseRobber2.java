package DynamicProgramming;

import java.util.Arrays;

public class HouseRobber2 {
    public int rob(int[] nums) {
        // return recursive(nums, 0, false);

        // int[][] dp = new int[nums.length][2];
        // for(int[] row : dp) Arrays.fill(row, -1);
        // return memoization(nums, 0, false, dp);

        return spaceOptimized(nums);
    }

    // space optimization
    /*
     * In space optimization curr is dependent on curr + 1 and curr + 2 that's why created 3 arrays
     */
    public int spaceOptimized(int[] nums) {
        int[] curr = new int[2];
        int[] next = new int[2];
        int[] nextToNext = new int[2];

        for (int idx = nums.length - 1; idx >= 0; idx--) {
            for (int robbedFirstHouse = 1; robbedFirstHouse >= 0; robbedFirstHouse--) {
                int robbingCurrentHouse = 0;

                if (idx == 0) {
                    robbingCurrentHouse = nums[idx] + nextToNext[1];
                } else if (idx == nums.length - 1) {
                    if (robbedFirstHouse == 0) {
                        robbingCurrentHouse = nums[idx] + nextToNext[0];
                    }
                } else {
                    robbingCurrentHouse = nums[idx] + nextToNext[robbedFirstHouse];
                }

                int skippingCurrentHouse = next[robbedFirstHouse];

                curr[robbedFirstHouse] = Math.max(robbingCurrentHouse, skippingCurrentHouse);
            }
            // shifting
            nextToNext = Arrays.copyOf(next, next.length);
            next = Arrays.copyOf(curr, curr.length);
        }
        return curr[0];
    }

    // tabulation
    public int tabulation(int[] nums) {
        int[][] dp = new int[nums.length + 2][2];

        for (int idx = nums.length - 1; idx >= 0; idx--) {
            for (int robbedFirstHouse = 1; robbedFirstHouse >= 0; robbedFirstHouse--) {
                int robbingCurrentHouse = 0;

                if (idx == 0) {
                    robbingCurrentHouse = nums[idx] + dp[idx + 2][1];
                } else if (idx == nums.length - 1) {
                    if (robbedFirstHouse == 0) {
                        robbingCurrentHouse = nums[idx] + dp[idx + 2][0];
                    }
                } else {
                    robbingCurrentHouse = nums[idx] + dp[idx + 2][robbedFirstHouse];
                }

                int skippingCurrentHouse = dp[idx + 1][robbedFirstHouse];

                dp[idx][robbedFirstHouse] = Math.max(robbingCurrentHouse, skippingCurrentHouse);
            }
        }
        return dp[0][0];
    }

    // memoization
    public int memoization(int[] nums, int idx, boolean robbedFirstHouse, int[][] dp) {
        // base condition
        if (idx >= nums.length) {
            return 0;
        }

        if (dp[idx][robbedFirstHouse ? 1 : 0] != -1) {
            return dp[idx][robbedFirstHouse ? 1 : 0];
        }

        // function body
        int robbingCurrentHouse = 0;
        if (idx == 0) {
            robbingCurrentHouse = nums[idx] + memoization(nums, idx + 2, true, dp);
        } else if (idx == nums.length - 1) {
            if (!robbedFirstHouse) {
                robbingCurrentHouse = nums[idx] + memoization(nums, idx + 2, false, dp);
            }
        } else {
            robbingCurrentHouse = nums[idx] + memoization(nums, idx + 2, robbedFirstHouse, dp);
        }

        int skippingCurrentHouse = memoization(nums, idx + 1, robbedFirstHouse, dp);

        dp[idx][robbedFirstHouse ? 1 : 0] = Math.max(robbingCurrentHouse, skippingCurrentHouse);
        return dp[idx][robbedFirstHouse ? 1 : 0];
    }

    // recursive
    public int recursive(int[] nums, int idx, boolean robbedFirstHouse) {
        // base condition
        if (idx >= nums.length) {
            return 0;
        }

        // function body
        int robbingCurrentHouse = 0;
        if (idx == 0) {
            robbingCurrentHouse = nums[idx] + recursive(nums, idx + 2, true);
        } else if (idx == nums.length - 1) {
            if (!robbedFirstHouse) {
                robbingCurrentHouse = nums[idx] + recursive(nums, idx + 2, false);
            }
        } else {
            robbingCurrentHouse = nums[idx] + recursive(nums, idx + 2, robbedFirstHouse);
        }

        int skippingCurrentHouse = recursive(nums, idx + 1, robbedFirstHouse);

        return Math.max(robbingCurrentHouse, skippingCurrentHouse);
    }
}
