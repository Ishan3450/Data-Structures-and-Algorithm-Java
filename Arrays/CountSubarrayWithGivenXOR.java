package Arrays;

import java.util.HashMap;

public class CountSubarrayWithGivenXOR {
    public long subarrayXor(int arr[], int k) {
        // val -> occr
        HashMap<Long, Long> trackOccr = new HashMap<>();
        trackOccr.put(0L, 1L);
        
        long runningXor = 0;
        long subarrayCount = 0;
        
        for(int i = 0 ; i < arr.length ; i ++) {
            runningXor ^= arr[i];
            
            long targetXor = runningXor ^ k;
            if(trackOccr.containsKey(targetXor)) {
                subarrayCount += trackOccr.get(targetXor);
            }
            
            trackOccr.put(runningXor, trackOccr.getOrDefault(runningXor, 0L) + 1);
        }
        return subarrayCount;
    }
}
