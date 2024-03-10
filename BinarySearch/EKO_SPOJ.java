/*
* Sphere online judge question
* https://www.spoj.com/problems/EKO/
! Take long instead of int as on the platform the input is bigger than the limit of the integer
*/

package BinarySearch;

public class EKO_SPOJ{
    public static int getMaximumMinimumHeightForSaw(int[] arr, int n, int woods){
        int start = arr[0], end = 0, ans = -1;

        for(int elem: arr){
            start = Math.min(start, elem);
            end = Math.max(end, elem);
        }

        while(start <= end){
            int mid = start + (end - start) / 2;

            // System.out.println(start + " " + mid + " " + end);

            if(isPossible(arr, woods, mid)){
                // System.out.println("Possible: " + start + " " + mid + " " + end);
                ans = mid;
                start = mid + 1;
            } else{
                end = mid - 1;
            }
        }

        return ans;
    }

    public static boolean isPossible(int[] arr, int woods, int mid){
        int sum = 0;

        for(int elem: arr){
            if(elem < mid){ // we have to ignore if elem is smaller than the mid
                continue;
            }

            int diff = elem - mid;

            // System.out.println("Diff of " + mid + " and " + elem + " is " + diff);
            
            sum += diff;

            if(sum >= woods){
                return true;
            }
        }
    
        return false;
    }

    public static void main(String[] args){
        int[] arr = {4, 42, 40, 26, 46};
        int n = arr.length;
        int woods = 20;

        System.out.println(getMaximumMinimumHeightForSaw(arr, n, woods));
    }
}