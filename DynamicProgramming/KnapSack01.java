package DynamicProgramming;

public class KnapSack01 {
    /*
     * All the DP here in this problem will have default value of 0.
     */


     // again space optimization is possible, from O(2W) space to only making single array to do all the work, curr[w] only depends on prev[w] and prev[W-w] but if we do regular left to right traversal values will be overidden, instead we will traverse from right to left
     static int spaceOptimized2(int W, int[] w, int[] v, int n){
        int[] curr = new int[W+1];
        
        for(int i = w[0]; i <= W; i ++){
            curr[i] = v[0];
        }

        for(int i = 1; i < n ; i ++){
            for(int weight = W; weight >= 1; weight --){
                int includeCurrItem = 0;
                int excludeCurrItem = 0;
                
                if(w[i] <= weight){
                    includeCurrItem = v[i] + curr[weight - w[i]];
                }
                excludeCurrItem = curr[weight]; // if we exlude curr item then the optimal max value will be the just before the curr one
                
                curr[weight] = Math.max(includeCurrItem, excludeCurrItem);
            }
        }
        return curr[W];
        
    }
    
    // space optimization is possible, here we have see that the ith row is dependent on the the i-1th row so rather than creating a n*W 2d array, we can simply create 2 1d arrays of size W which will reduce the size from O(n*W) -> O(2W) or O(W)
    static int spaceOptimized(int W, int[] w, int[] v, int n){
        int[] prev = new int[W+1];
        int[] curr = new int[W+1];
        
        for(int i = w[0]; i <= W; i ++){
            prev[i] = v[0];
        }

        for(int i = 1; i < n ; i ++){
            for(int weight = 1; weight <= W; weight ++){
                int includeCurrItem = 0;
                int excludeCurrItem = 0;
                
                if(w[i] <= weight){
                    includeCurrItem = v[i] + prev[weight - w[i]];
                }
                excludeCurrItem = prev[weight]; // if we exlude curr item then the optimal max value will be the just before the curr one
                
                curr[weight] = Math.max(includeCurrItem, excludeCurrItem);
            }
            
            // shift
            
            // shift
            //! prev = curr; // this is mistake
            // above line will just refer to the referenced object, which will create problem while updating curr[i] will also update prev[i] automatically
            
            for(int j = 0; j <= W; j++){ // way 2
                prev[j] = curr[j];
            }

            // prev = Arrays.copyOf(curr, W+1); // way 1

        }
        return prev[W]; // always return prev[W] in case of n=1
    }
    
    // bottom up tabulation
    // TC: O(n*W) SC: O(n*W)
    static int bottomUpTabulation(int W, int[] w, int[] v, int n){
        int[][] dp = new int[n][W+1];
        
        // setting up the first row
        for(int i = w[0] ; i <= W ; i ++){
            dp[0][i] = v[0];
        }
        
        // now starting from the second row
        for(int i = 1; i < n ; i ++){
            for(int weight = 1; weight <= W; weight ++){
                int includeCurrItem = 0;
                int excludeCurrItem = 0;
                
                if(w[i] <= weight){
                    includeCurrItem = v[i] + dp[i-1][weight - w[i]];
                }
                excludeCurrItem = dp[i-1][weight]; // if we exlude curr item then the optimal max value will be the just before the curr one
                
                dp[i][weight] = Math.max(includeCurrItem, excludeCurrItem);
            }
        }
        return dp[n-1][W];
    }
    
    // top down memoization approach
    // TC: O(n*W) SC: O(n*W)
    static int topDownMemoization(int W, int[] w, int[] v, int n, int idx, int[][] dp){
        // base condition
        if(idx >= n){
            return 0;
        }
        
        if(dp[idx][W] != -1){
            return dp[idx][W];
        }
        
        // function body
        int include, exclude;
        include = exclude = 0;
        
        if(w[idx] <= W){
            include = v[idx] + topDownMemoization(W - w[idx], w, v, n, idx+1, dp);
        }
        
        exclude = topDownMemoization(W, w, v, n, idx + 1, dp);
        
        dp[idx][W] = Math.max(include, exclude);
        return dp[idx][W];
    }
    
    // recursive approach
    static int helper(int W, int[] w, int[] v, int n, int idx){
        // base condition
        if(idx >= n){
            return 0;
        }

        // function body
        int include = 0;
        int exclude = 0;
        
        if(w[idx] <= W){
            include = v[idx] + helper(W - w[idx], w, v, n , idx + 1);
        }
        
        exclude = helper(W, w, v, n , idx + 1);
        
        return Math.max(include, exclude);
    }
}
