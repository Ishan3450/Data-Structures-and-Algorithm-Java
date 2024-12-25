/*
 * Self Implemented Logic solved using Binary Search
 */

public class FindTransitionPoint {
    static int transitionPoint(int arr[], int n) {
        // edge cases
        if(arr[0] == 1){
            return 0;
        }
        
        if(arr[n-1] == 0){
            return -1;
        }
        
        int start = 0;
        int end = n-1;
        
        while(start <= end){
            int mid = start + (end - start) / 2;
            
            if(arr[mid] == 1 && arr[mid-1] == 1){
                end = mid - 1;
            } else if(mid > 0 && (arr[mid] == 1 && arr[mid - 1] == 0)){
                return mid;
            } else if(mid < n-1 && arr[mid] == 0 && arr[mid + 1] == 1){
                return mid + 1;
            } else{
                start = mid + 1;
            }
        }
        
        return end;
    }

    public static void main(String[] args){
        int[] arr = {0,0,0,1};

        System.out.println(transitionPoint(arr, arr.length));
    }
}
