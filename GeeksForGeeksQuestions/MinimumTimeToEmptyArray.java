/*
 * TC: O(N log N)
 * SC: O(N)
 */

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MinimumTimeToEmptyArray {
    public static int minimumTime(int n, int[] arr) {
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0 ; i < n; i++){
            q.add(arr[i]);
        }
        Arrays.sort(arr);
        int idx = 0;
        int totalTime = 0;
        while(!q.isEmpty() && idx < arr.length){
            if(arr[idx] == q.peek()){
                idx ++;
                q.remove();
            } else{
                q.add(q.remove());
            }
            totalTime++;
        }
        return totalTime;
    }
}
