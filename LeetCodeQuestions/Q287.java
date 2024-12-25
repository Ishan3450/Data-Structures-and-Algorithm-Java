/*
 * Approach is written in the book of DSA notes7
 */
package LeetCodeQuestions;

public class Q287 {
    public static void main(String[] args) {
        int[] arr = { 1, 3, 4, 2, 2 };
        // int[] arr = {3,1,3,4,2};

        System.out.println(findDuplicate(arr));

    }

    static int findDuplicate(int[] arr) {
        int i = 0;

        while (i < arr.length) {

            if (arr[i] != i + 1) {
                // arr[i] - 1 is used because elements are starting from 1 and going to n 
                // * (MENTIONED IN THE QUESTION ) so be careful while reading the question
                int correctIndex = arr[i] - 1;

                if (arr[i] != arr[correctIndex]) {

                    // swap
                    swap(arr, i, correctIndex);
                } else {
                    return arr[i];
                }
            } else{
                i++;
            }

        }

        return -1;
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
