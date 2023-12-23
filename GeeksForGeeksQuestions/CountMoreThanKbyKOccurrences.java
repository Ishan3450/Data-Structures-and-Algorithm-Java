import java.util.HashMap;

public class CountMoreThanKbyKOccurrences {
        public int countOccurence(int[] arr, int n, int k) 
    {
        int maxOccr = n / k;
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        
        for(int i = 0; i < n; i++){
            if(map.containsKey(arr[i]) && map.get(arr[i]) + 1 == maxOccr+1){
                count ++;
            }
            map.put(arr[i], map.getOrDefault(arr[i],0) + 1);
        }
        
        
        return count;
    }

}
// INPUT:
// 15
// 7 8 9 9 9 6 0 9 2 2 9 1 0 5 8
// 15

// 7 1
// 8 2
// 9 5
// 6 1
// 0 2
// 2 2
// 1 1
// 5 1
