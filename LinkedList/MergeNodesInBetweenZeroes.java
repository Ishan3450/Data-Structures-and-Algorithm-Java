package LinkedList;

public class MergeNodesInBetweenZeroes {
    public Node mergeNodes(Node head) {
        if(head == null || head.next == null){
            return head;
        }

        Node newHead = head;
        Node dummy = newHead;

        Node temp = head;

        while(temp.next != null){
            int sum = 0;
            Node further = temp.next;
            while(further.next != null && further.data != 0){
                sum += further.data;
                further = further.next;
            }
            
            dummy.next.data = sum;
            dummy = dummy.next;

            if(further.next == null){
                dummy.next = null;
            }

            temp = further;
        }

        return newHead.next;
    }
}
