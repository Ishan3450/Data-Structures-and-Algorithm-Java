/*
 * QuickSort
 * 
 * - First take any random element and name it pivot
 * - then put all the elements to the left side of pivot which are smaller than the pivot
 * - and put all the elements to the right side of pivot which are greater than pivot
 * - so, at it iteration pivot will be at it's correct position
 *
 */

package SortingAlgorithms;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args){
        int[] arr = {5,4,3,2,1};

        sort(arr, 0, arr.length - 1);
        
        System.out.println(Arrays.toString(arr));
    }

    static void sort(int[] arr, int start, int end){
        // base condition
        if(start >= end){
            return;
        }

        // function body
        int s = start;
        int e = end;
        int mid = s + (e - s) / 2;

        // we can take pivot as any random element from the array
        // NOTE: but we are gonna take the pivot as mid
        int pivot = arr[mid];

        /* 
        now we have to find two violations:
            1. is to find the first element from the left which is greater than the pivot element
            2. is to find the first element from the right side which is smaller than the pivot element
        */ 
        while(s <= e){
            // this loop will find the violating element from the left side
            while(arr[s] < pivot){
                // everything is good keep going on
                s++;
            }

            // this loop will find the violating element from the right side
            while(arr[e] > pivot){
                // everything is good keep comming back
                e--;
            }

            // till this point we have our left and right violating elements
            // so we are gonna swap those two elements
            if(s <= e){ // when start is at left side and end is at right side, if condition will hit
                // swap
                int temp = arr[s];
                arr[s] = arr[e];
                arr[e] = temp;
                s++;
                e--;
            }
        }
            
        // recursive condition
        sort(arr, start, e);
        sort(arr, s, end);
    }
}
