/*
 * Q-84 LeetCode Hard Question
 * 
 */
package StackQuestions;

import java.util.Stack;

public class LargestRectangleInHistogram {
    public static int[] nextSmallerElement(int[] arr, int n){
        Stack<Integer> st = new Stack<>();
        st.push(-1); // adding initial value in the stack

        int[] ans = new int[n];

        for(int i=n-1; i>=0; i--){
            int curr = arr[i];

            while(st.peek() != -1 && arr[st.peek()] >= curr){
                st.pop();
            }

            // at this point we have the top element which is smaller than the curr element
            ans[i] = st.peek();
            st.push(i);
        }

        return ans;
    }

    public static int[] previousSmallerElement(int[] arr, int n){
        Stack<Integer> st = new Stack<>();
        st.push(-1);

        int[] ans = new int[n];

        for(int i=0; i<n; i++){
            int curr = arr[i];

            while(st.peek() != -1 && arr[st.peek()] > curr){
                st.pop();
            }

            // at this point we have the top element which is smaller than the curr element
            ans[i] = st.peek();
            st.push(i);            
        }

        return ans;
    }

    public static int largestRectangleArea(int[] heights) {
        int n = heights.length;

        int[] next = nextSmallerElement(heights, n);
        int[] prev = previousSmallerElement(heights, n);

        int area = Integer.MIN_VALUE; // stores minimum value of int

        for(int i=0; i<n; i++){
            int length = heights[i];

            /*
             * For: 2 2 2 2 case next will be -1 so we are gonna replace the -1 with the size of the array
             */
            if(next[i] == -1){
                next[i] = n;
            }

            int breadth = next[i] - prev[i] - 1;
            int newArea = length * breadth;
            area = Math.max(area, newArea);
        }

        return area;
    }

    public static void main(String[] args){
        int[] heights = {2,1,5,6,2,3};
        
        System.out.println(largestRectangleArea(heights));
    }
}
