package OOPs.LinkedList;

public class CustomDoublyLinkedList {
    private Node head;

    /*
     * Structure of Doubly Linked List
     */
    private class Node {
        private Node next;
        private Node prev;
        private int value;

        Node() {
        }

        Node(int value) {
            this.value = value;
        }

        Node(int value, Node prev, Node next) {
            this.value = value;
            this.prev = prev;
            this.next = next;
        }
    }

    public void insertAtFirst(int value) {
        Node node = new Node(value);
        node.next = head;
        node.prev = null;

        if (head != null) {
            head.prev = node;
        }

        head = node;

        // if(tail == null){
        // tail = head;
        // }
        
    }

    public void insertAtLast(int value) {
        Node node = new Node(value);

        if(head == null){
            head = node;
            node.prev = null;
        }

        Node tail = head;

        while (tail.next != null) {
            tail = tail.next;
        }

        tail.next = node;
        node.prev = tail;
        node.next = null;
    }

    public void insertAt(int value, int index){
        if(index == 0){
            insertAtFirst(value);
        }

        Node temp = get(index);


        Node node = new Node(value);

        if(temp.next == null){ // if condition is true, we are at tail
            insertAtLast(value);
            return;
        }

        temp.next.prev = node;
        node.next = temp.next;
        temp.next = node;
        node.prev = temp;
    }

    public void insertAfter(int after, int value){
        Node temp = find(after);

        if(temp.next == null){ // if condition is true, we are at tail
            insertAtLast(value);
        }

        Node node = new Node(value);

        temp.next.prev = node;
        node.next = temp.next;
        temp.next = node;
        node.prev = temp;
    }

    public int deleteFromFirst(){
        int value = head.value;
        head = head.next;
        return value;
    }

    

    public Node find(int value){
        Node temp = head;

        while(temp.next != null){
            if(temp.value == value){
                return temp;
            }
            temp = temp.next;
        }

        return null;
    }

    public Node get(int index){
        Node temp = head;

        for(int i=1; i<index; i++){
            if(temp.next != null){
                temp = temp.next;
            }
        }
        return temp;
    }

    public void display() {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }

    public void displayInReverse() {
        Node node = head;
        Node tail = null;

        while (node != null) {
            tail = node;
            node = node.next;
        }

        while (tail != null) {
            System.out.print(" <- " + tail.value);
            tail = tail.prev;
        }
        System.out.println(" <- START");
    }

}
