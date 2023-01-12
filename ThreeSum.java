/*
 * Solved with the 2 pointer approach
 * somewhat used the binary search approach so the array must be in the sorted order
 */

import java.util.*;
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        Set<List<Integer>> ans = new HashSet<>();

        for(int i=0; i<n; i++){
            int j = i + 1;
            int k = n - 1;

            while(j < k){
                int sum = arr[i] + arr[j] + arr[k];

                if(sum == 0){
                    List<Integer> list = new ArrayList<>();
                    list.add(arr[i]);
                    list.add(arr[j]);
                    list.add(arr[k]);
                    ans.add(list);
                    j++;
                } else if(sum > 0){
                    k --;
                } else{
                    j++;
                }
            }
        }

        return new ArrayList<>(ans);
    }
}
