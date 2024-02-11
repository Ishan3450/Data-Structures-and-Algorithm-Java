/*
 * Merge Sort
 * 
 * - Solution: TC: O(n * log n)
 *  - log n in TC is for at each function call there will be 2 for each
 *  - and n in the TC is for at each function level not function call (function level can ve be determined by drawing recursive tree) of n elements are merged
 * - SC: O(N)
 *  - at each method call we are taking array sizes: fot left:n/2 and for right:n/2,j for next level n/4+n/4 for next n/8+n/8 and so on till 1+1
 *  - so taking 2 as common: 2(n/2) + 2(n/4) + 2(n/8)
 *  - now ignoring the constant 2 and taking n as common: n(1/2 + 1/4 + 1/8 ... 1)
 *  - so if we solve the bracket then we will get some integer constant, so by ignoring that only n left, so the TC is O(n)
 * 
 * - It is basically like divide and conquer
 * - 1st divide the array in to two halfves
 * - Then sort the two parts using recursion
 * - After sorting the two parts merge it in the sorted order
 */

package SortingAlgorithms;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args){
        int[] arr = {5,4,3,2,1};

        System.out.println(Arrays.toString(mergeSort(arr)));
    }

    static int[] mergeSort(int[] arr){
        // base condition
        if(arr.length == 1){
            return arr;
        }

        // function body
        int mid = arr.length / 2;

        // copyOfRange creates a new array from an existing array of specified indices or ranges
        int[] leftPart = mergeSort(Arrays.copyOfRange(arr, 0, mid));
        int[] rightPart = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));

        return merge(leftPart, rightPart);
    }

    static int[] merge(int[] leftPart, int[] rightPart){
        int[] ans = new int[leftPart.length + rightPart.length];

        int i = 0; // i for left part
        int j = 0; // j for right part
        int k = 0; // k for the ans

        // we have to run the loop till length of any one array exceeds
        while(i < leftPart.length && j < rightPart.length){
            if(leftPart[i] < rightPart[j]){
                ans[k] = leftPart[i];
                i++;
            } else{
                ans[k] = rightPart[j];
                j++;
            }
            k++;
        }

        // it may be possbile that any any one array is smaller than another so we have to completely add the bigger array

        // if left part if bigger then this loop will run
        while(i < leftPart.length){
            ans[k] = leftPart[i];
            i++;
            k++;
        }

        // if right part is bigger than this loop will run
        while(j < rightPart.length){
            ans[k] = rightPart[j];
            j++;
            k++;
        }

        return ans;
    }

}
