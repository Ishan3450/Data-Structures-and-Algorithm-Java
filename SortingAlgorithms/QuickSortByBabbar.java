/*
 * QuickSort is nothing but parition and recursive logic.
 * 
 * Partition logic is responsible to place the pivot element at its right position, in which all the elements to the left of the pivot will be smaller than the pivot and all the elemnets to the right of the pivot will be greater than the pivot.
 * Recursive logic is responsible to sort the left part of the pivot element and right part of the pivot element.
 * TC: O(NLogN) Average Case Complexity
 *
 * Approach: 
 * - initially consider element at low as pivot
 * - then count from low+1 till high the elements less than or equal to '<=' value of pivot element
 * - then swap the pivot with the (LOW+COUNT) index. (adding low to the count beause of we are calling the right part also for the sorting in the recursive call)
 * - then place i at low and j at high and keep getting close to pivot index till:
 *        -- element at i is greater than the pivot value
 *        -- element at j is smaller than the pivot value
 * - if i != j means above 2 sub conditions of i and j meets true and swap those elements at i with j and vise-versa
 * - if i == j means no wrong element is found and then return the new index of the pivot i.e LOW+COUNT
 * - then time for recursive calls:
 *  - Left recursive call: leftCall(arr, low, pivotIndex-1)
 *  - Right recursive call: rightCall(arr, pivotIndex+1, high)
 * 
 * - Base conditions: if low == high or low > high => (low >= high) then simply return;
 */
package SortingAlgorithms;

import java.util.Arrays;

public class QuickSortByBabbar {
    public static void main(String[] args) {
        int[] arr = { 2, 1, 6, 10, 4, 1, 3, 9, 7 };
        int start = 0, end = arr.length - 1;

        quickSort(arr, start, end);
        System.out.println(Arrays.toString(arr));
    }

    static void quickSort(int arr[], int low, int high) {
        // base condition
        if (low >= high) {
            return;
        }

        // function body

        // getting the right index to place the pivot
        int rightIndexForPivot = partition(arr, low, high);

        // recursive call
        quickSort(arr, low, rightIndexForPivot - 1);
        quickSort(arr, rightIndexForPivot + 1, high);

    }

    static int partition(int arr[], int low, int high) {
        // your code here

        // initially considering pivot as first element of the array
        int pivotValue = arr[low];
        int pivotIndex = low;

        // finding right place for the pivot element
        int count = 0;

        for (int i = low + 1; i <= high; i++) {
            if (arr[i] <= pivotValue) {
                count++;
            }
        }

        // swap the pivot with its correct index
        int rightIndex = low + count;

        swap(arr, low, rightIndex);

        // updating the new index of the pivot
        pivotIndex = rightIndex;

        // check for the left and right elements from the pivot
        int i = low, j = high;

        while (i < pivotIndex && j > pivotIndex) {
            while (i < pivotIndex && arr[i] <= pivotValue) {
                i++;
            }

            while (j > pivotIndex && arr[j] > pivotValue) {
                j--;
            }

            if (i != j) {
                swap(arr, i, j);
            }
        }

        return pivotIndex;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
