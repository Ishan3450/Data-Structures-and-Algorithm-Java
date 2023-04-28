/*
 * https://practice.geeksforgeeks.org/problems/stickler-theif-1587115621/1
 */
package RecursionQuestions;

public class MaximumSumOfNonAdjacentElements {
    public static int getMaxSum(int[] arr, int i, int sum){
        // base condition
        if(i >= arr.length){
            return sum;
        }

        // function body + recursive call
        
        // one call for inclusion
        int incAns = getMaxSum(arr, i+2, sum+arr[i]); // incrementing i by 2 because we are not allowed to do sum of adjacent elements

        // one call for exclusion
        int excAns = getMaxSum(arr, i+1, sum);

        return Math.max(incAns, excAns);
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,1,3,5,8,1,9};

        System.out.println(getMaxSum(arr, 0, 0));
    }
}
