package SlidingWindow;

import java.util.HashMap;

public class CountNumberOfNiceSubarrays{
    // approach 2 (better appraoch)
    public int numberOfSubarrays(int[] nums, int k) {
        int oddCount = 0;
        int prevCount = 0; // prevCount is used in case if the window is expanded or shrinked but the odd count remained same (in case if even number got added or removed from the window)
        int niceSubarrays = 0;

        int i = 0, j = 0;

        while(j < nums.length){
            if((nums[j] & 1) == 1){
                oddCount ++;
                prevCount = 0;
            }

            while(oddCount == k){
                prevCount ++;

                if((nums[i] & 1) == 1){
                    oddCount --;
                }
                i ++;
            }

            niceSubarrays += prevCount;
            j ++;
        }
        return niceSubarrays;
    }

    // approach 1
    public int numberOfSubarrays_extraSpace(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>(); // oddCount -> count
        map.put(0, 1); // storing count instead of index to get total subarrays with correcponsing oddCount

        int oddCount = 0;
        int niceSubarrays = 0;

        for(int i = 0 ; i < nums.length ; i ++){
            if((nums[i]&1) == 1){
                oddCount ++;
            }

            map.put(oddCount, map.getOrDefault(oddCount, 0) + 1);

            if(map.containsKey(oddCount - k)){
                niceSubarrays += map.get(oddCount - k);
            }
        }

        return niceSubarrays;
    }
}
