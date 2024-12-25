package LinkedList;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class ReverseLinkedListInKGroups {

    public static int getLength(Node head){
        int len = 0;
        Node temp = head;

        while(temp != null){
            len ++;
            temp = temp.next;
        }
        return len;
    }
    public static Node reverseKGroup(Node head, int k) {
        if(head == null || head.next == null){
            return head;
        }
        
        int length = getLength(head);
        if(k > length){
            return head;
        }

        Node newHead = null;
        // count states that number of groups to be reversed
        int count = length / k;

        Node curr = head;
        Node prev = null;

        while(count > 0){
            Node lastEnd = prev;
            Node newEnd = curr;
            Node next = curr.next;

            for(int i = 1; i <= k ; i++){
                curr.next = prev;
                prev = curr;
                curr = next;
                if(next != null){
                    next = next.next;
                }
            }

            if(newHead == null){
                newHead = prev;
            } else{
                lastEnd.next = prev;
            }

            newEnd.next = curr;
            prev = newEnd;
            count --;
        }

        return newHead;
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;

        Node newHead = reverseKGroup(n1, 3);

        while(newHead != null ){
            System.out.print(newHead.data + " " );
            newHead = newHead.next;
        }

    }
}
