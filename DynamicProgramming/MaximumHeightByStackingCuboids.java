package DynamicProgramming;

import java.util.Arrays;
import java.util.Comparator;

public class MaximumHeightByStackingCuboids {
        public int maxHeight(int[][] cuboids) {
        // rotation is allowed, so rotating based on the lowest to higher dimension
        for(int i = 0 ; i < cuboids.length ; i ++){
            Arrays.sort(cuboids[i]);
        }

        Comparator<int[]> sortBasedOnDimensions = new Comparator<int[]> () {
            @Override
            public int compare(int[] a, int[] b){
                if(a[0] != b[0]){
                    return a[0] - b[0];
                }

                if(a[1] != b[1]){
                    return a[1] - b[1];
                }

                return a[2] - b[2];
            }
        };

        // sorting based on lamda function
        Arrays.sort(cuboids, sortBasedOnDimensions);

        // for(int[] cuboid: cuboids){
        //     System.out.println(Arrays.toString(cuboid));
        // }

        // int[][] dp = new int[cuboids.length][cuboids.length];
        // for(int[] row: dp) Arrays.fill(row, -1);

        return spaceOptimization(cuboids);
    }

    // space optimization
    public int spaceOptimization(int[][] cuboids){
        int[] curr = new int[cuboids.length+1];
        int[] next = new int[cuboids.length+1];

        for(int currIdx = cuboids.length-1; currIdx >= 0; currIdx--){
            for(int prevIdx = cuboids.length-1; prevIdx >= -1; prevIdx --){
                int include = 0;

                if(prevIdx == -1 || canCurrentCuboidIncluded(cuboids[prevIdx], cuboids[currIdx])){
                    // adding height to the current stack that's why cuboids[currIdx][2]
                    // adding height because we want maximum height, so we will consider the cuboids[currIdx][2] dimension as height
                    include = cuboids[currIdx][2] + next[currIdx+1];
                }

                int exclude = next[prevIdx+1];

                curr[prevIdx+1] = Math.max(include, exclude);
            }
            // shifting
            next = Arrays.copyOf(curr, curr.length);
        }
        return curr[0];
    }

    // tabulation approach
    public int tabulation(int[][] cuboids){
        int[][] dp = new int[cuboids.length+1][cuboids.length+1];

        for(int currIdx = cuboids.length-1; currIdx >= 0; currIdx--){
            for(int prevIdx = cuboids.length-1; prevIdx >= -1; prevIdx --){
                int include = 0;

                if(prevIdx == -1 || canCurrentCuboidIncluded(cuboids[prevIdx], cuboids[currIdx])){
                    // adding height to the current stack that's why cuboids[currIdx][2]
                    // adding height because we want maximum height, so we will consider the cuboids[currIdx][2] dimension as height
                    include = cuboids[currIdx][2] + dp[currIdx+1][currIdx+1];
                }

                int exclude = dp[currIdx+1][prevIdx+1];

                dp[currIdx][prevIdx+1] = Math.max(include, exclude);
            }
        }
        return dp[0][0];
    }

    // memoization solution
    public int memoization(int[][] cuboids, int currIdx, int prevIdx, int[][] dp){
        // base condition
        if(currIdx >= cuboids.length){
            return 0;
        }

        if(dp[currIdx][prevIdx+1] != -1){
            return dp[currIdx][prevIdx+1];
        }

        // function body
        int include = 0;
        if(prevIdx == -1 || canCurrentCuboidIncluded(cuboids[prevIdx], cuboids[currIdx])){
            // adding height to the current stack that's why cuboids[currIdx][2]
            // adding height because we want maximum height, so we will consider the cuboids[currIdx][2] dimension as height
            include = cuboids[currIdx][2] + memoization(cuboids, currIdx+1, currIdx, dp);
        }

        int exclude = memoization(cuboids, currIdx+1, prevIdx, dp);

        dp[currIdx][prevIdx+1] = Math.max(include, exclude);
        return dp[currIdx][prevIdx+1];
    }

    // recursive solution
    public int recursive(int[][] cuboids, int currIdx, int prevIdx){
        // base condition
        if(currIdx >= cuboids.length){
            return 0;
        }

        // function body
        int include = 0;
        if(prevIdx == -1 || canCurrentCuboidIncluded(cuboids[prevIdx], cuboids[currIdx])){
            // adding height to the current stack that's why cuboids[currIdx][2]
            // adding height because we want maximum height, so we will consider the cuboids[currIdx][2] dimension as height
            include = cuboids[currIdx][2] + recursive(cuboids, currIdx+1, currIdx);
        }

        int exclude = recursive(cuboids, currIdx+1, prevIdx);

        return Math.max(include, exclude);
    }

    private boolean canCurrentCuboidIncluded(int[] prevCuboid, int[] currCuboid){
        if(prevCuboid[0] <= currCuboid[0] && prevCuboid[1] <= currCuboid[1] && prevCuboid[2] <= currCuboid[2]){
            return true;
        }
        return false;
    }

}
