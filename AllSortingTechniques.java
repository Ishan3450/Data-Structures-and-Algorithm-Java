import java.util.Arrays;

public class AllSortingTechniques {
    public static void SelectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int idx = i;

            // getting the minimum element
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[idx]) {
                    idx = j;
                }
            }

            // swap
            swap(arr, i, idx);
        }

        print(arr);
    }

    public static void BubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            boolean isSwapped = false;
            for (int j = 1; j < arr.length - i; j++) {
                // swap
                if (arr[j] < arr[j - 1]) {
                    swap(arr, j, j - 1);
                    isSwapped = true;
                }
            }

            if (!isSwapped) { // array is sorted
                break;
            }
        }

        print(arr);
    }

    public static void InsertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            // step 1 : store the value
            int val = arr[i];

            // step 2 : get the correct index
            int j = 0;

            while (j < i && arr[j] < val) {
                j++;
            }

            // step 3 : shifting
            for (int k = i - 1; k >= j; k--) {
                arr[k + 1] = arr[k];
            }

            // step 4 : placing the value
            arr[j] = val;
        }

        print(arr);
    }

    // general functions
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void print(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        SelectionSort(new int[] { 5, 4, 2, 1, 7, 6 });
        BubbleSort(new int[] { 5, 4, 2, 1, 7, 6 });
        InsertionSort(new int[] { 5, 4, 2, 1, 7, 6 });

    }
}
