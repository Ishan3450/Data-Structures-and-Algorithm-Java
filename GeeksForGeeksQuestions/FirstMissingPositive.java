public class FirstMissingPositive {
    static int missingNumber(int arr[], int size) {
        boolean isZeroPresent = isZeroThere(arr);
        cyclicSort(arr, size, isZeroPresent);

        for (int i = 0; i < size; i++) {
            int correctIndex;

            // checking which is the correct index value based on is zero there in array or
            // not
            correctIndex = isZeroPresent ? i : i + 1;

            if (arr[i] != correctIndex) {
                return correctIndex;
            }
        }

        // if program stands at this point, means it has found all the correct
        // element,value pair
        // case: 1 2 3 4 5 and 0 1 2 3 4
        // in the case 1: 0 is not present and size is 5 so missing is size+1
        // case2: 0 is present and size is 5 but as 0 is there, missing is size not
        // size+1
        return isZeroPresent ? size : size + 1;
    }

    private static void cyclicSort(int[] arr, int size, boolean zeroFlag) {
        int idx = 0;

        while (idx < size) {
            int correctIndex;

            correctIndex = zeroFlag ? arr[idx] : arr[idx] - 1;

            if (correctIndex >= 0 && correctIndex < size && arr[idx] != arr[correctIndex]) {
                // swap
                int temp = arr[idx];
                arr[idx] = arr[correctIndex];
                arr[correctIndex] = temp;
            } else {
                idx++;
            }
        }
    }

    // method checks wheter 0 is present in the array or not
    private static boolean isZeroThere(int[] arr) {
        for (int elem : arr) {
            if (elem == 0) {
                return true;
            }
        }
        return false;
    }
}
