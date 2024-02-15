package DynamicProgramming;

public class StoneGame3 {
    public String stoneGameIII(int[] stoneValue) {
        // int value = getMaxValueForAliceRecursive(stoneValue, 0); // this method will be returning Max Possible Value of Alice - Max Possible Value of Bob

        // int[] dp = new int[stoneValue.length];
        // Arrays.fill(dp, -1);
        // int value = getMaxValueForAliceMemoization(stoneValue, 0, dp); // this method will be returning Max Possible Value of Alice - Max Possible Value of Bob

        int value = getMaxValueForAliceTabulation(stoneValue); // this method will be returning Max Possible Value of Alice - Max Possible Value of Bob

        if(value > 0){
            return "Alice";
        } else if (value < 0){
            return "Bob";
        }
        return "Tie";
    }

    // tabulation
    public int getMaxValueForAliceTabulation(int[] stoneValue){
        int[] dp = new int[stoneValue.length+3];

        for(int start = stoneValue.length-1; start >= 0; start --){
            int maxPossibleValue = Integer.MIN_VALUE;
            int totalValue = 0;

            for(int stoneNumber = 1; stoneNumber <= 3; stoneNumber ++){
                if(start + stoneNumber - 1 >= stoneValue.length){
                    break;
                }

                totalValue += stoneValue[start + stoneNumber - 1];

                maxPossibleValue = Math.max(maxPossibleValue, totalValue - dp[start+stoneNumber]);
            }

            dp[start] = maxPossibleValue;
        }

        return dp[0];
    }

    // memoization
    public int getMaxValueForAliceMemoization(int[] stoneValue, int start, int[] dp) {
        // base condition
        if(start >= stoneValue.length){
            return 0;
        }

        if(dp[start] != -1){
            return dp[start];
        }

        // function body
        int maxPossibleValue = Integer.MIN_VALUE;
        int totalValue = 0;

        for(int stoneNumber = 1; stoneNumber <= 3; stoneNumber ++){
            if(start + stoneNumber - 1 >= stoneValue.length){
                break;
            }

            totalValue += stoneValue[start + stoneNumber - 1];

            maxPossibleValue = Math.max(maxPossibleValue, totalValue - getMaxValueForAliceMemoization(stoneValue, start+stoneNumber, dp));
        }

        return dp[start] = maxPossibleValue;
    }

    // recursive
    public int getMaxValueForAliceRecursive(int[] stoneValue, int start){
        // base condition
        if(start >= stoneValue.length){
            return 0;
        }

        // function body
        int maxPossibleValue = Integer.MIN_VALUE;
        int totalValue = 0;

        for(int stoneNumber = 1; stoneNumber <= 3; stoneNumber ++){
            if(start + stoneNumber - 1 >= stoneValue.length){
                break;
            }

            totalValue += stoneValue[start + stoneNumber - 1];

            maxPossibleValue = Math.max(maxPossibleValue, totalValue - getMaxValueForAliceRecursive(stoneValue, start+stoneNumber));
        }
        return maxPossibleValue;
    }
}
