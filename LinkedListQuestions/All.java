/*
 * All the important Questions are in a single file.
 */

package LinkedListQuestions;

public class All {
    private Node head;
    private Node tail;
    private int size;

    public All() {
        this.size = 0;
    }

    /*
     * Structure of a single element of Linked List
     */
    private class Node {
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

    public void insertAtFirst(int value) {
        Node box = new Node(value);

        box.next = head;
        head = box;

        if (tail == null) {
            tail = head;
        }

        size += 1;
    }

    public void insertAtLast(int value) {
        if (tail == null) {
            insertAtFirst(value);
            return;
        }
        Node box = new Node(value);
        tail.next = box;
        tail = box;

        size += 1;
    }

    public void display() {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }

        System.out.println("END");
    }

    public void display(Node node) {
        Node temp = node;

        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }

        System.out.println("END");
    }

    public Node getHead(){
        return head;
    }


    /*
     * Main code starts here
     */

    // * Q1: Insert using recursion
    public void insertAtUsingRecursion(int index, int value){
        // as first node will be returning from the recursion call so we are assigning it to the head
        head = insertAtUsingRecursion(index, value, head);
    }

    public Node insertAtUsingRecursion(int index, int value, Node node){
        // base condition
        if(index == 0){
            Node temp = new Node(value);
            temp.next = node;
            return temp;
        }

        // function body

        /* 
         * - we are assinging what was returned from the recursion call
         * - so when base condition hits it will return the new Node so current node.next will be the
         *   returned node from the recursion call.
         */
        node.next = insertAtUsingRecursion(index-1, value, node.next);

        return node;
    }   

    // * Q2: Remove Duplicates
    public void removeDuplicates(){
        Node temp = head;

        while(temp.next != null){
            if(temp.value == temp.next.value){
                /*
                 * When two values are same then we will not move forward instead we will just update the next of current with the next of next
                 * Example: for 1->1->1->2->2->3->null
                 * - will start from head which is first node with value 1
                 * - compare 1st node with value of next of first node
                 * - if it is same then we will update the next of first node to the next of next node
                 * - then we will again compare it 
                 * - when current value is != to the next value, then we will move forward by updating the current node with the next node
                 * - Debugging will be like:
                 *      1st - 1 and 1 will be compared so they are same 
                 *          - so next of first 1 will be the next of second 1 which is also 1 only
                 *      2nd - again 1 and 1 will be compared so they are again same 
                 *          - so next of first 1 will be the next of second 1 which is 2
                 *      3rd - now 1 and 2 will be compared so they are not same
                 *          - so current node will be updated with node which has value 2
                 *      4th - 3 is the last value having next null so loop will be terminated here
                 */
                temp.next = temp.next.next;
                size--; // size is not for every codebase, it is for this file only you can skip it.
            } else{
                // if not same then move forward
                temp = temp.next;
            }
        }

        tail = temp;
        tail.next = null;
    }

    // * Q3 Merge two sorted linked list 
    public All merge(All list1, All list2){
        Node h1 = list1.head;
        Node h2 = list2.head;

        All ans = new All();

        while(h1 != null && h2 != null){
            if(h1.value < h2.value){
                // value of h1 is smaller
                ans.insertAtLast(h1.value);  // add h1 value
                // move the h1 pointer forward
                h1 = h1.next;
            } else{
                // value of h2 is smaller
                ans.insertAtLast(h2.value); // add the value of h2
                // move the h2 pointer forward
                h2 = h2.next;
            }
        }

        // adding is any of the nodes either from both list is remaining or not
        while(h1 != null){
            ans.insertAtLast(h1.value);  // add h1 value
            // move the h1 pointer forward
            h1 = h1.next;        
        }

        while(h2 != null){
            ans.insertAtLast(h2.value); // add the value of h2
            // move the h2 pointer forward
            h2 = h2.next;
        }

        return ans;
    }

    

    // * Q4: find length of the cycle
    public int lengthOfCycle(Node head){
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;

            if(fast == slow){
                // calculate the length of the cycle

                /*
                 * When fast and slow are at same position we will keep the fast pointer at same position and move the slow position till slow pointer again comes at the fast pointer position so by doing that, the length of the cycle will be calculated.
                 */

                Node temp = slow;
                int length = 0;

                do{
                    temp = temp.next;
                    length ++;
                } while(temp != slow); // or temp != fast both will work
                return length;
            }
        }
        return -1;
    }

    /*
     * Q5: Find the starting point of Cycle
     * 
     * LeetCode: Q-142 Medium
     * 
     * Approach:
     * 
     * - First Pointer : f
     * - Second Pointer: s
     * 
     * - Find the length of the cycle.(using fast and slow pointer method)
     * - s and f will be initailly at the starting of the array
     * - now move the s pointer length of the cycle times
     * - after moving s pointer start moving both the s and f pointer by 1 until they met.
     * - when both pointers met that point is the starting of the cycle.
     */

    public Node detectStartOfCycle(Node head){
        int length = 0;

        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;

            if(fast == slow){
                length = lengthOfCycle(slow); // or can pass fast in the arguement as both are pointing to same node
                break;
            }
        }

        // checking if cycle is present or not
        if(length == 0){
            return null;
        }

        // if cycle is present then start finding the start node
        Node first = head;
        Node second = head;

        // moving the first pointer length of cycle times forward
        while(length > 0){
            first = first.next;
            length --;
        }

        // now moving both the pointer until they both met at same place
        while(first != second){
            first = first.next;
            second = second.next;
        }

        // at this point we got both the pointer pointing at same node
        return first; // or return second; as both are pointing to same node
    }

    /*
     * Q6: Middle of the Linked List
     * 
     * Approach:
     * 
     * - Fast and Slow pointer method
     * - Initially will start from head with two pointers
     * - will run the loop till the fast pointer completes the list
     * - so when fast pointer completes the list the slow pointer will be pointing at the half of the list as fast is moving twice than the slow.
     */

    public Node middleNode(All list) {
        Node head = list.head;
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    // same method as above just arguement type difference is there
    public Node middleNode(Node head) {
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }


    /*
     * Q7: Sort List
     * 
     * LeetCode: 148 Sort List
     * 
     * - We will use merge sord to sort the linked list
     */
    public Node sortUsingMergeSort(Node head){
        // base condition
        if(head == null || head.next == null){
            return head;
        }

        // function body
        Node mid = middleNode(head);
        Node left = sortUsingMergeSort(head);
        Node right = sortUsingMergeSort(mid);

        return merge(left, right);
    }

    public Node merge(Node head1, Node head2){
        Node dummy = new Node(0);
        Node tail = dummy;

        while(head1 != null && head2 != null){
            if(head1.value < head2.value){
                tail.next = head1;
                head1 = head1.next;
                tail = tail.next;
            } else{
                tail.next = head2;
                head2 = head2.next;
                tail = tail.next;
            }
        }

        tail.next = (head1 != null) ? head1 : head2;
        return dummy.next;
    }    

    public Node reverse(Node head){
        if(head == null || head.next == null){
            return head;
        }

        Node prev = null;
        Node curr = head;
        Node next = curr.next;

        while(curr != null){
            curr.next = prev;
            prev = curr;
            curr = next;
            if(next != null){
                next = next.next;
            }
        }

        return prev;
    }

    /*
     * Q8: Rearrange the list
     * 
     * 143. Reorder List LeetCode Medium
     * 
     * Approach:
     * - first we will get the middle of the node
     * - then we will reverse the list from mid till end of the list
     * - then we will place two pointer, and name it firstHead and secondHead
     *      - firstHead will be pointing at the start
     *      - secondHead will be pointing at the starting of the reversed list
     * - then we will take the firstHead and secondHead in the loop till one of them becomes null
     */
    public void reorderList(Node head) {
        // edge case
        if(head == null || head.next == null){
            return;
        }

        // first we have to get the middle of the node
        Node middle = middleNode(head);

        // now we have to reverse the list
        Node secondHead = reverse(middle);
        Node firstHead = head;

        while(firstHead != null && secondHead != null){

            // System.out.println();
            // System.out.println("FirstHead: " + firstHead.value);
            // System.out.println("SecondHead: " + secondHead.value);

            // for firstHead
            Node temp = firstHead.next; // storing the next of the original list
            firstHead.next = secondHead; // updating with the secondHead
            firstHead = temp; // moving the firstHead forward

            // for secondHead
            temp = secondHead.next; // same explaination as for firstHead
            secondHead.next = firstHead;
            secondHead = temp;
        }

        // setting next of tail to null if not
        /*
         * Example:
         * Origin : 1,2,3,4,5
         * 
         * Head first : 1 2 3
         * Head second : 5 4 3
         * 
         * - to prevent the last 3 two times we will set the next of the of the Head first to null
         * - Re-ordered list will be : 1 5 2 4 3 3
         * - to prevent the 3 two times we put the below condition block
         */
        if(firstHead != null){ 
            firstHead.next = null;
        }
    }

}
