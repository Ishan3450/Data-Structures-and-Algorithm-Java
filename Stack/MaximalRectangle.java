package Stack;

import java.util.Stack;

public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        int[][] mat = new int[matrix.length][matrix[0].length];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                mat[row][col] = matrix[row][col] - '0';
            }
        }

        int largestRect = largestAreaInHistogram(mat[0]);

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {

                if (mat[i][j] != 0) {
                    mat[i][j] += mat[i - 1][j];
                }
            }

            largestRect = Math.max(largestRect, largestAreaInHistogram(mat[i]));
        }
        return largestRect;
    }

    public int largestAreaInHistogram(int[] hist) {
        int[] next = nextSmaller(hist);
        int[] prev = prevSmaller(hist);
        int area = Integer.MIN_VALUE;
        for (int i = 0; i < hist.length; i++) {
            int length = hist[i];

            if (next[i] == -1) {
                next[i] = hist.length;
            }

            int width = next[i] - prev[i] - 1;
            area = Math.max(area, length * width);
        }
        return area;
    }

    public int[] nextSmaller(int[] hist) {
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[hist.length];
        st.push(-1);
        for (int i = hist.length - 1; i >= 0; i--) {
            int currVal = hist[i];

            while (st.peek() != -1 && hist[st.peek()] >= currVal) {
                st.pop();
            }

            ans[i] = st.peek();
            st.push(i);
        }
        return ans;
    }

    public int[] prevSmaller(int[] hist) {
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[hist.length];
        st.push(-1);
        for (int i = 0; i < hist.length; i++) {
            int currVal = hist[i];
            while (st.peek() != -1 && hist[st.peek()] >= currVal) {
                st.pop();
            }
            ans[i] = st.peek();
            st.push(i);
        }
        return ans;
    }
}
