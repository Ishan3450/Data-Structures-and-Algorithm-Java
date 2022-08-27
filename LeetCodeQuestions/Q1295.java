/* 
 * - take a number
 * - run a loop till the length of the array
 * - count the number of digits that number has
 * - if it is even then increment the count with 1
 * - then return the total count of the numbers contains even number of digits
 * - at last try to optimize the code if possible
*/

package LeetCodeQuestions;

public class Q1295 {
    public static void main(String[] args){
        int[] arr1 = {12,345,2,6,7896}; // 2
        int[] arr2 = {555,901,482,1771}; // 1

        System.out.println(findNumbers(arr1));

    }   

    static int findNumbers(int[] nums) {
        int total_count = 0;
           for(int i=0; i<nums.length; i++){
                int num = nums[i];
                int digits_count = 0;
               
                while(num > 0){
                    digits_count ++;
                    num = num / 10;
                }
               
               if(digits_count %2 == 0){ total_count ++; }
           }
        return total_count;
    }


}
