package BinarySearchTrees;

// https://www.interviewbit.com/problems/valid-bst-from-preorder/

import java.util.ArrayList;

public class ValidBSTFromPreorder {
    public int solve(ArrayList<Integer> A) {
        int[] idx = new int[1];
        checkForBST(A, idx, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return idx[0] >= A.size() ? 1 : 0;
    }

    private void checkForBST(ArrayList<Integer> arr, int[] idx, int minVal, int maxVal) {
        // base condition
        if (idx[0] >= arr.size())
            return;

        // function body
        if (arr.get(idx[0]) > minVal && arr.get(idx[0]) < maxVal) {
            int rootVal = arr.get(idx[0]++);
            checkForBST(arr, idx, minVal, rootVal);
            checkForBST(arr, idx, rootVal, maxVal);
        }
    }
}
