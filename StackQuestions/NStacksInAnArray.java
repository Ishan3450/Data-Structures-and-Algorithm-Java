/* 
 ! This question is on hold as of now.
 * Varibales:
 * int freespot = 0; // tells the freespot of the array, initially will be 0
 * int[] top = {-1, -1 ,-1....n} // tell the nth stack's top variable
 * int[] next; 
 *  a. works in 2 ways: before assigning it will tell the next empty spot
 *  b. after assigning it will tell the previous placed element in the stack
 *  - for array size 5: next = {1,2,3,4,-1}, where 0th index tells that 1 is the empty space, 1st tells 2nd is the empty
 * 
 * Push(x, m):
 * - x is the value, and m is the stack number
 * 
 * S1: [Find Index]
 *      int index = freespot;
 * S2: [Update freespot]
 *      freespot = next[index];
 * S3: [Insert in array]
 *      a[index] = x;
 * S4: [Update Next]
 *      next[index] = top[m-1];0
 * S5: [Update top]
 *      top[m-1] = index;
 * 
 * Pop(m):
 * - m is the stack number
 * - pop is the reverse steps of the push operation.
 * 
 * S1: int index = top[m-1];
 * S2: top[m-1] = next[index];
 * S3: next[index] = freespot;
 * S4: freespot = index;
 * S5: return arr[index];
 */

package StackQuestions;

public class NStacksInAnArray {
    
}
