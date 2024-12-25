public class UnboundedBinarySearch {
    public static void main(String[] args) {
        int[] arr = { 2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34, 36, 38, 40 };

        int target = 26;
        int result = unboundedBinarySearch(arr, target);

        if (result != -1) {
            System.out.println("Element " + target + " found at index " + result);
        } else {
            System.out.println("Element not found in the array.");
        }
    }

    public static int unboundedBinarySearch(int[] arr, int target) {
        int left = 0;
        int right = 1;

        // Keep doubling the range until we find an element greater than the target.
        while (arr[right] < target) {
            left = right;
            right *= 2;
        }

        // Perform binary search within the found range.
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        // Element not found.
        return -1;
    }
}
