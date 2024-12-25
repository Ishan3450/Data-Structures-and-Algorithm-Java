/*
 ! In this file no main method is there, only approach is here, so bettwe run it directly on LeetCode that will be more easy.

 * Q19: Remove Nth Node From End of List
 */

package LeetCodeQuestions;

public class Q19 {
    private Node head;
    private Node tail;
    
    // * Structure of single node
    private class Node{
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    /*
     * Main Code 
     */

    /*
     * Approach:
     * - We will take two pointers:
     * - Fast and Slow
     * - Then at first we will move the fast pointer till n+1 position
     * - after moving the fast pointer we will move both the pointers till the fast reaches the end of the list (null pinter).
     * - at that point slow will be at the n-1 position so we will simply update the next of slow with the next of next of slow (slow.next = slow.next.next).
     * - by doing this steps we will be able to remove the nth node from the end of the list.
     */
    public Node removeNthFromEnd(Node head, int n){
        Node dummyNode = new Node(0); // creating dummy node having initial value 0
        Node fast = dummyNode;
        Node slow = dummyNode;
        dummyNode.next = head;

        // moving the fast to n+1
        for(int i=0; i<n+1; i++){
            fast = fast.next;
        }

        // moving both the pointers until fast one reaches the end of the list
        while(fast != null){
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;
        return dummyNode.next;
    }
}
