package LinkedListQuestions;

import java.util.HashMap;

class Node{
    int val;
    Node random;
    Node next;

    Node(int val){
        this.val = val;
    }
}
public class CopyListWithRandomPointers {
    // Approach1: recursive approach TC: O(N) and SC: O(N)
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> map = new HashMap<>();
        return helper(head, map);
    }

    public Node helper(Node head, HashMap<Node, Node> map){
        // base condition
        if(head == null){
            return null;
        }

        // function body
        Node newHead = new Node(head.val);
        map.put(head, newHead);
        newHead.next = helper(head.next, map);

        if(head.random != null){
            newHead.random = map.get(head.random);
        }

        return newHead;
    }

    // Approach2: 
    
}
