/*
 * LC: 279
 * 
 * TC: (SQRT(N))^N, which in Big-O-Notation called O(N)^N (by removing the constants)
 * SC: O(N), as for 12 -> 12 maximium of 12 recursive calls will be made for the i=1 case
 */

package Recursion;

public class PerfectSquares {
    public int numSquaresHelper(int n){
        // base condition
        if(n == 0 || n < 0){
            return 0;
        }

        // function body + recursive calls
        int end = (int) Math.sqrt(n);
        int ans = Integer.MAX_VALUE;

        for(int i = 1; i <= end; i++){
            int sqr = i * i;
            int numberOfPerfectSquares = numSquaresHelper(n - sqr);
            ans = Math.min(ans, numberOfPerfectSquares);
        }

        // return 1 + ans to consider current case as a answer
        return 1 + ans;
    }
    public int numSquares(int n) {
        return numSquaresHelper(n);
    }
}
