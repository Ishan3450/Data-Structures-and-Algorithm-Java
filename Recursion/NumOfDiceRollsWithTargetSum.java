// LC: 1155

/*
 * TC: O(K^N)
 * SC: O(N)
 */

package Recursion;

public class NumOfDiceRollsWithTargetSum {
    public int numRollsToTarget(int n, int k, int target) {
        // base condition
        if(target < 0){ return 0; } // if target is negative
        if(n == 0 && target == 0) { return 1; } // if a possible way comes
        if(n == 0 && target != 0) { return 0; } // if there are no more dices and also target is not achieved yet
        if(n != 0 && target == 0) { return 0; } // if target is achieved but by not using all the dices then also this is a false case

        // function body + rec call
        int ans = 0;
        for(int i=1; i<=k; i++){
            ans += numRollsToTarget(n-1, k, target-i);
        }

        return ans;
    }
}
