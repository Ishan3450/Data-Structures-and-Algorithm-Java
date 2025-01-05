package Arrays;

public class CountAllTripletsWithGivenSumInSortedArray {
     public int countTriplets(int[] arr, int target) {
        int count = 0;
        
        for(int i = 0 ; i < arr.length ; i ++) {
            int j = i+1;
            int k = arr.length - 1;
            
            while(j < k) {
                int sum = arr[i] + arr[j] + arr[k];
                
                if(sum == target) {
                    count ++;
                    int temp = j + 1;
                    
                    // putting this loop as duplicates can be there
                    while(temp < k && arr[temp] == arr[temp-1]) {
                        count ++;
                        temp ++;
                    }
                    k --;
                } else if(sum > target) {
                    k --;
                } else {
                    j ++;
                }
            }
        }
        return count;
    }
}
