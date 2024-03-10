package Recursion;
// Problem: Given an array of distinct elements, not sorted give the minimum elements used to sum up to the given target

public class CoinChange {
    // this approach goes from target -> 0 
    public static int solve(int[] arr, int target){
        // base condition
        if(target == 0){
            return 0;
        }
        if(target < 0){
            return Integer.MAX_VALUE;
        }

        // function body + recursive call
        int ans = Integer.MAX_VALUE;
        for(int elem: arr){
            int currAns = solve(arr, target-elem);
            
            if(currAns != Integer.MAX_VALUE){
                ans = Math.min(ans, currAns+1); // +1 for counting the coin
            }
        }

        return ans;
    }
    
    // Self-approach by taking an extra arguement count in the function name
    public static int solve2(int[] arr, int target, int count){
        // base condtion
        if(target == 0){
            return count;
        }

        if(target < 0){
            return Integer.MAX_VALUE;
        }

        // function body + recursive condition
        int ans = Integer.MAX_VALUE;
        for(int elem: arr){
            int currAns = solve2(arr, target-elem, count+1);
            ans = Math.min(ans, currAns);
        }

        return ans;
    }

    
    public static void main(String[] args){
        int[] arr = {1,2};
        int target = 5;

        System.out.println(solve(arr, target));
        System.out.println(solve2(arr, target, 0));
    }
}
