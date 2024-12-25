package OOPs.LinkedList;

public class CustomCircularLinkedList {
    private Node head;
    private Node tail;

    CustomCircularLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void insert(int value) {
        Node node = new Node(value);

        if (head == null) { // if head is null it means list is empty
            head = node;
            tail = node;
            return;
        }

        tail.next = node;
        node.next = head;
        tail = node;
    }

    public void display() {
        Node temp = head;

        if(head != null){
            do{
                System.out.print(temp.value + " -> ");
                temp = temp.next;
            } while(temp != head);
        }

        System.out.println("END");

    }

    public void delete(int value){
        Node temp = head;

        if (temp == null) {
            return;
        }

        if (head == tail){
            head = null;
            tail = null;
            return;
        }

        if(temp.value == value){
            head = head.next;
            tail = head;
            return;
        }

        do {
            Node n = temp.next;
            if (n.value == value) {
                temp.next = n.next;
                break;
            }
            temp = temp.next;
        } while (temp != head);
    }

    /*
     * Structure of circular linked list
     */
    private class Node {
        private int value;
        private Node next;

        Node(int value) {
            this.value = value;
        }
    }
}
