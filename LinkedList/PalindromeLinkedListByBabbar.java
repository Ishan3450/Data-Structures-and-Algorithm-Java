// TC: O(N)
// SC: O(1)

package LinkedList;

public class PalindromeLinkedListByBabbar {
    public static Node getMiddle(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static Node reverse(Node head) {
        Node prev = null;
        Node curr = head;
        Node next = head.next;

        while (curr != null) {
            curr.next = prev;
            prev = curr;
            curr = next;
            if (next != null) {
                next = next.next;
            }
        }

        return prev;
    }

    public static boolean isPalindrome(Node head) {
        if (head.next == null) {
            return true;
        }

        Node middleOfList = getMiddle(head);
        Node secondHead = reverse(middleOfList);
        middleOfList.next = null;

        while (head != null && secondHead != null) {
            if (head.data != secondHead.data) {
                return false;
            }
            head = head.next;
            secondHead = secondHead.next;
        }

        return true;
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

        System.out.println(isPalindrome(n1));
    }
}
