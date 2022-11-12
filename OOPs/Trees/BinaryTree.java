package OOPs.Trees;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    static class TreeNode{
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTreeStructure {
        static int index = -1; // initial value represents the tree is empty

        public static TreeNode createNode(int[] nodes){
            index ++;
            if(nodes[index] == -1){
                return null;
            }

            TreeNode treeNode = new TreeNode(nodes[index]);
            treeNode.left = createNode(nodes);
            treeNode.right = createNode(nodes);

            return treeNode;
        }
    }

    /*
     * Pre-order: O(N) DFS Approach
     * 
     * 1. Root
     * 2. Left Subtree
     * 3. Right Subtree
     */
    public static void PreorderTraversal(TreeNode root){
        // base condition
        if(root == null){
            return;
        }

        // function body
        System.out.print(root.data + " ");
        PreorderTraversal(root.left);
        PreorderTraversal(root.right);
    }
    
    /*
     * In-order: O(N) DFS Approach
     * 
     * 1. Left Subtree
     * 2. Root
     * 3. Right Subtree
     */
    public static void InorderTraversal(TreeNode root){
        // base condition
        if(root == null){
            return;
        }

        // function body
        InorderTraversal(root.left);
        System.out.print(root.data + " ");
        InorderTraversal(root.right);
    }
    

    /*
     * Post-order: O(N) DFS Approach
     * 
     * 1. Left Subtree
     * 2. Right Subtree
     * 3. Root
     */
    public static void PostorderTraversal(TreeNode root){
        // base condition
        if(root == null){
            return;
        }

        // function body
        PostorderTraversal(root.left);
        PostorderTraversal(root.right);
        System.out.print(root.data + " ");
    }
    
    /*
     * Level-order: O(N) BFS Approach
     * 
     * We will use queue to get the level tree nodes
     */
    public static void levelOrder(TreeNode root){
        if(root == null){
            return;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null); // * NULL represents new line or the end of the current level

        while(!q.isEmpty()){
            TreeNode currNode = q.remove();
            if(currNode == null){ // if it is null it means we have to print new line
                System.out.println();
                if(q.isEmpty()){
                    break;
                } else{ // add the null back for the next level
                    q.add(null);
                }
            } else{
                System.out.print(currNode.data + " ");
                if(currNode.left != null){
                    q.add(currNode.left);
                }

                if(currNode.right != null){
                    q.add(currNode.right);
                }
            }
        }
    }

    /*
     * Count of Nodes
     * O(N)
     */
    public static int count(TreeNode root){
        // base condition
        if(root == null){
            return 0;
        }

        // function body
        int leftNodes = count(root.left);
        int rightNodes = count(root.right);
        // System.out.println(leftNodes + " " + rightNodes);

        return leftNodes + rightNodes + 1; // + 1 for the root itself
    }

    /*
     * Sum of nodes
     * O(N)
     */
    public static int sum(TreeNode root){
        // base condition
        if(root == null) {
            return 0;
        }

        // function body
        int leftSum = sum(root.left);
        int rightSum = sum(root.right);

        return leftSum + rightSum + root.data;
    }

    /*
     * Height of tree
     * O(N)
     */
    public static int height(TreeNode root){
        // base condition
        if(root == null){
            return 0;
        }

        // function body
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        int currLevelHeight = Math.max(leftHeight, rightHeight) + 1; // + 1 for the root itself
        return currLevelHeight;
    }

    /*
     * Diameter of tree
     * O(N^2)
     */
    public static int diameter(TreeNode root){
        // base condition
        if(root == null){
            return 0;
        }

        // function body
        int diameter1 = diameter(root.left);
        int diameter2 = diameter(root.right);
        int diameter3 = height(root.left) + height(root.right) + 1; // + 1 is for root itself

        return Math.max(diameter3, Math.max(diameter1, diameter2));
    }

    /*
     * Sum of Kth level nodes of Tree
     */
    public static int SumOfKthLevel(TreeNode root, int k){
        if(root == null){
            return -1;
        }
        int sum = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null); // * NULL represents new line or the end of the current level

        while(!q.isEmpty()){
            TreeNode currNode = q.remove();
            if(currNode == null){ // if it is null it means we have to print new line
                k--;
                if(q.isEmpty()){
                    break;
                } else{ // add the null back for the next level
                    q.add(null);
                }
            } else{
                if(k == 0){
                    sum += currNode.data;
                }
                if(currNode.left != null){
                    q.add(currNode.left);
                }

                if(currNode.right != null){
                    q.add(currNode.right);
                }
            }
        }

        return sum;
    }

    public static void main(String[] args){
        int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        BinaryTreeStructure bTree = new BinaryTreeStructure();

        TreeNode rootNode = bTree.createNode(nodes);
        System.out.print("Pre-order traversal: ");
        PreorderTraversal(rootNode);
        System.out.println();

        System.out.print("In-order traversal: ");
        InorderTraversal(rootNode);
        System.out.println();

        System.out.print("Post-order traversal: ");
        PostorderTraversal(rootNode);
        System.out.println();

        System.out.println("Level-order traversal: ");
        levelOrder(rootNode);
        
        System.out.println("Total Count: " + count(rootNode));

        System.out.println("Total Sum: " + sum(rootNode));

        System.out.println("Height: " + height(rootNode));

        System.out.println("Diameter: " + diameter(rootNode));

        System.out.println("Sum of kth level: " + SumOfKthLevel(rootNode, 1));        
    }
}
