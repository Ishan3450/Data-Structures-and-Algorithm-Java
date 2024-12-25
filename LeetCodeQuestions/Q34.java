/*
 * 34. Find First and Last Position of Element in Sorted Array
 * for o(n) complexity function searchRange
    * - take the input target and array
    * - algorithm complexity must be O(log n) but here I have used bruteforce approach
    * - set the start and end pointer
    * - apply binary search 
    * - set the isFound boolean vars to check either start or end pointer found the target or not
    * - if target found at the start pointer then add the position of the start pointer in an array
    * - and if target found at end pointer then add the position of the end pointer in that array
    * - I have solved this question with binary search but not using the mid pointer

 * for o(log n) compelxity function searchRangeOptimized
    * for this we will basically run the binary search twice to get the left-most or right-most target's index
 */

package LeetCodeQuestions;

import java.util.Arrays;

public class Q34 {
    public static void main(String[] args){
        int[] arr = {5,7,7,8,8,10};
        int target = 7;

        System.out.println(Arrays.toString(searchRangeOptimized(arr, target)));
    }

    // * this searchRange function runs on o(n) complexities
    static int[] searchRange(int[] nums, int target) {
        int[] ans = {-1,-1};

        int start = 0; 
        int end = nums.length - 1;


        boolean startPosFound = false;
        boolean endPosFound = false;

        while(start <= end){
            if(startPosFound && endPosFound){
                break;
            }

            if(target == nums[start] && !startPosFound){
                ans[0] = start;
                startPosFound = true;
            } 
            if(target == nums[end] && !endPosFound){
                ans[1] = end;
                endPosFound = true;
            }

            if(!startPosFound){
                start ++;
            }
            if(!endPosFound){
                end --;
            }
            
            // System.out.println("Start: " + start);
            // System.out.println("End: " + end);
        }

        return ans;
    }

    // * o(log n) complexity by using two binary searches
    static int[] searchRangeOptimized(int[] nums, int target) {
        int[] ans = {-1, -1};
        

        ans[0] = searchIndex(nums, target, true);

        if(ans[0] != -1){
            ans[1] = searchIndex(nums, target, false);
        }
                
        return ans;
    }
    
    static int searchIndex(int[] nums, int target, boolean isFindingStartIndex){
        int ans = -1;
        int start = 0;
        int end = nums.length - 1;
        
        int mid = start + (end - start) / 2;
        
        while(start <= end){
            
            if(target < nums[mid]){
                end = mid - 1;
            } else if(target > nums[mid]){
                start = mid + 1;
            } else{
                // we found the answer with 50% possibility or we found the index of potential answer(target)
                ans = mid;
                if(isFindingStartIndex){
                    end = mid - 1;
                } else{
                    start = mid + 1;
                }
            }
            
            mid = start + (end - start) / 2;
        }    
        
        return ans;
    }

}
