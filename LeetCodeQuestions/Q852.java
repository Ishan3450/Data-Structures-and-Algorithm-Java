/*
 * 852. Peak Index in a Mountain Array
 * 
 * Self Approach (Bruteforce Approach)
 *  - first take the input array
 *  - array is guaranteed to be a mountaine or bitonic array
 *  - apply binary search to the array
 *  - set the start and end pointers
 *  - get the mid element of the array
 *  - now check :
 *       if mid element is > mid + 1 && also mid element is > mid - 1
 *           then we found the peak element and return the index i.e mid
 *       else check if mid element < mid + 1
 *           then increase mid element to 1 (mid += 1)
 *       else check if mid element mid element < mid - 1
 *           then move the mid pointer to left shift by 1 (mid -= 1)
 * 
 * Second Approach (Optmized O(log n) solution)
 *  - first take the array
 *  - array is guaranteed to be a mountaine or bitonic array
 *  - apply binary search to the array
 *  - set the start and end pointers
 *  - get the mid element of the array
 *  - now check :
 *      NOTE: there are two parts of an mountain array 1 is increasing and 2 is decreasing
 * 
 *      if mid element is < mid + 1 element then we are in the increasing part of the array
 *          then move the start to mid + 1 // mid+1 as we know that we are in increasing part
 *      else if mid element > mid + 1 then we are in decresing part of the array
 *          then move the end to the mid pointer
 * 
 *      NOTE : above two checks are gonna give us the answer
 * 
 */     

package LeetCodeQuestions;

public class Q852 {
    
    // * brute force approach
    // public int peakIndexInMountainArray(int[] arr) {
    //     int start = 0;
    //     int end = arr.length - 1;

    //     int mid = start + (end - start) / 2;

    //     while(start <= end){
    //         if(arr[mid] > arr[mid + 1] && arr[mid] > arr[mid - 1]){
    //             return mid;
    //         } else if(arr[mid] < arr[mid + 1]){
    //             mid += 1;
    //         } else if(arr[mid] < arr[mid - 1]){
    //             mid -= 1;
    //         }
            
    //     }
    //     return -1;
    // }

    public int peakIndexInMountainArray(int[] arr){
        int start = 0;
        int end = arr.length - 1;

        while(start < end){
            // declared mid here bacause we are just gonna play with the start and end pointers
            int mid = start + (end - start) / 2;

            if(arr[mid] > arr[mid + 1]){ 
                // we are in the decreasing part as [1,2,5,2,1] => 5 > 2 so the right side part of the 5 will be removed
                // and end pointer will be pointing at the position of mid element
                end = mid;
            } else{
                // we are in the increasing part as [1,2,5,7,2,1] => 5 < 7 so the left side part of the 7 will be removed
                // so now the start poitner will be pointing at the mid + 1 element position
                start = mid + 1;
            }
        }

        // if we are here then is states that now start and end both the pointer are pointing at the peak element of the array
        return start; // or return end as both pointers are pointing at the same element which is peak element
    }
}
