/*
 * TODO: Revise in future
 * https://www.codingninjas.com/codestudio/contests/love-babbar-contest-ii/3583551/problems/14871?leftPanelTab=1
 */

package CodingNinjasContests;

import java.util.*;

public class LongestSubarrayWithBitwiseAns {
    static List<Integer> bitwiseAnd(int n, int q, int[] arr, int[] queries) {
        for (int i = 1; i < arr.length; i++) {
            arr[i] = arr[i] & arr[i - 1];
        }

        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < q; i++) {
            int currQuery = queries[i];
            int count = 0;

            for (int elem : arr) {
                if (elem >= currQuery) {
                    count++;
                }
            }
            ans.add(count);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {3,7,9,16};
        int n = arr.length;

        int[] queries = {2,3};
        int q = queries.length;

        System.out.println(bitwiseAnd(n, q, arr, queries));
    }
}
