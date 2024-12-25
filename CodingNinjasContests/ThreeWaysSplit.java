package CodingNinjasContests;

public class ThreeWaysSplit {
    public static long threeWaySplit(int n, int[] arr) {
        int i = 0, j = n - 1;
        long sum1 = 0, sum2 = 0, ans = 0;
        
        // setting up initial values
        sum1 += arr[i];
        sum2 += arr[j];
        
        while(i < j){
            if(sum1 > sum2){
                j--;
                sum2 += arr[j];
            } else if (sum1 < sum2){
                i++;
                sum1 += arr[i];
            } else { // both are same
                ans = sum1;
                i++;
                j--;
                
                sum1 += arr[i];
                sum2 += arr[j];
            } 
        }
        
        return ans;
    }

    public static void main(String[] args){
        int[] arr = {5,1,2,1,4};
        int n = arr.length;

        System.out.println(threeWaySplit(n, arr));
    }
}
