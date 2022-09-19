package BinarySearchQuestions;

public class FloorOfANumber {
    public static void main(String[] args){
        int[] arr = {2,3,5,9,14,16,17,18};

        System.out.println(floorOfNumber(arr, 5));

    }

    static int floorOfNumber(int[] arr, int target){
        int start = 0;
        int end = arr.length - 1;

        // what if the target is smaller than the smallest element of the array
        if(target < arr[start]){
            return -1;
        }

        int mid = start + (end - start) / 2;

        while(start <= end){
            // * Condition 1
            if(target == arr[mid]){
                break;
            } else if(target > arr[mid]){
                start = mid + 1;
            } else {
                end = mid - 1;
            }

            mid = start + (end - start) / 2;
        }
        // when the loop condition violates we have to return the smaller number or equal to the target which will reside at end pointer
        return arr[end];
    }
}
