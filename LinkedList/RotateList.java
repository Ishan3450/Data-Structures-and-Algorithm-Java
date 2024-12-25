package LinkedList;

public class RotateList {
    public Node rotateRight(Node head, int k) {
        if(k <= 0 || head == null || head.next == null){
            return head;
        }
        
        Node last = head;
        int length = 1; // initial length is 1 as we are starting from head
        while(last.next != null){
            length ++;
            last = last.next;
        }
        
        // now our last element is pointing to the starting of the list
        last.next = head;
        
        int rotations = k % length;
        int toSkip = length - rotations;
        
        Node newEnd = head;
        
        for(int i=0; i < toSkip-1; i++){
            newEnd = newEnd.next; 
        }
        
        head = newEnd.next; // updating head
        newEnd.next = null;
        
        return head;
    }
}
