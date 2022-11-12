/*
 * Subsets of Array
 * 
 * Approach : 
 * - Time Complexity: O(N * 2^N)
 * - first we have to add an initial empty list
 * - then iterate through the array and do following:
 *  - to make the subset we have to make the copy of outer loop and add the current element in the list
 *  - so we have to get the size of the outer loop
 *  - then run till the size of the outer loop and do following:
 *      - get the ith copy of the outer loop into a seperate list and name it INTERNAL
 *      - then add the current element of the array into the INTERNAL list which is the copy of ith outer loop till the (for loop of size)
 *      - at each iteration add the internal list into the outer list
 *  - at the end of the function return the outer loop
 */

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class SubSet {
    public static void main(String[] args){
        int[] arr = {1,2,3};
        System.out.println(subset(arr));

        int[] arr2 = {2,1,2};
        System.out.println(subsetForDuplicates(arr2));

    }

    static List<List<Integer>> subsetForDuplicates(int[] arr){
        // for duplicates first we have to sort the array
        Arrays.sort(arr);
        List<List<Integer>> outer = new ArrayList<>();

        // adding initial empty arraylist in to the outer list
        outer.add(new ArrayList<>());

        int start = 0;
        int end = 0;

        for(int i=0; i<arr.length; i++){
            start = 0;

            // if current elemnt is same as previous elemnt move the start to end + 1
            if(i > 0 && arr[i] == arr[i-1]){
                // move the start pointer
                start = end + 1;
            }
            end = outer.size() - 1;
            int size = outer.size();
            
            for(int j=start; j<size; j++){
                ArrayList<Integer> internal = new ArrayList<>(outer.get(j)); // obtaining ith loop
                internal.add(arr[i]); // appending the current element of the array into the copy of ith outer loop present in the internal

                outer.add(internal);
            }
        }

        return outer;
    }

    static List<List<Integer>> subset(int[] arr){
        List<List<Integer>> outer = new ArrayList<>();

        // adding initial empty arraylist in to the outer list
        outer.add(new ArrayList<>());

        // iterating through each element of the array
        for(int num: arr){
            /*
             * We have to make copy of the outer list so we have to take the size
             * of the outer list.
             */
            int size = outer.size();

            // iterating till the size of the outer list
            for(int i=0; i<size; i++){
                // copying the ith outer loop and adding the current element of the array in it
                ArrayList<Integer> internal = new ArrayList<>(outer.get(i)); // obtaining ith list
                internal.add(num); // appending the current element of the array into the copy of ith outer loop present in the internal

                /*  
                 * At last after making copy of ith outer loop into internal and adding the current 
                 * element of the array into the internal we have to add internal list to the outer loop.
                 */
                outer.add(internal);
            }
        }

        // at this point we have all the subsets
        return outer;
    }
}
