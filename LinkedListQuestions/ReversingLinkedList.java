package LinkedListQuestions;

public class ReversingLinkedList {
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
     * Main code starts here
     */
    
    // Reverse Using Recursion
    public void reverseUsingRecursion(ListNode node){
        // base condition
        if(node == tail){
            /*
             * If base condition hits, it means that node is at the tail, and as we want to reverse the list we are updating head to tail.
             * So head will be pointing at the last node of the list.
             */
            head = tail;
            return;
        }

        // function body

        /*
         * So, what we are gonna do is we will recurse to the end of the list and when we came out of that particular recursive call we will update the tail.
         */
        reverseUsingRecursion(node.next);
        // * When we will come out of the above recursion call we will update the tail

        tail.next = node; // updating the next of the tail as the current node
        tail = node; // updating the tail to the current node
        tail.next = null; // updating the next of the new updated tail to null as next of the tail is always null

    }

    // Very Important Topic: In-place or Iterative Reverse of Linked List
    public void inPlaceReverse(ListNode head){
        // edge case
        if(getLength() < 2){ // either the list is of size 1 or empty
            return;
        }

        ListNode prev = null;
        ListNode curr = head;
        ListNode next = head.next;

        while(curr != null){ // * Note: when curr is null it means prev is the last node of the original linked list
            curr.next = prev;
            prev = curr;
            curr = next;
            if(next != null){
                next = next.next;
            }
            
        }

        // when the loop exits the prev will be at the last node of the linked list so we have to make it head as we are reversing the linked list
        head = prev;
    }

    /*
     * LeetCode Medium
     * 92. Reverse Linked List II 
     * 
     * - We have to reverse the linked list in range of left to right
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left == right){ // if both are equal it means nothing has to be done
            return head;
        }

        // first we have to skip first left-1 nodes
        ListNode prev = null;
        ListNode curr = head;

        // curr must not be null else it will give null pointer exception
        for(int i=0; curr != null && i<left-1; i++){
            prev = curr;
            curr = curr.next;
        }

        // now actually reversing the left to right part
        ListNode last = prev; // last will be used to link the first node of the reversed linked list
        ListNode newEnd = curr; // newEnd will be used to link the last node of the reversed linked list

        ListNode next = curr.next;

        // loop will run for left-right+1 elements
        // for: left=3, right=6, loop will be 6-3+1 -> 4 elements
        for(int i=0; curr != null && i<right-left+1; i++){
            // below lines are for reversing same as previously done
            curr.next = prev;
            prev = curr;
            curr = next;
            if(next != null) {
                next = next.next;
            }
        }

        /*
         * Note: basically last and newEnd will be used to link the newly reversed list's start and end so after linking the list will be completed.
         */

        if(last != null){
            last.next = prev;
        } else{ // if next of last is null it means it is the last node of the linked list
            head = prev;
        }

        newEnd.next = curr;
        return head;
    }

}
