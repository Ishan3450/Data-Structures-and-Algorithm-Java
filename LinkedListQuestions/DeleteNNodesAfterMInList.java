package LinkedListQuestions;

public class DeleteNNodesAfterMInList {
    static void linkdelete(Node head, int M, int N) {
        if (head == null || head.next == null) {
            return;
        }

        Node temp = head;
        int tempM = 1;

        while (temp != null && temp.next != null) {
            if (tempM == M) {
                // we have to delete N nodes
                Node next = temp.next;
                for (int i = 1; i <= N && next != null; i++) {
                    next = next.next;
                }
                temp.next = next;
                tempM = 1;
            } else {
                tempM++;
            }
            temp = temp.next;
        }
    }
}
