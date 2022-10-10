package OOPs.LinkedList;

public class Main {
    public static void main(String[] args) {
        System.out.println("Singly LinkedList");
        System.out.println("-------------------------------");

        CustomSinglyLinkedList list = new CustomSinglyLinkedList();

        // inserting from first
        list.insertAtFirst(3);

        // inserting from last
        list.insertAtLast(334);
        list.insertAtLast(54);
        list.insertAtLast(435);
        list.insertAtLast(765);

        // inserting at a particular index
        list.insertAt(3450, 2);

        
        list.display(); // displaying before removed list
        System.out.println();
        System.out.println("Removed: " + list.deleteFromFirst()); // removing from first
        list.display(); // displaying after removed list

        System.out.println(); // just a break line :)

        // deleting from last
        System.out.println("Removed: " + list.deleteFromLast());
        list.display();

        System.out.println();

        // deleting from a particular index
        System.out.println("Removed: " + list.deleteFrom(2));
        list.display();

        System.out.println();

        System.out.println(list.find(3450));

        System.out.println();
        // current size of LinkedList
        System.out.println("Size: " + list.getSize());

        System.out.println("Doubly LinkedList");
        System.out.println("-------------------------------");

        CustomDoublyLinkedList dList = new CustomDoublyLinkedList();

        dList.insertAtFirst(1);

        dList.insertAtLast(2);
        dList.insertAtLast(3);
        dList.insertAtLast(4);
        dList.insertAtLast(5);
        dList.insertAtLast(6);

        dList.display();
        System.out.println();
        dList.displayInReverse();

        System.out.println();
        System.out.println("Inserted: 7");
        dList.insertAtLast(7);
        dList.display();

        System.out.println();
        System.out.println("Inserted 3 at 3rd Index");
        dList.insertAt(3, 3);
        dList.insertAt(999, 10); // 10 is out of the size of linked list so it will be added at last with value 999
        dList.insertAt(8, 8);
        dList.display();

        System.out.println();
        dList.insertAfter(8, 9);
        dList.insertAfter(3, 10);
        dList.display();

        System.out.println();
        dList.display();        

        System.out.println();
        System.out.println("Deleted value from first: " + dList.deleteFromFirst());;
        dList.display();

        System.out.println();
        System.out.println("Deleted value from first: " + dList.deleteFromFirst());;
        dList.display();

        System.out.println();
        System.out.println("Circular LinkedList");
        System.out.println("-------------------------------");

        CustomCircularLinkedList cList = new CustomCircularLinkedList();

        cList.insert(1);
        cList.insert(2);
        cList.insert(3);
        cList.insert(5);
        cList.insert(6);
        System.out.println("Deleted: 6");
        cList.delete(6);
        cList.display();
        

    }
}

