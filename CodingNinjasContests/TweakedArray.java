package CodingNinjasContests;

public class TweakedArray {
    public static int[] tweakTheArray(int arr[],int n) {
        int sum = 0;
        
        for(int elem: arr){
            sum += elem;
        }
        
        for(int i=0; i<n; i++){
            arr[i] = sum - arr[i];
        }
        
        return arr;
    }
}
