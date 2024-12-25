/*
 * In BubbleSort in LinkedList there can be 3 cases to swap:
 * 
 * Case 1: when the first element if head
 * Case 2: when the second element if tail
 * Case 3: when first and second both lies between head and tail (excluding head & tail)
 * 
 * - So approach the problem keeping the cases in mind.
 */

package LinkedList;

public class BubbleSortInLinkedList {
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
     * Main Code starts here
     */

    public void BubbleSort(int i, int j){
        // base condition
        if(i == 0){
            return;
        }

        // function body
        if(j < i){
            ListNode first = get(j);
            ListNode second = get(j+1);

            if(first == head){ // CASE 1
                head = second;
                first.next = second.next;
                head.next = first;
            } else if(second == tail){ // CASE 2
                ListNode prev = get(j-1);
                tail = first;
                prev.next = first.next;
                second.next = tail;
                tail.next = null;
            } else{ // CASE 3
                ListNode prev = get(j-1);
                prev.next = first.next;
                first.next = second.next;
                second.next = first;
            }

            BubbleSort(i, j+1);
        } else{
            BubbleSort(i-1, 0);
        }
    }
}

