/*
 * Celebrity Problem : GFG Medium
 * 
 * Celebrity has main 2 condition:
 * - 1. he goes to a party and everyone knows celebrity
 * - 2. but celebrity knows no one
 * 
 * Input: NxN matrix, N (size of matrix)
 * Time Complexity: O(N)
 * 
 * Approach:
 * - NOTE: We have to ignore the diagonal of the matrix as 0 knows 0, 1 knows 1, 2 knows 2 ... n knows n
 * 
 * - Step 1: we will insert all the N elements in a stack
 * - Step 2: we will pop first 2 top elements from the stack and check:
 *          - first top -> A, second top -> B
 *          - we will run the loop till the size of stack not becomes 1
 *          - first we will check if (A knows B) then we will discard A as celebrity knows no one and push back B in the stack
 *          - if not then we will check if (B knows A) then we will discard B and push back A in the stack
 *          - At last only the potential celebrity element will remain in the stack
 * - Step 3: verify the celebrity by checking its row & col.
 *          
 */

package StackQuestions;

import java.util.Stack;

public class CelebrityProblem {
    public static boolean knows(int m[][], int a, int b) {
        if (m[a][b] == 1) {
            return true;
        }
        return false;
    }

    public static int celebrity(int M[][], int n) {
        // code here
        Stack<Integer> st = new Stack<>();

        // Step 1
        for (int i = 0; i < n; i++) {
            st.push(i);
        }

        // Step 2
        while (st.size() != 1) {
            int A = st.pop();
            int B = st.pop();

            if (knows(M, A, B)) { // if A knows B
                st.push(B); // so discarding A
            } else{ // B knows A
                st.push(A); // so discarding B
            }
        }

        // at this point size of stack is only 1 which is the potential celebrity answer
        int ans = st.peek();

        // Step 3

        // row check
        int zeroesCount = 0;

        for (int i = 0; i < n; i++) {
            if(M[ans][i] == 0){
                zeroesCount ++;
            }
        }

        if(zeroesCount != n){ // if 0s are not equal to the size of n it means the top of the stack is not answer
            return -1;
        }

        // col check
        int onesCount = 0;

        for (int i = 0; i < n; i++) {
            if(M[i][ans] == 1){
                onesCount ++;
            }
        }

        if(onesCount != n-1){ // here used n-1 as diagonal is not included in the count
            return -1;
        }

        return ans;
    }

    public static void main(String[] args){
        int[][] m = {
            {0,0,1,0},
            {0,0,1,0},
            {0,0,0,0},
            {0,0,1,0}
        };
        
        System.out.println(celebrity(m, m.length));
    }
}
