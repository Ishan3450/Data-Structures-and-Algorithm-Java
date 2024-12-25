package Recursion;

public class CountInversionUsingInPlaceMergeSort {
    static long inversions = 0;

    // put this static block because declared inverions as static so every tiem the
    // instance of this class runs it will continue to count from where it left from
    // previous time
    {
        inversions = 0;
    }

    static long inversionCount(long arr[], long N) {
        mergeSort(arr, 0, arr.length - 1);
        return inversions;
    }

    private static void mergeSort(long[] arr, int start, int end) {
        // base condition
        if (start == end) {
            return;
        }

        // function body
        int mid = start + (end - start) / 2;

        mergeSort(arr, start, mid);
        mergeSort(arr, mid + 1, end);

        merge(arr, start, mid, end);
    }

    private static void merge(long[] arr, int start, int mid, int end) {
        long[] merged = new long[end - start + 1];
        int idx = 0;

        int i = start;
        int j = mid + 1;

        while (i <= mid && j <= end) {
            if (arr[i] <= arr[j]) {
                merged[idx++] = arr[i++];
            } else {
                inversions += (mid + 1) - i; // ** Main formula
                merged[idx++] = arr[j++];
            }
        }

        while (i <= mid) {
            merged[idx++] = arr[i++];
        }

        while (j <= end) {
            merged[idx++] = arr[j++];
        }

        for (int k = 0; k < merged.length; k++) {
            arr[start + k] = merged[k];
        }
    }
}
