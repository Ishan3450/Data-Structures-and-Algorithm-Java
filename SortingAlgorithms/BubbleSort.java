package SortingAlgorithms;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args){
        int[] arr = {4,3,1,2};

        sort(arr, arr.length-1, 0);

        System.out.println(Arrays.toString(arr));
    }

    static void sort(int[] arr, int i, int j){
        // base condition
        if(i == 0){
            return;
        }

        // function body
        if(j < i){
            if(arr[j] > arr[j+1]){
                swap(arr, j, j+1);
            }
            sort(arr, i, ++j);
        } else{
            sort(arr, --i, 0);
        }
    }

    static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
