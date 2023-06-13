/*
 * TC: O(NlogN)
 * SC: O(N)
 */

package RecursionQuestions;

import java.util.Arrays;

public class CountInversionsUsingMergeSortAlgorithm {
    static long inversionCount(long arr[], long N)
    {
        // Your Code Here
        long[] count = new long[1];
        
        mergeSort(arr, count);
        return count[0];
    }
    
    public static long[] mergeSort(long[] nums, long[] count){
        // base condition
        if(nums.length == 1){
            return nums;
        }

        // function body
        int mid = nums.length / 2;

        long[] leftPart = mergeSort(Arrays.copyOfRange(nums, 0, mid), count);
        long[] rightPart = mergeSort(Arrays.copyOfRange(nums, mid, nums.length), count);

        return merge(leftPart, rightPart, count);
    }

    public static long[] merge(long[] lp, long[] rp, long[] count){
        long[] temp = new long[lp.length + rp.length];
        int i,j,k;
        i = j = k = 0;

        while(i < lp.length && j < rp.length){
            if(lp[i] <= rp[j]){
                temp[k++] = lp[i++];
            } else{
                // counting inversions
                count[0] += lp.length - i;

                temp[k++] = rp[j++];
            }
        }

        while(i < lp.length){
            temp[k++] = lp[i++];
        }

        while(j < rp.length){
            temp[k++] = rp[j++];
        }

        return temp;
    }
}
