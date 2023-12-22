/*
 * Given a linked list and a number k, you have to reverse first part of size k and second part with n-k size 
 * https://practice.geeksforgeeks.org/contest/codehelp-upcoming-sde-contest-3/problems
 */

package LinkedListQuestions;

public class ReverseBothPaths {
    public static Node reverse(Node head, int k) {
        if (head == null || head.next == null) {
            return head;
        }

        Node currEnd = head;
        Node lastEnd = null;
        Node newHead = null;

        Node prev, curr, next;
        prev = null;
        curr = head;
        next = head.next;

        // processing the first part
        for (int i = 1; i <= k; i++) {
            curr.next = prev;
            prev = curr;
            curr = next;
            if (next != null)
                next = next.next;
        }

        if (lastEnd == null) {
            newHead = prev;
        }
        currEnd.next = curr;

        lastEnd = currEnd;
        currEnd = curr;

        prev = null;
        while (curr != null) {
            curr.next = prev;
            prev = curr;
            curr = next;
            if (next != null)
                next = next.next;
        }
        lastEnd.next = prev;
        currEnd.next = curr;

        return newHead;
    }
}
