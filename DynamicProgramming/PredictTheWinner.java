package DynamicProgramming;

import java.util.Arrays;

public class PredictTheWinner {
    /* 
        - First turn will be of P1
        - We have to check whether P1 can win this game or not
        - So to check that we must know the maximum possible score of P1
        - Both players are playing optimally meaning both players are playing to win the game

        Appraoch:
            - We will get the maximum possible score of P1
            - We will get the total sum of the whole array
            - To get score of P2 -> P2 = TotalSum - Score of P1
            - At Last we will check P1 >= P2 or not.
        
        Recursive Relation:
            - At each point P1 can take either nums[0]th elem or nums[nums.length-1]th elem.

            - If P1 takes nums[0] then now its turn of P2, and P2 also have 2 choices either nums[1] or nums[nums.length-1].
            - If P1 takes nums[nums.length-1] then P2 has following choices: either nums[0] or nums[nums.length-2]
    */
    public boolean predictTheWinner(int[] nums) {
        int peekScore = 0;
        
        for(int i = 0 ; i < nums.length ; i ++){
            peekScore += nums[i];
        }

        int[][] dp = new int[nums.length][nums.length];
        for(int[] row: dp) Arrays.fill(row, -1);

        // int maxPossiblePlayer1Score = recursive(nums, 0, nums.length-1);
        // int maxPossiblePlayer1Score = memoization(nums, 0, nums.length-1, dp);
        // int maxPossiblePlayer1Score = tabulation(nums, nums.length);
        int maxPossiblePlayer1Score = spaceOptimized(nums, nums.length);
        int player2Score = peekScore - maxPossiblePlayer1Score;

        return maxPossiblePlayer1Score >= player2Score;
    }

    // recursive
    public int recursive(int[] nums, int start, int end){
        // base condition
        if(start == end){
            return nums[start];
        }
        
        if(start > end){
            return 0;
        }

        // function body

        /* 
            - Here we have taken Math.min() instead of Math.max() but one must be thinking that we have to get max score then why we are taking min one.

            ** Game Theory Rule (Credit: https://www.youtube.com/watch?v=ak3DkeUBo-c):
                - When it's your turn do your best.
                - But when it's your opponent's turn expect the worse.
            
            - So here our opponent has 2 choice either he takes the start or end, but in the questions there is a sentence that both of the players are playing optimally.
            - So our opponent will take the maximum of elem at start and elem at end.

            - According to the game theory rule:
                We are maximizing our score (When it's your turn do your best means)
                Our opponent is trying to maximize his score and minimizing our score (But when it's your opponent's turn expect the worse)
        */
        int currPlayerTakingStartingElem = nums[start] + Math.min(recursive(nums, start+2, end), recursive(nums, start+1, end-1));
        int currPlayerTakingEndingElem = nums[end] + Math.min(recursive(nums, start+1, end-1), recursive(nums, start, end-2));

        return Math.max(currPlayerTakingStartingElem, currPlayerTakingEndingElem);
    }
    
    // memoization
    public int memoization(int[] nums, int start, int end, int[][] dp){
        // base condition
        if(start == end){
            return nums[start];
        }
        
        if(start > end){
            return 0;
        }

        if(dp[start][end] != -1){
            return dp[start][end];
        }

        // function body

        /* 
            - Here we have taken Math.min() instead of Math.max() but one must be thinking that we have to get max score then why we are taking min one.

            ** Game Theory Rule (Credit: https://www.youtube.com/watch?v=ak3DkeUBo-c):
                - When it's your turn do your best.
                - But when it's your opponent's turn expect the worse.
            
            - So here our opponent has 2 choice either he takes the start or end, but in the questions there is a sentence that both of the players are playing optimally.
            - So our opponent will take the maximum of elem at start and elem at end.

            - According to the game theory rule:
                We are maximizing our score (When it's your turn do your best means)
                Our opponent is trying to maximize his score and minimizing our score (But when it's your opponent's turn expect the worse)
        */
        int currPlayerTakingStartingElem = nums[start] + Math.min(memoization(nums, start+2, end, dp), memoization(nums, start+1, end-1, dp));
        int currPlayerTakingEndingElem = nums[end] + Math.min(memoization(nums, start+1, end-1, dp), memoization(nums, start, end-2, dp));

        dp[start][end] = Math.max(currPlayerTakingStartingElem, currPlayerTakingEndingElem);
        return dp[start][end];
    }    

