/*
 * Simplest way to find the peak element or pivot element from a mountain array or bitonic array
 */

import java.util.ArrayList;
public class PeakElement {
    public static void main(String[] args){
        ArrayList<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(2);
        list.add(1);

        System.out.println(findPeak(list.size(), list));
    }

    public static int findPeak(int n, ArrayList<Integer> arr) {
        // Write your code here.
        int start = 0;
        int end = n - 1;
        
        while(start < end){
            int mid = start + (end - start) / 2;
            
            if(arr.get(mid) < arr.get(mid+1)){
                start = mid + 1;
            } else{
                end = mid;
            }
        }
        return arr.get(start); // or return end
    }
}
