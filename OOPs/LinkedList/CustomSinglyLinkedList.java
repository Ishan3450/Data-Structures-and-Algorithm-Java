package OOPs.LinkedList;

public class CustomSinglyLinkedList {
    private Node head;
    private Node tail;
    private int size;

    public CustomSinglyLinkedList() {
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

    public void insertAt(int value, int index) {
        if (index == 0) {
            insertAtFirst(value);
            return;
        }

        if (index == size) {
            insertAtLast(value);
            return;
        }

        Node temp = head;
        // starting index from 1 as 0 is for head
        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }

        Node box = new Node(value, temp.next);
        temp.next = box;
        size += 1;
    }

    public int deleteFromFirst() {
        int val = head.value;
        head = head.next;

        if (head == null) { // if head is null it means linked list is of size 1 so we have to also null the tail
            tail = null;
        }
        size -= 1;
        return val;
    }

    public int deleteFromLast() {
        if (size <= 1) {
            return deleteFromFirst();
        }

        Node lastSecondElement = get(size - 2);
        int val = tail.value;

        tail = lastSecondElement;
        tail.next = null;

        size -= 1;

        return val;
    }

    public int deleteFrom(int index) {
        if (size == 1) {
            return deleteFromFirst(); // using deleteFromFirst as it will also put null to the tail
        }

        Node prev = get(index - 1);
        int value = prev.next.value;
        prev.next = prev.next.next;

        return value;
    }

    public Node find(int value){
        Node temp = head;

        while(temp != null){
            if(temp.value == value){
                return temp;
            }
            temp = temp.next;
        }

        return null;
    }

    public Node get(int index) {
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    public void display() {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }

        System.out.println("END");
    }

    public int getSize() {
        return size;
    }

    public void display(Node box){
        System.out.println("Value: " + box.value);
    }
}