    // tabulation
    public int tabulation(int[] nums, int n){
        int[][] dp = new int[n+2][n+2];

        for(int start = n-1; start >= 0; start --){
            for(int end = 0; end < n; end ++){
                 /* 
                    - Here we have taken Math.min() instead of Math.max() but one must be thinking that we have to get max score then why we are taking min one.

                    ** Game Theory Rule (Credit: https://www.youtube.com/watch?v=ak3DkeUBo-c):
                        - When it's your turn do your best.
                        - But when it's your opponent's turn expect the worse.
                    
                    - So here our opponent has 2 choice either he takes the start or end, but in the questions there is a sentence that both of the players are playing optimally.
                    - So our opponent will take the maximum of elem at start and elem at end.

                    - According to the game theory rule:
                        We are maximizing our score (When it's your turn do your best means)
                        Our opponent is trying to maximize his score and minimizing our score (But when it's your opponent's turn expect the worse)
                */

                if(start > end){
                    continue;
                }

                // Slight adjustment will be there the end[0] will be end[0+2] means +2 adjustment for end will be there
                int currPlayerTakingStartingElem = nums[start] + Math.min(dp[start+2][end+2], dp[start+1][(end-1)+2]);
                int currPlayerTakingEndingElem = nums[end] + Math.min(dp[start+1][(end-1)+2], dp[start][(end-2)+2]);

                dp[start][end+2] = Math.max(currPlayerTakingStartingElem, currPlayerTakingEndingElem);                
            }
        }
        return dp[0][n-1+2]; // here [+2] is used as +2 adjustment is there for end
    }

    // spaceOptimized
    public int spaceOptimized(int[] nums, int n){
        int[] curr = new int[n+2];
        int[] next = new int[n+2];
        int[] nextToNext = new int[n+2];

        for(int start = n-1; start >= 0; start --){
            for(int end = 0; end < n; end ++){
                 /* 
                    - Here we have taken Math.min() instead of Math.max() but one must be thinking that we have to get max score then why we are taking min one.

                    ** Game Theory Rule (Credit: https://www.youtube.com/watch?v=ak3DkeUBo-c):
                        - When it's your turn do your best.
                        - But when it's your opponent's turn expect the worse.
                    
                    - So here our opponent has 2 choice either he takes the start or end, but in the questions there is a sentence that both of the players are playing optimally.
                    - So our opponent will take the maximum of elem at start and elem at end.

                    - According to the game theory rule:
                        We are maximizing our score (When it's your turn do your best means)
                        Our opponent is trying to maximize his score and minimizing our score (But when it's your opponent's turn expect the worse)
                */

                if(start > end){
                    continue;
                }

                // Slight adjustment will be there the end[0] will be end[0+2] means +2 adjustment for end will be there
                int currPlayerTakingStartingElem = nums[start] + Math.min(nextToNext[end+2], next[(end-1)+2]);
                int currPlayerTakingEndingElem = nums[end] + Math.min(next[(end-1)+2], curr[(end-2)+2]);

                curr[end+2] = Math.max(currPlayerTakingStartingElem, currPlayerTakingEndingElem);                
            }
            // shifting is important
            nextToNext = Arrays.copyOf(next, next.length);
            next = Arrays.copyOf(curr, curr.length);
        }
        return curr[n-1+2]; // here [+2] is used as +2 adjustment is there for end
    }    
}
