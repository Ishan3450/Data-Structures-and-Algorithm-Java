package BinarySearchTrees;

// https://practice.geeksforgeeks.org/problems/predecessor-and-successor/1

public class PredecessorAndSuccesseor {
    static Node pre = null, suc = null;
    public static void findPreSuc(Node root, int key)
    {
        // code here.
        
        /* There are two static nodes defined above pre(representing predecessor) and suc(representing successor) as follows:
           static Node pre=null,suc=null
           You need to update these both.
           And the data inside these classes will be printed automatically by the driver code. 
        */
        getPredecessor(root, key);
        getSuccessor(root, key);
    }
    
    private static void getPredecessor(Node root, int key){
        Node temp = root;
        
        while(temp != null){
            if(temp.data >= key){
                temp = temp.left;
            } else { // root.data < key
                pre = temp;
                temp = temp.right;
            }
        }
    }
    
    private static void getSuccessor(Node root, int key){
        Node temp = root;
        
        while(temp != null){
            if(temp.data > key){
                suc = temp;
                temp = temp.left;
            } else { // root.data <= key
                temp = temp.right;
            }
        }
    }
}
