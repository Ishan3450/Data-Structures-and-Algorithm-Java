package BinarySearchTrees;

public class SortedLinkedListToBST {
    private class ListNode {
        int val;
        ListNode next;
    }

    public TreeNode sortedListToBST(ListNode head) {
        // base condition
        if (head == null) {
            return null;
        }

        // function body
        ListNode slow, pred = null, fast;
        slow = fast = head;

        // getting the middle node of the linked list
        while (fast != null && fast.next != null) {
            pred = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        TreeNode root = new TreeNode(slow.val);
        if (pred != null) {
            pred.next = null;
            root.left = sortedListToBST(head);
        }
        root.right = sortedListToBST(slow.next);
        return root;
    }
}
