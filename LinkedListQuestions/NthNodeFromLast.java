package LinkedListQuestions;

public class NthNodeFromLast {

    int getLength(Node head) {
        int length = 0;
        Node temp = head;

        while (temp != null) {
            length++;
            temp = temp.next;
        }
        return length;
    }

    // Approach 1: The iterative way
    int getNthFromLast(Node head, int n) {
        // Your code here
        // if(head == null || head.next == null){
        // return head.data;
        // }

        int length = getLength(head);

        Node ans = head;
        if (length - n < 0) {
            return -1;
        }

        for (int i = 0; i < length - n; i++) {
            ans = ans.next;
        }
        return ans.data;
    }

    // Approach 2: The Recursive way
    private static int getNthNodeFromLast(Node head, int n) {
        int[] ans = new int[1];
        helper(head, new int[]{n}, ans);
        return ans[0];
    }

    private static void helper(Node head, int[] idxFromBack, int[] ans){
        // base condition
        if(head == null){
            return;
        }

        // function body + recusive relation
        helper(head.next, idxFromBack, ans);

        if(idxFromBack[0] == 0){
            ans[0] = head.data;
        }
        idxFromBack[0]--;
    }


    public static void main(String[] args) {
        // 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> null
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;

        System.out.println(getNthNodeFromLast(n1, 2));
    }
}
