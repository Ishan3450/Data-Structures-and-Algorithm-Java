import java.util.Arrays;

public class Sort0s1s2s{
    public static void sort012(int a[], int n)
    {
        /*
         * itr -> loop iterator
         * placer -> tells where to place the to swap element
         * end -> tells the last swappable position of the array
         * 
         * Approach:
         * - in this approach 0s will be moved at the first as when pointer points a zero it will swap it with the placer position
         * - 1s will be kind of ignored as when pointer points 1 the pointer will be moved forward
         * - 2s will be tracked using the end which tells the last swappable position
         */
        int itr = 0, placer = 0, end=n-1;
        
        while(itr <= end){
            if(a[itr] == 0){
                swap(a, itr, placer);
                itr ++;
                placer ++;
            } else if(a[itr] == 1){
                itr ++;
            } else{ // we found 2
                swap(a, itr, end);
                end --;
            }
        }
    }
    
    public static void swap(int arr[], int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void main(String[] args){
        int arr[] = {0,2,1,2,0};

        sort012(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }
}