public class KthElementInTwoSortedArrays {
    public long kthElement( int arr1[], int arr2[], int n, int m, int k) {
        // edge cases
        if(n == 0){
            return arr2[k-1];
        }
        if(m == 0){
            return arr1[k-1];
        }
        
        // if not edge case the we have little work to do :)
        int i = 0, j = 0;
        
        while(k != 1 && i < n && j < m){
            if(arr1[i] < arr2[j]){
                i++;
            } else{
                j++;
            }
            k--;
        }
        
        while(k != 1 && i < n){
            i++;
            k--;
        }
        
        while(k != 1 && j < m){ 
            j++;
            k--;
        }
        
        if(i < n && j < m){
            return Math.min(arr1[i], arr2[j]);
        }
        
        if(i >= n && j < m){
            return arr2[j];
        } else{
            return arr1[i];
        }
        
    }
}
