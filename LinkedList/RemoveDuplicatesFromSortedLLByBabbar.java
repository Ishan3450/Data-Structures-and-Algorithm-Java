/*
 * Approch1:
 *    if head.val == head.next.val
 *    then head.next = head.next.next
 *
 *    if head.val != head.next.val
 *    then head = head.next
 *
 * Approach2:
 *    1 1 2 3 3
 *            h
 *        p
 *
 *    p: -1 -> 1 -> 2
 *
 *    if h.val != h.next.val or h.next == null then
 *    p.next = h;
 *    and p = p.next
 *    and h = h.next
 */

package LinkedList;

public class RemoveDuplicatesFromSortedLLByBabbar {
    // approach 1
    public Node deleteDuplicates(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node temp = head;

        while (temp.next != null) {
            if (temp.data == temp.next.data) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
        return head;
    }

    // approach 2
    public Node deleteDuplicates2(Node head) {
        Node newHead = new Node(-1);
        Node placer = newHead;
        Node temp = head;

        while(temp != null){
            if(temp.next == null || temp.data != temp.next.data){
                Node n = new Node(temp.data);
                placer.next = n;
                placer = placer.next;
            }
            temp = temp.next;
        }

        return newHead.next;
    }
}
