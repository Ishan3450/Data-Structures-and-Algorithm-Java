import java.util.Arrays;

public class CyclicSort {
    public static void main(String[] args){
        int[] arr = {5,4,3,2,1}; // worst case array    

        cyclicSort(arr);
    }

    static void cyclicSort(int[] arr){
        int i = 0;

        while(i < arr.length){
            int correctIndex = arr[i] - 1;

            if(arr[i] != arr[correctIndex]){
                // swap
                swap(arr, i, correctIndex);
            } else{
                // move forward
                i++;
            }
        }

        System.out.println(Arrays.toString(arr));
    }

    static void swap(int[] arr, int i, int correctIndex){
        int temp = arr[i];
        arr[i] = arr[correctIndex];
        arr[correctIndex] = temp;
    }
}
