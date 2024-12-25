public class BinarySearchUsingRecursion {
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5};
        int target = 3;
        System.out.println(bs(arr, target, 0, arr.length - 1));
    }

    static int bs(int[] arr, int target, int start, int end) {

        // base condition
        if (start > end) { // element not found
            return -1;
        }
        
        // function body
        int mid = start + (end - start) / 2;

        if (arr[mid] == target) {
            return mid;
        } else if (arr[mid] > target) {
            end = mid - 1;
        } else {
            start = mid + 1;
        }

        // recursive call
        return bs(arr, target, start, end);

    }
}