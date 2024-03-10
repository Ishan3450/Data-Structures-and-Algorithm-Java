/*
 * LeetCode: 34 Medium Question
 */

package BinarySearch;

import java.util.ArrayList;

public class FindFirstAndLastOccurrences {
    public static void main(String[] args){
        long[] arr = {1,2,3,7,7,7,7,8,8,9,10};

        System.out.println(find(arr, arr.length, 7));

    }

    static ArrayList<Long> find(long arr[], int n, int x){
        // code here
        ArrayList<Long> ans = new ArrayList<>();

        ans.add(bs(arr, n, x, true));

        if(ans.get(0) != -1){
            ans.add(bs(arr, n, x, false));
        } else{
            ans.add(-1L);
        }

        return ans;

    }

    static long bs(long arr[], int n, int x, boolean findLeft){
        long ans = -1;
        int start = 0;
        int end = n - 1;

        while(start <= end){
            int mid = start + (end - start) / 2;

            if(arr[mid] > x){
                end = mid - 1;
            } else if(arr[mid] < x){
                start = mid + 1;
            } else{
                ans = mid; // this is out potential answer

                // now checking whether we are finding leftmost or rightmost
                if(findLeft){
                    end = mid - 1;
                } else{
                    start = mid + 1;
                }
            }
        }

        return ans;
    }

}
