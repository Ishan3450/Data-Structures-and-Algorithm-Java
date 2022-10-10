/*
 * Q21: Merge Two Sorted List
 * 
 */

package LeetCodeQuestions;

public class Q21 {
    private ListNode head;
    private ListNode tail;
    
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

    /*
     * Structure of single Node
     */
    private class ListNode{
        private int val;
        private ListNode next;

        ListNode(){}

        ListNode(int value){
            this.val = value;
        }

        ListNode(int value, ListNode next){
            this.val = value;
            this.next = next;
        }
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // dummy node will be null
        ListNode dummyNode = new ListNode();
        // using tail we will insert it from last
        // tail will be refrencing to the dummyNode which is initially null
        ListNode tail = dummyNode;
        
        while(list1 != null && list2 != null){
            if(list1.val < list2.val){ // list1 value is smaller
                tail.next = list1; // setting next of the tail to the list1
                list1 = list1.next; // moving list1 forward
                tail = tail.next; // updating tail
            } else{
                tail.next = list2;
                list2 = list2.next;
                tail = tail.next;
            }
        }
        
        while(list1 != null){
            tail.next = list1;
            list1 = list1.next;
            tail = tail.next;            
        }
        
        while(list2 != null){
            tail.next = list2;
            list2 = list2.next;
            tail = tail.next;            
        }
        
        return dummyNode.next;
    }

    public static void main(String[] args){
        Q21 main = new Q21();
        /*
         * Note: Lists should be in sorted manner/
         */
        Q21 list1 = new Q21();
        list1.insertAtLast(1);
        list1.insertAtLast(3);
        list1.insertAtLast(4);
        list1.insertAtLast(6);
        list1.insertAtLast(11);

        Q21 list2 = new Q21();
        list2.insertAtLast(1);
        list2.insertAtLast(1);
        list2.insertAtLast(2);
        list2.insertAtLast(5);
        list2.insertAtLast(6);
        list2.insertAtLast(10);

        ListNode ans = main.mergeTwoLists(list1.head, list2.head);

        // printing the ans list
        while(ans != null){
            System.out.print(ans.val + " -> ");
            ans = ans.next;
        }

        System.out.println("END");
    }
}
