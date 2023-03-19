package LeetCodeQuestions;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Q658{
    /*
     * Two Pointer Approach:
     * 
     * Time Complexity: As we are going from n to the k window time
     *      time complexity will be O(n-k)
     * Space: O(k) to return the answer asked by the question
     * 
     * Top-to-Bottom appraoch as we are moving from the start,end till k sized array
     */
    public List<Integer> twoPtrMethod(int[] arr, int k, int x) {
        List<Integer> list = new ArrayList<>();

        int i = 0, j = arr.length - 1;

        while(((j - i) + 1) != k){
            int iDiff = Math.abs(x - arr[i]);
            int jDiff = Math.abs(x - arr[j]);

            if(iDiff <= jDiff){
                j--;
            } else{
                i++;
            }
        }

        for(int itr=i; itr<=j; itr++){
            list.add(arr[itr]);
        }

        return list;
    }

        /*
         * Method 2: Binary Search method
         * 
         * Bottom-to-Top appraoch as we are moving from the lower bound to the k sized array
         * 
         */
        public int lowerBound(int[] arr, int x){
            int start = 0, end = arr.length - 1;
    
            while(start < end){
                int mid = start + (end - start)/ 2;
    
                if(arr[mid] == x){
                    return mid;
                }
    
                if(arr[mid] > x){
                    end = mid;
                } else{
                    start = mid + 1;
                }
            }
    
            return end;
        }
        public List<Integer> bsMethod(int[] arr, int k, int x) {
            int high = lowerBound(arr, x);
            int low = high - 1;
    
            while(k-- != 0){
                if(low < 0){
                    high ++;
                } else if(high >= arr.length){
                    low --;
                } else if(Math.abs(x - arr[low]) > Math.abs(x - arr[high])){
                    high ++;
                } else{
                    low --;
                }
            }
    
            List<Integer> list = new ArrayList<>();
    
            for(int i = low+1; i < high; i++){
                list.add(arr[i]);
            }
    
            return list;
        }
    
    public static void main(String[] args){

    }
}