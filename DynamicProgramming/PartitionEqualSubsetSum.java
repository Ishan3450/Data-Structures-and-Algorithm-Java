package DynamicProgramming;

import java.util.Arrays;

public class PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        int targetSum = 0;
        for(int i = 0 ; i < nums.length; i ++){
            targetSum += nums[i];
        }

        if((targetSum & 1) == 1){
            return false;
        }

        return spaceOptimization2(nums, targetSum/2);
    }

    // space optimization from  target + target to target
    public boolean spaceOptimization2(int[] nums, int target){
        boolean[] curr = new boolean[target+1];

        if(nums[0] <= target){
            curr[nums[0]] = true;
        }

        curr[0] = true;

        for(int i = 1 ; i < nums.length ; i ++){
            for(int currTarget = target; currTarget >= 1; currTarget --){
                boolean include = false;

                if(nums[i] <= currTarget){
                    include = curr[currTarget-nums[i]];
                }

                boolean exclude = curr[currTarget];

                curr[currTarget] = include || exclude;
            }
       }

        return curr[target];
    }

    // space optimization from n*target to target + target
    public boolean spaceOptimization1(int[] nums, int target){
        boolean[] prev = new boolean[target+1];
        boolean[] curr = new boolean[target+1];

        if(nums[0] <= target){
            prev[nums[0]] = true;
        }

        prev[0] = true;
        curr[0] = true;

        for(int i = 1 ; i < nums.length ; i ++){
            for(int currTarget = 1; currTarget <= target; currTarget ++){
                boolean include = false;

                if(nums[i] <= currTarget){
                    include = prev[currTarget-nums[i]];
                }

                boolean exclude = prev[currTarget];

                curr[currTarget] = include || exclude;
            }
            // shifting
            prev = Arrays.copyOf(curr, target+1);
        }

        return prev[target];
    }

    // bottom up tabulation appraoch
    public boolean bottomUpTabulation(int[] nums, int target){
        boolean[][] dp = new boolean[nums.length][target+1];

        if(nums[0] <= target){
            dp[0][nums[0]] = true;
        }

        for(int i = 0 ; i < nums.length; i ++){
            dp[i][0] = true;
        }

        for(int i = 1 ; i < nums.length ; i ++){
            for(int currTarget = 1; currTarget <= target; currTarget ++){
                boolean include = false;

                if(nums[i] <= currTarget){
                    include = dp[i-1][currTarget-nums[i]];
                }

                boolean exclude = dp[i-1][currTarget];

                dp[i][currTarget] = include || exclude;
            }
        }

        return dp[nums.length-1][target];
    }

    // top down memoization appraoch
    // because of Boolean[][] dp taken instead of boolean[][] this function is accepted now.
    // taken boolean object because the default value in boolean[] is false but in this case it will be null, so in the case if we didn't get ans from a target then if false found in Boolean means previously calculated but in boolean[] case it will keep on until base condition hits
    public boolean topDownMemoization(int[] nums, int target, int idx, Boolean[][] dp){
        // base condition
        if(target == 0){
            return true;
        }

        if(target < 0 || idx < 0){
            return false;
        }

        // function body
        if(dp[idx][target] != null){
            return dp[idx][target];
        }

        boolean include = topDownMemoization(nums, target - nums[idx], idx - 1, dp);
        boolean exclude = topDownMemoization(nums, target, idx - 1, dp);
        
        dp[idx][target] = include || exclude;
        return dp[idx][target];
    }

    // normal recursive approach
    public boolean recursive(int[] nums, int target, int idx){
        // base condition
        if(target == 0){
            return true;
        }

        if(target < 0 || idx < 0){
            return false;
        }

        // function body
        boolean include = recursive(nums, target - nums[idx], idx - 1);
        boolean exclude = recursive(nums, target, idx - 1);
        
        return include || exclude;
    }
}
