package DynamicProgramming;

import java.util.Arrays;

public class MinimumPathSum {
      public int minPathSum(int[][] grid) {
        // return recursive(grid, 0, 0);

        // int[][] dp = new int[grid.length][grid[0].length];
        // for(int[] row: dp) Arrays.fill(row, -1);
        // return memoization(grid, 0, 0, dp);

        // return tabulation(grid);
        
        return spaceOptimized(grid);
    }

    // space optimized
    public int spaceOptimized(int[][] grid){
        int[] curr = new int[grid[0].length+1];
        int[] next = new int[grid[0].length+1];
        
        Arrays.fill(curr, -1);
        Arrays.fill(next, -1);

        for(int row = grid.length-1; row >= 0; row --){
            for(int col = grid[0].length-1; col >= 0; col --){
                int down = next[col];
                int right = curr[col+1];

                if(down == -1 && right == -1){
                    down = right = 0;
                } else if(down == -1){
                    down = Integer.MAX_VALUE;
                } else if(right == -1){
                    right = Integer.MAX_VALUE;
                }

                curr[col] = grid[row][col] + Math.min(down, right);
            }
            // shifting
            next = curr.clone();
        }

        return curr[0];
    }


    // tabulation
    public int tabulation(int[][] grid){
        int[][] dp = new int[grid.length+1][grid[0].length+1];
        for(int[] row: dp) Arrays.fill(row, -1);

        for(int row = grid.length-1; row >= 0; row --){
            for(int col = grid[0].length-1; col >= 0; col --){
                int down = dp[row+1][col];
                int right = dp[row][col+1];

                if(down == -1 && right == -1){
                    down = right = 0;
                } else if(down == -1){
                    down = Integer.MAX_VALUE;
                } else if(right == -1){
                    right = Integer.MAX_VALUE;
                }

                dp[row][col] = grid[row][col] + Math.min(down, right);
            }
        }

        return dp[0][0];
    }

    // memoization
    public int memoization(int[][] grid, int row, int col, int[][] dp){
        // base condition
        if(row >= grid.length || col >= grid[0].length){
            return -1;
        }

        if(dp[row][col] != -1){
            return dp[row][col];
        }

        // function body
        int down = memoization(grid, row+1,col, dp);
        int right = memoization(grid, row, col+1, dp);

        if(down == -1 && right == -1){
            down = right = 0;
        } else if(down == -1){
            down = Integer.MAX_VALUE;
        } else if(right == -1){
            right = Integer.MAX_VALUE;
        }

        return dp[row][col] = grid[row][col] + Math.min(down, right);
    }

    // recursive
    public int recursive(int[][] grid, int row, int col){
        // base condition
        if(row >= grid.length || col >= grid[0].length){
            return -1;
        }

        // function body
        int down = recursive(grid, row+1,col);
        int right = recursive(grid, row, col+1);

        if(down == -1 && right == -1){
            down = right = 0;
        } else if(down == -1){
            down = Integer.MAX_VALUE;
        } else if(right == -1){
            right = Integer.MAX_VALUE;
        }

        return grid[row][col] + Math.min(down, right);
    }
}
