package BinarySearchTrees;

public class BSTToDoublySortedLinkedList {
    Node bToDLL(Node root){
	    Node[] head = new Node[1];
	    createList(root, head);
	    return head[0];
    }
    
    private void createList(Node root, Node[] head){
        // base condition
        if(root == null){
            return;
        }
        
        // funtion body
        createList(root.right, head);
        
        root.right = head[0];
        if(head[0] != null) head[0].left = root;
        head[0] = root;
        
        createList(root.left, head);
    }
}
