package StackQuestions;

import java.util.Stack;

public class NextGreaterNodeInLinkedListUsingStack {
    // below class is created just for removing classnotfound error in the code
    private class ListNode {
        int val;
        ListNode next;
    }

    public int[] nextLargerNodes(ListNode head) {
        int n = getLength(head);
        int[] ans = new int[n];
        helper(head, ans, 0, new Stack<Integer>());
        return ans;
    }

    public void helper(ListNode head, int[] ans, int idx, Stack<Integer> st) {
        // base condition
        if (head == null) {
            return;
        }

        // function body
        helper(head.next, ans, idx + 1, st);

        while (!st.isEmpty() && st.peek() <= head.val) {
            st.pop();
        }

        if (st.isEmpty()) {
            ans[idx] = 0;
        } else {
            ans[idx] = st.peek();
        }
        st.push(head.val);
    }

    public int getLength(ListNode head) {
        {
            int len = 0;
            ListNode temp = head;
            while (temp != null) {
                len++;
                temp = temp.next;
            }
            return len;
        }

    }
}
