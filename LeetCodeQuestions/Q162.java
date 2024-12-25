/*
 * NOTE: Exact same question as Q852 not even changing a single word of the code
 * 
 * 162. Find Peak Element
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
 */

package LeetCodeQuestions;

public class Q162 {
    
    public int findPeakElement(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        
        
        while(start < end){
            int mid = start + (end - start) / 2;

            if(nums[mid] > nums[mid + 1]){ // we are in decreasing part
                end = mid;
            } else { // we are in increasing part
                start = mid + 1;
            }
            
        }
        
        return start; // or return end; as both pointers are pointing to the same element which is peak element of that array
        
    }
}
