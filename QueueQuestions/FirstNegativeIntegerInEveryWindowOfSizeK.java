/*
 * Approach:
 * - Sliding Window Problem 
 * - We will be using Doubly Ended Queue for this question.
 * - for : {-8, 2, 3, -6, 10} N=2
 * - 1st window of n=2 : -8, 2  will be added in the queue
 * - 2nd winddow : -8 will be removed from the front and 3 will be added from the rear of the list
 * - likewise till n all the window will work
 * - we will only store the index of negative numbers or 0 in the queue
 * 
 * Step 1: Process the first window first
 * Step 2: push the answer of first window
 * Step 3: now process all the rest of the windows
 *      loop:
 *      Step 3.1 : First pop out of the element of old window
 *      Step 3.2 : then push current element of the curr window
 *      Step 3.3 : put in the answer of the curr window
 *      Step 3.4 : return the answer
 */

package QueueQuestions;

import java.util.*;

public class FirstNegativeIntegerInEveryWindowOfSizeK{
    public static long[] printFirstNegativeInteger(long A[], int N, int K){
        // reason for deque of type INTEGER: for checking the curr window is containing the true elements of the window or not
        Deque<Integer> dq = new LinkedList<>(); // dq will be used to store indices of the negative numbers in the array
        ArrayList<Long> ans = new ArrayList<>();

        // ans for the 1st window of size K
        for(int i=0; i<K; i++){
            if(A[i] < 0){ // if the element is negative store the index of that element in the queue
                dq.addLast(i);
            }
        }

        // get the answer of the 1st window
        if(dq.size() > 0){
            ans.add(A[dq.getFirst()]);
        } else{
            ans.add(0L);
        }

        for(int i=K; i<N; i++){
            // remove the element of the old window and insert the element of the current window
            if(!dq.isEmpty() && i - dq.getFirst() >= K){ // if curr element is of out of window
                dq.removeFirst();
            }

            // adding new negative element index from the curr window
            if(A[i] < 0){ // if negative
                dq.addLast(i);
            }

            // store the answer as previously done on line 38
            if(dq.size() > 0){
                ans.add(A[dq.getFirst()]);
            } else{
                ans.add(0L);
            }
        }

        long[] a = new long[ans.size()];

        for(int i=0; i<a.length; i++){
            a[i] = ans.get(i);
        }
        
        return a;
    }   

    public static void main(String[] args){
        long[] A = {-8, 2, 3, -6, 10};

        System.out.println(Arrays.toString(printFirstNegativeInteger(A, A.length, 2)));
    }
}