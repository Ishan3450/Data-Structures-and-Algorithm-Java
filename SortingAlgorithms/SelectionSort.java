package SortingAlgorithms;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args){
        int[] arr = {3,4,2,1};        

        sort(arr, arr.length, 0, 0);

        System.out.println(Arrays.toString(arr));
    }

    /*
     *@params: i for the end pos and j for the iteration
     */
    static void sort(int[] arr, int i, int j, int maxElementIndex){
        // base condition
        if(i == 0){
            return;
        }

        // function body + recursive condition
        if(j < i){
            // IMP: This Condition will get the max element index
            if(arr[j] > arr[maxElementIndex]){
                sort(arr, i, j+1, j);
            } else{
                sort(arr, i, j+1, maxElementIndex);
            }
        } else{
            // IMP: after getting the maxElementIndex we will have to swap it with the last one
            swap(arr, maxElementIndex, i - 1); // i-1 because we are setting the initial value of i to the length of the array
            // after swapping reset the j and maxElementIndex
            sort(arr, --i, 0, 0);
        }
    }

    static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
