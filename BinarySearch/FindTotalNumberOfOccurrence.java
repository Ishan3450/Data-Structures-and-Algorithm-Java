package BinarySearch;

public class FindTotalNumberOfOccurrence {
    public static void main(String[] args){
        int[] arr = {1,2,2,2,2,3,3,3,3,3,3,3,3,3,4,5,6};
        int n = arr.length;
        int x = 3;

        System.out.println("Occr: " + findTotalOccr(arr, n, x));
    }

    private static int findTotalOccr(int[] arr, int n, int x) {
        int leftMost = bs(arr, n ,x, true);
        int rightMost = bs(arr, n, x, false);

        return rightMost - leftMost + 1;
    }

    private static int bs(int[] arr, int n, int x, boolean isGoingLeft) {
        int start = 0, end = n - 1;
        int ans = -1;

        while(start <= end){
            int mid = start + (end - start) / 2;

            if(arr[mid] > x){
                end = mid - 1;
            } else if(arr[mid] < x){
                start = mid + 1;
            } else{
                ans = mid;

                if(isGoingLeft){
                    end = mid - 1;
                } else{
                    start = mid + 1;
                }
            }
        }

        return ans;
    }
}
