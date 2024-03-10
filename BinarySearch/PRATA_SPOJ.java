package BinarySearch;

public class PRATA_SPOJ {
    public static int getMinimumTimeToMakePratas(int[] arr, int pratas){
        int start = 1, end = 0, ans = -1;
        
        int highestRank = arr[arr.length - 1];
        
        end = highestRank * (pratas * (pratas + 1) / 2); // Generalized formula for sum from 1 till n

        while(start <= end){
            int mid = start + (end - start) / 2;

            if(isPossible(arr, pratas, mid)){
                ans = mid;
                end = mid - 1;
            } else { 
                start = mid + 1;
            }
        }

        return ans;
    }

    public static boolean isPossible(int[] arr, int pratas, int mid) {
        int pCount = 0; // pratas count

        for(int elem: arr){
            int time = 0, j=1;

            while(true){
                if(time + j*elem <= mid){
                    time += j*elem;
                    j++;
                    pCount ++;
                } else {
                    break;
                }

                if(pCount >= pratas){
                    return true;
                }
            }
        }

        return false;
        
    }

    public static void main(String[] args){
        int[] arr = {1};
        int pratas = 8;

        System.out.println(getMinimumTimeToMakePratas(arr, pratas));
    }
}
