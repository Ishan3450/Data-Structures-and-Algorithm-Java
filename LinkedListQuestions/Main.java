/*
 * This file is just for running the code written in All.java file
 */

package LinkedListQuestions;

public class Main {
    public static void main(String[] args){
        All SLL = new All();

        SLL.insertAtFirst(1);
        SLL.insertAtLast(2);
        SLL.insertAtLast(2);
        SLL.insertAtLast(3);

        /* 
         * Main Code starts here
         */
        SLL.insertAtUsingRecursion(2, 2);
        SLL.insertAtUsingRecursion(0, 1);

        SLL.display();
        SLL.removeDuplicates();
        SLL.display();

        // for merge two sorted list
        System.out.println("-----------------");
        All L1 = new All();
        L1.insertAtLast(1);
        L1.insertAtLast(3);
        L1.insertAtLast(5);

        All L2 = new All();
        L2.insertAtLast(2);
        L2.insertAtLast(4);
        L2.insertAtLast(6);

        System.out.print("List 1: ");
        L1.display();

        System.out.print("List 2: ");
        L2.display();

        All ans = SLL.merge(L1, L2);
        System.out.print("Ans: ");
        ans.display();

        System.out.println();
        SLL.display(SLL.middleNode(ans));

        System.out.println();

        // Sorting code starts
        MergeSortInLinkedList list = new MergeSortInLinkedList();
        list.insertAtLast(199);
        list.insertAtLast(54);
        list.insertAtLast(23);
        list.insertAtLast(453);

        list.display(list.sortList(list.getHead()));
        // code ends


        // Bubble Sort
        System.out.println();
        System.out.println("Bubble Sort");
        System.out.println("----------------------");
        BubbleSortInLinkedList bsList = new BubbleSortInLinkedList();
        for(int i=7; i>0; i--){
            bsList.insertAtLast(i);
        }
        bsList.display();
        bsList.BubbleSort(bsList.getLength() - 1, 0);
        bsList.display();

        System.out.println();
        System.out.println("Reversing Linked List");
        System.out.println("------------------------");
        ReversingLinkedList rLL = new ReversingLinkedList();
        for(int i=1; i<=7; i++){
            rLL.insertAtLast(i);
        }

        rLL.display();
        rLL.reverseUsingRecursion(rLL.getHead());
        rLL.display();

        System.out.println();
        rLL.display();
        System.out.println("Reversed in-between:");
        rLL.display(rLL.reverseBetween(rLL.getHead(), 2, 4));

        System.out.println();
        System.out.println("Re ordering Linked List");
        System.out.println("------------------------");
 
        SLL.insertAtLast(4);
        SLL.insertAtLast(5);
        // SLL.insertAtLast(6);

        SLL.display();
        System.out.println();
        SLL.reorderList(SLL.getHead());
        SLL.display();

    }
    
}
