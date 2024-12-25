package LinkedList;

public class HappyNumber {
     /*
     * Q: Happy Number
     * 
     * LeetCode: 202 Easy but Tricky Google Question
     * 
     * NOTE: Here the question do not says that to use the fast & slow pointer we have to approach the problem and get that click in our mind.
     * 
     * Approach:
     * - we are gonna use the fast & slow pointer method
     * - we will move the slow pointer 1 time and fast pointer 2 times
     * - if they met at some point it means the number is not a happy number
     * - if the number is happy number it means the last answer will be 1 and square of 1 is 1 so at some point
     *   both the pointer will met and condition mets
     * - so we will check if either of two pointer is having ans 1
     * - if yes then the number is happy number else not
     */
    static boolean isHappy(int n) {
        // initially both the pointer will start from the given number
        int slow = n;
        int fast = n;

        do{
            slow = getSum(slow); // moving slow by 1
            fast = getSum(getSum(fast)); // moving fast by 2
        }while(slow != fast); // run till both gets equal
        /* 
         * slow != fast condition used because:
         * 
         * 1. If a number is happy:
         * - at some point sum of square will be 1
         * - after that all the answers will be 1 only so the loop will break
         * 
         * 2. If a number is not a happy number:
         * - for number 12:
         *  suppose, 1^2 + 2^2 comes and at some point this will again occur so
         *      either the fast or slow pointer will be there having equal value so loop will break
        */

        // checking if we got 1 or not
        if(slow == 1){ // or we can put fast also 
            return true;
        }

        return false;
    }

    static int getSum(int n){
        int ans = 0;

        while(n > 0){
            int lastDigit = n % 10;
            ans += lastDigit * lastDigit;
            n /= 10;
        }
        return ans;
    }

    public static void main(String[] args){
        System.out.println("Happy 19: " + isHappy(19));
        System.out.println("Happy 12: " + isHappy(12));
    }
}
