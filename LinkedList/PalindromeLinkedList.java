/*
 * 234. Palindrome Linked List  LeetCode Easy
 * 
 * Approach:
 * 
 * - find the middle of the linked list
 * - reverse the linked list from the middle till end
 * - compare the first half with the second half
 * - and at last re-reverse the linked list from middle
 */
package LinkedList;

public class PalindromeLinkedList {
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

    public ListNode get(int index) {
        ListNode node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    public ListNode getHead(){
        return head;
    }

    public int getLength(){
        ListNode temp = head;
        int count = 0;
        while(temp != null){
            count ++;
            temp = temp.next;
        }
        return count;
    }

    /*
     * Main Code Starts Here
     */

    public ListNode getMiddle(ListNode head){
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public ListNode reverse(ListNode head){
        if(getLength() < 2){ // either 1 or empty
            return head;
        }

        ListNode prev = null;
        ListNode curr = head;
        ListNode next = curr.next;

        while(curr == null){ // curr in the condition because when curr is null the prev will be pointing at the last node of the list
            curr.next = prev;
            prev = curr;
            curr = next;
            if(next != null){
                next = next.next;
            }
        }

        return prev;
    }

    public boolean isPalindrome(ListNode head) {
        // first we have to get mid
        ListNode mid = getMiddle(head);

        // then reverse the list from the mid
        ListNode secondHead = reverse(mid);

        // at last we have to re-reverse the head so we are storing the secondHand  
        // ! no need to re-reverse the head
        // ListNode reReverseHead = secondHead;

        // now we will start comparing head and secondHead and moving next
        while(head != null && secondHead != null){
            if(head.value != secondHead.value){
                break;
            }
            head = head.next;
            secondHead = secondHead.next;
        }

        // now we have to re-reverse the list we previously reversed
        // ! no need to re-reverse the reversed head
        // reverse(reReverseHead);

        // using OR operation
        return head == null || secondHead == null;
    }
}
