package Trees;

import java.util.ArrayList;

public class BinarySearchTree {
    static class TreeNode{
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data){
            this.data = data;
            // left and right, by default will be null
        }
    }

    public static TreeNode insert(TreeNode root, int data){
        if(root == null){
            root = new TreeNode(data);
            return root;
        }

        if(root.data > data){ // if current root's data is greater than the data then we have to insert that data at the left side of the root
            root.left = insert(root.left, data);
        } else{ // insert at the right subtree
            root.right = insert(root.right, data);
        }

        return root;
    }

    public static void InOrderTraversal(TreeNode root){
        // base condition
        if(root == null){
            return;
        }

        /*
         * left
         * root
         * right
         */
        InOrderTraversal(root.left);
        System.out.print(root.data + " ");
        InOrderTraversal(root.right);
    }

    /*
     * Search an element in BST
     * O(H) - where H stands for height of the tree
     */
    public static boolean search(TreeNode root, int key){
        // base condition
        if(root == null){
            return false;
        }

        // function body
        if(key == root.data){
            return true;
        }

        if(key > root.data){ // is key is greater than the curr root then search in the right part of the tree
            return search(root.right, key);
        } else{ // else search in the left part of the array
            return search(root.left, key);
        }
    }

    /*
     ? > Most Important to Understand and Implement
     * Delete a Node from BST
     * 
     * There are 3 main cases to delete a Node:
     * 
     * 1. No Child (Leaf Node)
     *      - Delete that node and return null to parent
     * 2. One Child
     *      - Delete that node and replace it with it's child node
     * 3. Two Children
     *      - Replace the value with the inorder successor
     *          - Inorder successor successor will always have either 1 child or no child
     *          - NOTE: Inorder successor is the leftmost left node of the right sub-tree
     *      - And delete the node
     */
    public static TreeNode delete(TreeNode root, int key){
        if(root == null){
            return root;
        }

        if(key > root.data){ // in the right subtree
            root.right = delete(root.right, key);
        } else if(key < root.data){ // in the left subtree
            root.left = delete(root.left, key);
        }
        else{ // else condition will hit only if key == root.data

            // case 1 - no child
            if(root.left == null && root.right == null){
                return null;
            }

            // case 2 - have only single child
            if(root.left == null){ // if left is null, return right child
                return root.right;
            }

            if(root.right == null){ // if right is null, return left child
                return root.left;
            }

            // case 3 - have 2 children (the main case)
            // 1st we have to find the inorder successor
            TreeNode IS = InorderSuccessor(root.right); // passing right of the root because: Inorder successor is the leftmost left node of the RIGHT sub-tree
            root.data = IS.data; // copying IS.data in the root.data, after that we can delete the IS
            root.right = delete(root.right, IS.data); // deleting the IS from the right subtree of the node
            // stored root.right in the above line coz we have deleted IS from the right sub-tree

        }

        return root;
    }

    // method to find the inorder successor of the node passed in the arguement
    public static TreeNode InorderSuccessor(TreeNode root){
        while(root.left != null){
            root = root.left;
        }

        return root;
    }

    /*
     * Print in Range
     */
    public static void printInRange(TreeNode root, int left, int right){
        if(root == null){
            return;
        }

        int data = root.data;
        
        if(data >= left && data <= right){ // if right lines in range then we have to print the left subtree first then root and then the right subtree
            printInRange(root.left, left, right); // left subtree
            System.out.print(data + " "); // root
            printInRange(root.right, left, right); // right subtree
        } 
        else if(data >= right){ // if data is greater then print the left subtree
            printInRange(root.left, left, right);
        } 
        else { // right subtree
            printInRange(root.right, left, right);
        }
    }

    public static void printRoot2LeafNode(TreeNode root, ArrayList<Integer> path){
        // base condition
        if(root == null){
            return;
        }

        // function body
        path.add(root.data);

        // checking for the leaf node
        if(root.left == null && root.right == null){ // for leaf nodes
            System.out.println(path);
        } else{ // for non-leaf nodes
            printRoot2LeafNode(root.left, path);
            printRoot2LeafNode(root.right, path);
        }

        // * backtracking: reverting back the added root data
        path.remove(path.size() - 1);
    }

    public static void main(String[] args){
        // int[] values = {5,1,3,4,2,7};
        int[] values = {8,5,3,1,4,6,10,11,14};
        TreeNode root = null;

        for(int i=0; i<values.length; i++){
            root = insert(root, values[i]);
        }

        InOrderTraversal(root);

        System.out.println();
        System.out.println("Searching in BST");
        for(int i=1; i<=10; i++){
            System.out.println(i + ": " + search(root, i));
        }

        System.out.println();
        System.out.println("Deletion in BST");
        // before
        InOrderTraversal(root);
        System.out.println();

        // deleting
        delete(root, 5);

        // after
        InOrderTraversal(root);

        System.out.println();
        System.out.print("Printing in range: ");
        printInRange(root, 3, 10);

        System.out.println();
        System.out.println("Root to leaf nodes paths: ");
        printRoot2LeafNode(root, new ArrayList<>());
    }
}
