package Heaps;

import java.util.Comparator;
import java.util.PriorityQueue;

import Heaps.PriorityQueueWithCustomLogic.ListNode;

public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        Comparator<ListNode> minHeapVal = new Comparator<ListNode>() {
            public int compare(ListNode l1, ListNode l2) {
                if (l1.val > l2.val) {
                    return 1;
                }
                return -1;
            }
        };

        PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>(minHeapVal);

        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                heap.add(lists[i]);
            }
        }

        ListNode head = new ListNode(-1);
        ListNode tail = head;

        while (!heap.isEmpty()) {
            ListNode front = heap.remove();

            tail.next = front;
            tail = tail.next;

            if (front.next != null) {
                heap.add(front.next);
            }
        }

        return head.next;
    }
}
