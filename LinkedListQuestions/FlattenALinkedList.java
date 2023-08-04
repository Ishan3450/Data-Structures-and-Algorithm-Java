package LinkedListQuestions;

class Node{
    int data;
    Node next;
    Node bottom;

    Node(int data){
        this.data = data;
    }
}

public class FlattenALinkedList {
    Node flatten(Node root){
	    // Your code here
	    Node sortedList = root;
	    Node temp = root.next;
	    
	    while(temp != null){
	        sortedList = merge(sortedList, temp);
	        temp = temp.next;
	    }
	    
	    return sortedList;
    }
    
    Node merge(Node sorted, Node curr){
        Node newHead = new Node(-1);
        Node temp = newHead;
        
        while(sorted != null && curr != null){
            if(sorted.data <= curr.data){
                temp.bottom = sorted;
                sorted = sorted.bottom;
                temp = temp.bottom;
            } else{
                temp.bottom = curr;
                curr = curr.bottom;
                temp = temp.bottom;
            }
        }
        
        if(sorted != null){
            temp.bottom = sorted;
        } else{
            temp.bottom = curr;
        }
        
        return newHead.bottom;
    }
}
