/*
 * 410. Split Array Largest Sum
 * 
 * - HARD Question so full elaboration is there
 * - NOTE: In this question there is not clue about applying binary search but by this approact we made it to apply binary search
 * - get the input array and m(m is number of partition to make in the array)
 * - ex array : [7,2,5,10,8]
 * - necessary observations :
 *      - CASE 1: minimum num of partition that we can make will be 1 which is the whole array as a single partition
 *      - CASE 2: what can be the maximum number of partitions that can be : length of array
 *          - [7,2,5,10,8] = [7],[2],[5],[10],[8] // 5 partitions or sub-arrays
 *      - What will be the ans in case 1: 
 *          - Answer will be the sum of entire array which is 7+2+5+10+8 = 32
 *      - What will be the ans in case 2:
 *          - Maximum element of the partitioned array which will be [10] from [7],[2],[5],[10],[8]
 *      - CASE 3: Also check if the length of the array is == m (number of partition)
 *          - If case 3 is true then just get the ans from case 2 which is the maximum element from all the sub-arrays
 *      
 *      - Max value of ans of question will be CASE 1
 *      - Min value of ans of question will be CASE 2
 * 
 *      - Now we have Max and Mix answer so we have RANGE : 
 *          [10, 32] // 10 is from CASE 2 and 32 is from CASE 1
 *      
 *      - Now we are ready to apply binary search to the problem: 
 *      - So, now start = 10 and end = 32
 *      - So, we got our start and end now we will find mid by using binary search's start and end pointer
 *      - And in the loop of binary search we will put condition like:
 *          - Take var piecesCount with value 0
 *          - Then we will take element of array one by one adding into sum and checking if the value of sum is less than the mid
 *          - Until the value of sum is less than or equal to mid keep adding element by element
 *              - Like mid will be : 10+32/2 = 21
 *              - now check:
 *              - 1: is 7 less than mid, true then add the next element which is 2
 *              - 2: now 7+2 is less then mid, true then add the next elemen which is 5
 *              - 3: now next element which is 10 so if 7+2+5=14, 14+10 = 24 which is greater than mid(21)
 *              - 4: when sum value is > mid value then increase the piecesCount by 1 (piecesCount ++) so it will start the new piece of array
 *              - 5: so we got the 1st part of the array : [7,5,2]
 *                  - now add the piecesCount by 1
 *                  - so we will start with the new piece of array of remaining elements [10, 8]
 *                  - it will check the same from STEP 1 and the final ans will look like: [7,5,2], [10,8]
 *              - 6: so till now start = 10, mid = 21, end = 32 and if we have completed whole array with piecesCount <= m then we have to decrease the mid as of the sum is higher than the mid
 *              - 7: to decrease the mid move the end pointer to the mid(end = mid)
 *              - 8: so now start = 10, end = 21
 *              - 9: get the mid which will be 10+21=31, 31/2 = 15;
 *              - 10: we got our mid 15
 *                  - then after following from STEP 1 we will get the array like: [7,2,5], [8], [10]
 *                  - so we are getting the pieces count > m which is a false condition according to question we must have pieces only <= m
 *                  - it happened because we have mid which is smaller than the original answer
 *                  - so now to increase the mid we have to move the start pointer to mid + 1
 *              - 11: Now, we got start = 16 and end = 21
 *                  - new mid = 18
 *              - 12: Go to step 1 and do it again:
 *                  - now we got array : [7,5,2], [8,10] completed in piecesCount <= m
 *                  - so decrease the mid
 *              - END : so this will go in the loop until the start and end both pointers are pionting to the same 
 * 
 */

package LeetCodeQuestions;

public class Q410 {
    public static void main(String[] args) {
        int[] arr = {7,2,5,10,8};
        int m = 2;

        System.out.println(splitArray(arr, m));

    }

    static int splitArray(int[] nums, int m) {
        int start = 0;
        int end = 0;
        // first getting the max number and sum of whole array
        for(int i=0; i<nums.length; i++){
            // start is our biggest element of the array
            start = Math.max(start, nums[i]);
            // end is the total sum of the whole array
            end += nums[i];
        }
        // so we got our start which is biggest element of the whole array
        // and we also got our end which is the sum of whole array

        // now its time to apply binary search
        while(start < end){
            int sum = 0; // sum is used to track the sum of current piece of array
            int piecesCount = 1; // piecesCount is the count of total number of pieces made to complete the array

            int mid = start + (end - start) / 2;

            for(int num: nums){ // FOR EACH LOOP: num will refer to single item of nums without indexing i
                if(sum + num > mid){
                    // if the sum + num is exceding the the allowed sum which is MID then 
                    // 1 : we have to increase the pieces count by 1
                    piecesCount ++;        
                    // 2 : as we have to start with the new array piece we have to set the sum with the num 
                    // like [7,2,5] sum = 7+2+5, now sum is exceding then next piece is [8,10] the we have to set the sum = num which in this case will be 8
                    sum = num;
                } else{
                    // if the sum + num is not exceding the allowed sum then we have to continue to add the number to the sum
                    sum += num;
                }
            }

            // now we have to update the start and end pointers
            // so according to our conditions:
            if(piecesCount <= m){
                // if this condition is true it means we have sum which is bigger than the answer
                // then set the end to the mid
                end = mid;
            } else{
                // if the else condition is executed it means we have sum which is smaller than the answer
                // then set the start to the mid + 1
                start = mid + 1;
            }
        }

        return end; // or return start; coz both pointing to the same element
    }

}
