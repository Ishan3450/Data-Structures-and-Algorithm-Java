package LinkedListQuestions;

public class DetectAndRemoveLoopFromLL {
    public static boolean isLoopPresent(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    public static Node getStartingNodeOfLoop(Node head) {

        if (!isLoopPresent(head)) {
            return null;
        }

        Node slow = head;
        Node fast = head;

        do{
            fast = fast.next.next;
            slow = slow.next;
        } while(fast != slow);


        slow = head;

        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }

        return slow; // or fast
    }

    public static void removeLoopFromList(Node head){
        if(!isLoopPresent(head)){
            return;
        }

        Node slow, fast;
        slow = fast = head;

        do{
            slow = slow.next;
            fast = fast.next.next;
        } while(slow != fast);

        slow = head;
        Node prev = null;

        while(slow != fast){
            prev = fast;
            fast = fast.next;
            slow = slow.next;
        }

        // loop removed :)
        prev.next = null;

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
        n7.next = n3;

        System.out.println(isLoopPresent(n1));
        System.out.println(getStartingNodeOfLoop(n1).data);
        removeLoopFromList(n1);
        Node temp = n1;
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
}
