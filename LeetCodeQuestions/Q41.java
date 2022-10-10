/* 
 * LeetCode Hard Question
 * 
 * 41. First Missing Positive 
 * 
 * - take the input array
 * - we have to find the smallest missing positive element
 * - NOTE : we have to ignore all the elements which are < 0(negative) and > length of the array
 * - then first run the cyclic sort algo
 * - then return the first mis aligning element from the sorted array
 */

package LeetCodeQuestions;

public class Q41 {
    public static void main(String[] args) {
        // int[] arr = { 3, 4, -1, 1 };
        int[] arr = {7,8,9,11,12}; // will return 1 as 1 is the smallest positive answer

        System.out.println(firstMissingPositive(arr));
    }

    static int firstMissingPositive(int[] arr){
        // 1st sort the array
        sort(arr);

        // 2nd find the 1st smallest positive missing element
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] != i+1){
                // we found our answer
                return i+1;
            }
        }

        // returning arr.length + 1 because if the array is like : {1,2,3}
        // then the missing element will be the total length of the array which will be 3 + 1 so it will give 4 as a missing element
        return arr.length + 1;
    }

    static void sort(int[] arr){
        int i = 0;

        while(i < arr.length){
            int correctIndex = arr[i] - 1;

            // we have to ignore the -ve elements and also the elements which are greater than arr.length
            if(arr[i] > 0 && arr[i] <= arr.length && arr[i] != arr[correctIndex]){
                // swap
                swap(arr, i, correctIndex);
            } else{
                // move the pointer forward
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
