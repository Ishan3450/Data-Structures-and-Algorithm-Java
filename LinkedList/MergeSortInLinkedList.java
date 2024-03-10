/*
 * 148. Sort List LeetCode Medium
 * 
 */

package LinkedList;

public class MergeSortInLinkedList {
    private ListNode head;
    private ListNode tail;

     /*
     * Structure of a single element of Linked List
     */
    private class ListNode {
        private int value;
        private ListNode next;

        public ListNode(int value) {
            this.value = value;
        }

        public ListNode(int value, ListNode next) {
            this.value = value;
            this.next = next;
        }

    }

    public void insertAtFirst(int value) {
        ListNode box = new ListNode(value);

        box.next = head;
        head = box;

        if (tail == null) {
            tail = head;
        }
    }

    public void insertAtLast(int value) {
        if (tail == null) {
            insertAtFirst(value);
            return;
        }
        ListNode box = new ListNode(value);
        tail.next = box;
        tail = box;
    }

    public void display() {
        ListNode temp = head;

        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }

        System.out.println("END");
    }

    public void display(ListNode node) {
        ListNode temp = node;

        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }

        System.out.println("END");
    }

    public ListNode getHead(){
        return head;
    }
    
    /*
     * Main Code Startz here
     */

    public ListNode sortList(MergeSortInLinkedList list) {
        ListNode head = list.head;
        // base condition
        if(head == null || head.next == null){
            return head;
        }
        
        // function body
        ListNode mid = getMiddleNode(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);
        
        return merge(left, right);
    }

    public ListNode sortList(ListNode head) {
        // base condition
        if(head == null || head.next == null){
            return head;
        }
        
        // function body
        ListNode mid = getMiddleNode(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);
        
        return merge(left, right);
    }
    
    public ListNode merge(ListNode head1, ListNode head2){
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        
        while(head1 != null && head2 != null){
            if(head1.value < head2.value){
                tail.next = head1; // linking the head
                head1 = head1.next; // moving the head forward
                tail = tail.next; // updating the tail
            } else{
                tail.next = head2;
                head2 = head2.next;
                tail = tail.next;
            }
        }
        
        while(head1 != null){
            tail.next = head1; // linking the head
            head1 = head1.next; // moving the head forward
            tail = tail.next; // updating the tail            
        }
        
        while(head2 != null){
            tail.next = head2;
            head2 = head2.next;
            tail = tail.next;
        }
        
        return dummy.next;
    }

    public ListNode getMiddleNode(ListNode head){
        ListNode slow = null; // null because we will initialize it in the loop
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = (slow == null) ? head : slow.next;
            fast = fast.next.next;
        }

        ListNode mid = slow.next;
        slow.next = null; // assigning null because we want the first part to stop at the mid
        return mid;
    }
    
}
