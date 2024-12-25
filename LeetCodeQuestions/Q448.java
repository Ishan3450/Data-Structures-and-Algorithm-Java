/*
 * 448. Find All Numbers Disappeared in an Array
 * 
 * - first get the input array
 * - there will be 3 methods:
 *      1: swap: to swap two element
 *      2: sort: to sort the array
 *          - in sort there will be 3 conditions
 *          - 1: if the element at the index == the value at the index it means it is the duplicate element then move forward the pointer
 *          - Rest two coditions are same as cyclic sort 
 *      3: the findDisappearedNums function in this function:
 *          - 1st we will sort the array
 *          - and run the loop and check that if the element at the index is == to the index if not then return the elements
 */

package LeetCodeQuestions;

import java.util.ArrayList;
import java.util.List;

public class Q448 {
    public static void main(String[] args){
        int[] arr = {4,3,2,7,8,2,3,1};
        // int[] arr = {1,1};

        System.out.println(findMissingNumber(arr));
    }

    static List<Integer> findMissingNumber(int[] arr){
        List<Integer> ans = new ArrayList<Integer>();

        // sort the array first of all
        sort(arr);

        for(int index=0; index<arr.length; index++){
            if(arr[index] != index + 1){
                ans.add(index+1);
            }
        }

        return ans;
    }

    static void sort(int[] arr){
        int i = 0;

        while(i < arr.length){
            // arr[i] - 1 is used because elements are starting from 1 and going to n (* MENTIONED IN THE QUESTION)
            int correctIndex = arr[i] - 1;

            if(arr[i] != arr[correctIndex]){
                // swap
                swap(arr, i, correctIndex);
            } else{
                i++;
            }
        }
    }

    static void swap(int[] arr, int i1, int i2){
        int temp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = temp;
    }
}
