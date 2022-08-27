/*
 ! This solution is giving the correct answer but at some cases it is exceding time limit
 * Subarray with given sum
 * 
 * https://practice.geeksforgeeks.org/problems/subarray-with-given-sum-1587115621/1?page=1&difficulty[]=-2&difficulty[]=-1&difficulty[]=0&category[]=Arrays&sortBy=submissions
 * 
 * 
 */

package GeeksForGeeksQuestions;

import java.util.ArrayList;

public class SubarrayWithGivenSum {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int n = 10;
        int s = 15;

        // int[] arr = { 3,5,6,8,2};
        // int n = 5;
        // int s = 10;

        System.out.println(subarraySum(arr, n, s));
    }

    // Function to find a continuous sub-array which adds up to a given number.
    static ArrayList<Integer> subarraySum(int[] arr, int n, int s) {
        // Your code here
        ArrayList<Integer> ans = new ArrayList<Integer>();

        int start = 0;
        int i = start;

        int sum = 0;

        ans.add(start+1);

        while (start < arr.length) {
            if (sum == s) {
                ans.add(i);
                return ans;
            } else if (sum > s) {
                start++;
                i = start;
                sum = 0;
                ans.clear();
                ans.add(start + 1);
            } else {
                sum += arr[i];
                i++;
            }
        }

        ans.clear();
        ans.add(-1);
        ans.add(-1);

        return ans;
    }
}
