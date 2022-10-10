package CodingNinjasQuestions;

import java.util.Arrays;

public class MindBendingProduct {
    public static void main(String[] args){
        int[] arr = {1,2,3,4,5};

        System.out.println(Arrays.toString(getProductArray(arr, arr.length)));
    }

    public static long[] getProductArray(int arr[], int n) {
        // Write your code here.
        long[] ans = new long[n];
        long product = getProduct(arr, n);

        for(int i=0; i<n; i++){
            ans[i] = product/arr[i];
        }

        return ans;
    }

    static long getProduct(int arr[], int n){
        long product = 1;
        for(int i=0; i<n; i++){
            product *= arr[i];
        }
        return product;
    }
}
