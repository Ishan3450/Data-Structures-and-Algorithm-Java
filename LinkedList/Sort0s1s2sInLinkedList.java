package LinkedList;

public class Sort0s1s2sInLinkedList {
    // Node structure
    static class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
            // next will be null by default
        }
    }

    /*
     * Approach 1:
     * 
     * - just count the total 0,1 and 2 and replace the actual data with it.
     * - in this approach data replacement is allowed
     */
    static Node Approach1(Node head)
    {
        // add your code here
        if(head == null){
            return head;
        }
        
        Node temp = head;
        int zerosCount = 0, onesCount = 0, twosCount = 0;
        
        while(temp != null){
            if(temp.data == 0){
                zerosCount ++;
            } else if(temp.data == 1){
                onesCount ++;
            } else {
                twosCount ++;
            }
            temp = temp.next;
        }
        
        temp = head; // reset the temp
        
        while(temp != null){
            if(zerosCount != 0){
                temp.data = 0;
                zerosCount --;
            } else if(onesCount != 0){
                temp.data = 1;
                onesCount --;
            } else if(twosCount != 0) {
                temp.data = 2;
                twosCount --;
            }
            temp = temp.next;
        }
        
        return head;
    }

    /*
     * Approach 2:
     * 
     * - Time Complexity: O(N)
     * - Space: O(1)
     * - in this appraoch DATA REPLACEMENT is not allowed
     * - in this make a seperate list of all 0, 1 & 2
     * - and at the end link all the three lists.
     * - for each list we will take dummy node
     * 
     ? - why to take dummy node?
     * - dummy node will help us to get the starting and tne next node of each list.
     * - so we don't have to put conditions and all to get the starting of the list.
     */
    public static Node Approach2(Node head){
        if(head == null)
        { return null; }
        // * Insertion will be done at the tail

        /*
         * head0, head1, head2 are the dummy nodes
         * tail nodes are insertion points
         */
        Node head0 = new Node(-1);
        Node head0Tail = head0;

        Node head1 = new Node(-1);
        Node head1Tail = head1;
        
        Node head2 = new Node(-1);
        Node head2Tail = head2;

        Node temp = head;

        while(temp != null){
            if(temp.data == 0){
                head0Tail.next = temp;
                head0Tail = head0Tail.next;
            } else if(temp.data == 1){
                head1Tail.next = temp;
                head1Tail = head1Tail.next;
            } else if (temp.data == 2) {
                head2Tail.next = temp;
                head2Tail = head2Tail.next;
            }
            temp = temp.next;
        }

        // merging all the list
        if(head1.next != null){ // 1s list is not empty
            head0Tail.next = head1.next;
        } else { // 1s list is empty
            head0Tail.next = head2.next;
        }
        
        head1Tail.next = head2.next;
        head2Tail.next = null;

        head = head0.next;

        return head;
    }

    public static void main(String[] args){

    }
}
