/*
 * Max Rectangle of 1st in a binary matrix
 * 
 * Time Complexity: O(N x M)
 * Space : O(M) -> where M is the total elements in single row of the matrix
 * 
 * Approach:
 * 
 * - We will use Largest Rectangle in Histogram program to get the max rectangle area
 * - Initially we will start from the very first row and count the largest rectangle area 
 * - Then we will go to the next row the add the previous row in the curr row and count the area of rectangle 
 */

package Stack;

import java.util.Stack;

public class MaxRectangle {
    public static int[] nextSmaller(int h[], int n) {
        Stack<Integer> st = new Stack<>();
        st.push(-1); // initial value in stack

        int[] ans = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            int curr = h[i];

            while (st.peek() != -1 && h[st.peek()] >= curr) {
                st.pop();
            }

            ans[i] = st.peek();
            st.push(i);
        }

        return ans;
    }

    public static int[] previousSmaller(int h[], int n) {
        Stack<Integer> st = new Stack<>();
        st.push(-1);

        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int curr = h[i];

            while (st.peek() != -1 && h[st.peek()] >= curr) {
                st.pop();
            }

            ans[i] = st.peek();
            st.push(i);
        }

        return ans;
    }

    public static int largestRectangleArea(int[] heights, int n) {
        int area = 0;

        int[] next = nextSmaller(heights, n);
        int[] prev = previousSmaller(heights, n);

        for (int i = 0; i < n; i++) {
            int length = heights[i];

            if (next[i] == -1) { // for [2 2 2 2] case
                next[i] = n;
            }

            int breadth = next[i] - prev[i] - 1;
            int newArea = length * breadth;
            area = Math.max(area, newArea);
        }

        return area;
    }

    public static int maxArea(int M[][], int n, int m) {

        // first compute the area of first row
        int area = largestRectangleArea(M[0], m);

        for (int i = 1; i < n; i++) { // starting from 1 as of we have laready calculated area of 1st row at the start
                                      // of the function
            for (int j = 0; j < m; j++) {
                // now updating the row: by adding the previous row
                // NOTE: we have to ingore the 0 values cells
                if (M[i][j] != 0) {
                    M[i][j] = M[i][j] + M[i - 1][j]; // i-1 for previous row
                } else {
                    M[i][j] = 0;
                }
            }

            // at this point entire row is updated
            int newArea = largestRectangleArea(M[i], m);
            area = Math.max(area, newArea);
        }
        return area;
    }

    public static void main(String[] args){
        int M[][] = {
            {0,1,1,0},
            {1,1,1,1},
            {1,1,1,1},
            {1,1,0,0}
        };

        
        System.out.println(maxArea(M, M.length, M[0].length));
        
    }
}
