/*
 ? How we will know is the number power of 2 or not
 * - Just get the binary number
 * - if the binary on that number contains only 1 '1 bit' then the number is power of 2
 * - so count the number of 1's in the binary of that number by using the loop
 */

package BitwiseAndNumberSystemQuestions;

public class IsNumberPowerOf2 {
    public static void main(String[] args){
        int num = 16; // every 2^n will be the power of 2

        System.out.println("Approach 1: " + isPowerOf2(num));
        System.out.println("Approach 2: " + isPowerOf2_2(num));
    }

    static boolean isPowerOf2(int num){
        int counter = 0;

        while(num > 0){
            int last = num & 1; // getting the last digit
            num >>= 1; // right shifting the number by 1

            if(last == 1){
                counter ++;
            }
        }

        if(counter == 1){
            return true;
        } else{
            return false;
        }
    }

    /*
     * Let take num 8
     * - Binary of num 8 : 1000
     * - Binary of num - 1 -> 7 : 111
     * 
     * - So and num and num - 1 which will give like:
     * - 8:   1000
     * - 7:   0111
     * - ans: 0000
     */

     /*
      * GeeksForGeeks Question:
      ? Power of 2
      * https://practice.geeksforgeeks.org/problems/power-of-2-1587115620/1
      */

    static boolean isPowerOf2_2(int n){
        // edge case
        if(n == 0){
            return false;
        }

        boolean ans = (n & (n-1))== 0;
        return ans;
    }

}
