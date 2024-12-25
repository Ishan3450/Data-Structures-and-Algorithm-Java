package LeetCodeQuestions;

import java.util.Arrays;

public class Q238 {
    public static void main(String[] args){
        int[] arr = {-1, 1, 0, -3, 3};

        System.out.println(Arrays.toString(productExceptSelf(arr)));
    }

    static int[] productExceptSelf(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        int product = getProduct(arr, n);

        for(int i=0; i<n; i++){
            if(arr[i] == 0){
                ans[i] = product;
            } else{
                ans[i] = product/arr[i];
            }
        }

        return ans;   
    }
    
    static int getProduct(int arr[], int n){
        int product = 1;
        for(int i=0; i<n; i++){
            product *= arr[i];
        }
        return product;
    }
}
