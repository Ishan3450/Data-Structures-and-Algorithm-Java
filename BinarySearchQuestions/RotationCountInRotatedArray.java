package BinarySearchQuestions;

public class RotationCountInRotatedArray {

    public static void main(String[] args){
        // int[] arr = {7, 9, 11, 12, 15};
        int[] arr = {12, 15, 7, 9, 11};

        int pivot = getPivot(arr) + 1;
        System.out.println(pivot);
    }
    
    static int getPivot(int[] arr){
        int start= 0;
        int end = arr.length - 1;

        while(start <= end){
            int mid = start + (end - start) / 2;

            // case 1
            if(mid < end && arr[mid] > arr[mid + 1]){
                return mid;
            }

            // case 2
            if(mid > start && arr[mid] < arr[mid - 1]){
                return mid - 1;
            }

            // case 3
            if(arr[start] > arr[mid]){
                end = mid - 1;
            } else{
                start = mid + 1;
            }

        }

        return -1;
    }
}
