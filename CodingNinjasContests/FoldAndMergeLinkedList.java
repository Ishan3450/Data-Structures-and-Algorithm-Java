/*
 * CodingNinjas Medium Question
 * 
 * Self Implemented Approach
 * Approach:
 * Step 1: Determine the length of the LinkedList
 * Step 2: Break the LL in two halves by using loop from 0 till length/2
 * Step 3: Reverse te second half of the LL
 * Step 4: Put the temp pointers at the starting of both of the halves
 * Step 5: Multiply and merge it to make a LL.
 */

package CodingNinjasContests;

public class FoldAndMergeLinkedList {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    };

    public static void print(Node head){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("End");
    }

    public static int getLength(Node head) {
        Node temp = head;
        int count = 1; // count is 1 as starting from the head, so we have to count the head

        while (temp.next != null) {
            temp = temp.next;
            count++;
        }
        return count;
    }

    public static Node reverseList(Node head){
        if(head == null || head.next == null){
            return head;
        }

        Node prev = null;
        Node curr = head;
        Node next = head.next;

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

    public static Node foldAndMerge(Node head) {
        // Write your code here.

        // s1: determine the length of the LL
        int length = getLength(head);

        // s2: break the LL in exact two halves
        Node temp = head;
        for(int i=1; i<length/2; i++){ // i<length/2 as we are staring from the head if we are starting from null then then i<=length/2
            temp = temp.next;
        }

        // 2nd Half start
        Node newStart = temp.next; 

        // End of 1st half
        temp.next = null;

        // s3: reverse the first half of the list 
        temp = reverseList(head);

        // s4: start multiplying the data of both pointers and make a new node from it and make a new list
        Node ans = new Node(-1);
        Node dummy = ans;
        
        while(temp != null || newStart != null){
            int product = temp.data * newStart.data;
            Node newNode = new Node(product);

            dummy.next = newNode;
            dummy = dummy.next;

            temp = temp.next;
            newStart = newStart.next;
        }

        return ans.next;
    }

    public static void main(String[] args) {
        Node node = new Node(-1);
        Node dummy = node;

        for(int i=1; i<=4; i++){
            Node temp = new Node(i);
            dummy.next = temp;
            dummy = dummy.next;
        }

        print(node.next);

        Node ans = foldAndMerge(node.next);

        System.out.println("Answer");
        print(ans);
    }

}
