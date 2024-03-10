package Queues;

import java.util.*;

public class MaximumElementInKSizeWindow {
    public static ArrayList<Integer> maxElementInKSizeWindow(int[] arr, int n, int k){
        Deque<Integer> dq = new LinkedList<>();
        ArrayList<Integer> ans = new ArrayList<>();

        // first get the answer for first window
        for(int i=0; i<k; i++){
            if(dq.isEmpty()){
                dq.addLast(i);
            } else if(arr[i] > arr[dq.getFirst()]){
                dq.removeFirst();
                dq.addLast(i);
            }
        }

        if(dq.size() > 0){
            ans.add(arr[dq.getFirst()]);
        } else{
            ans.add(0);
        }

        // now process rest of the window
        for(int i = k; i<n; i++){
            // remove the out of the curr window elements
            if(!dq.isEmpty() && i-dq.getFirst() >= k){
                dq.removeFirst();
            }

            if(dq.isEmpty()){
                dq.addLast(i);
            } else if(arr[i] > arr[dq.getFirst()]){
                dq.removeFirst();
                dq.addLast(i);
            }

            if(dq.size() > 0){
                ans.add(arr[dq.getFirst()]);
            } else{
                ans.add(0);
            }
        }

        return ans;
    }

    public static void main(String[] args){
        // int[] arr = {2, 5, -1, 7, -3, -1, -2};
        int[] arr = {1,3,1,2,0,5};
        int n = arr.length;
        int k = 3;
        System.out.println(maxElementInKSizeWindow(arr, n, k));
    }
}
