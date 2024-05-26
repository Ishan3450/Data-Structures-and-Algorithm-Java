package LinkedList;

public class ReorderList {
    private class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode getMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = head.next;

        while (curr != null) {
            curr.next = prev;
            prev = curr;
            curr = next;

            if (next != null) {
                next = next.next;
            }
        }

        return prev; // new reversed head
    }

    public void reorderList(ListNode head) {
        if (head.next == null) {
            return;
        }

        ListNode middle = getMiddle(head);

        ListNode firstHead = head;
        ListNode secondHead = reverse(middle);

        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        while (firstHead != null && secondHead != null) {
            temp.next = firstHead;
            firstHead = firstHead.next;
            temp = temp.next;

            if (temp != secondHead) { // this case is important in case of odd length list
                temp.next = secondHead;
                secondHead = secondHead.next;
                temp = temp.next;
            }
        }

        head = dummy.next;
    }
}
