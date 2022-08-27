package GeeksForGeeksQuestions;

import java.util.ArrayList;
import java.util.Arrays;

public class FindDuplicatesInArray {
    public static void main(String[] args) {
        // int n = 5;
        // int[] a = { 2, 3, 1, 2, 3 };

        int n = 26;
        int[] a = {13, 9, 25, 1, 1, 0, 22, 13, 22, 20, 3, 8, 11, 25, 10, 3, 15, 11, 19, 20, 2, 4, 25, 14, 23, 14};

        System.out.println(duplicates(a, n));

    }

    static ArrayList<Integer> duplicates(int arr[], int n) {
        // code here
        sort(arr);
        System.out.println(Arrays.toString(arr));

        ArrayList<Integer> ans = new ArrayList<Integer>();

        for (int i = 0; i < arr.length; i++) {
            
            // System.out.println("Checking for Index : " + i + " and " + correctIndex);
            // System.out.println("Checking for value : " + arr[i] + " and " + arr[correctIndex]);
            // System.out.println("------------------------------------------------------------------");
            if (arr[i] != i && !isExists(ans, arr[i])) {
                ans.add(arr[i]);
            }
        }

        if (ans.isEmpty()) {
            ans.add(-1);
        }

        return ans;

    }

    static void sort(int[] arr) {
        int i = 0;

        while (i < arr.length) {
            int correctIndex = arr[i];

            if (arr[i] != arr[correctIndex]) {
                swap(arr, i, correctIndex);
            } else {
                i++;
            }
        }
    }

    static void swap(int[] arr, int j, int k) {
        int temp = arr[j];
        arr[j] = arr[k];
        arr[k] = temp;
    }

    static boolean isExists(ArrayList<Integer> arr, int target){
        for(int num: arr){
            if(num == target){
                return true;
            }
        }

        return false;
    }
}
