import java.util.Arrays;

public class MoveAllNegativeElmenentsToLeft {
    public static void moveNegatives(int[] arr){
        int n = arr.length;

        int left = 0, right = n - 1;

        while(left < right){
            int leftElement = arr[left];
            int rightElement = arr[right];
            
            if(leftElement < 0 && rightElement < 0){ // for both are negatives
                left ++;
            } else if(leftElement > 0 && rightElement < 0){
                swap(arr, left, right);
                left ++;
                right --;
            } else if(leftElement > 0 && rightElement > 0){
                right --;
            } else {
                left ++;
                right --;
            }

        }
    }

    public static void swap(int arr[], int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args){
        int[] arr = { -12, 11, -13, -5, 6, -7, 5, -3, 11 };
        
        moveNegatives(arr);        

        System.out.println(Arrays.toString(arr));
    }
}
