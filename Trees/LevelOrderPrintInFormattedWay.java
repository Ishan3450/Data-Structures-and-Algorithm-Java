package Trees;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderPrintInFormattedWay {
    public static void main(String[] args) {
        System.out.println("Enter root data: ");
        BuildATree.Node root = BuildATree.buildATree();
        printFormattedLevelOrder(root);
    }   

    private static void printFormattedLevelOrder(BuildATree.Node root){
        System.out.println("Level order traversal in formatted way !!");
        Queue<BuildATree.Node> q = new LinkedList<>();

        q.add(root);
        q.add(null);

        while(!q.isEmpty()){
            BuildATree.Node front = q.peek();

            if(front == null){
                q.remove();
                if(q.isEmpty()){
                    break;
                }
                System.out.println();
                q.add(null);
                continue;
            }

            System.out.print(front.data + " ");
            if(front.left != null){
                q.add(front.left);
            }
            if(front.right != null){
                q.add(front.right);
            }
            q.remove();
        }
    }
}
