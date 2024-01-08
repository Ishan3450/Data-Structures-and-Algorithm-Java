package LinkedListQuestions;

public class Merge2SortedLinkedListInReverseOrder {
    Node mergeResult(Node node1, Node node2) {
        Node mergedHead = null;

        Node temp1 = node1;
        Node temp2 = node2;

        while (temp1 != null && temp2 != null) {
            Node curr = null;
            if (temp1.data <= temp2.data) {
                curr = temp1;
                temp1 = temp1.next;
            } else {
                curr = temp2;
                temp2 = temp2.next;
            }

            if (mergedHead == null) {
                mergedHead = curr;
                mergedHead.next = null;
            } else {
                curr.next = mergedHead;
                mergedHead = curr;
            }
        }

        while (temp1 != null) {
            Node curr = temp1;
            temp1 = temp1.next;

            if (mergedHead == null) {
                mergedHead = curr;
                curr.next = null;
            } else {
                curr.next = mergedHead;
                mergedHead = curr;
            }
        }

        while (temp2 != null) {
            Node curr = temp2;
            temp2 = temp2.next;

            if (mergedHead == null) {
                mergedHead = curr;
                curr.next = null;
            } else {
                curr.next = mergedHead;
                mergedHead = curr;
            }
        }

        return mergedHead;
    }
}
