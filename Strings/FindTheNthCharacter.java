package Strings;

public class FindTheNthCharacter {
    private class ListNode {
        char data;
        ListNode next;

        ListNode(char data) {
            this.data = data;
            next = null;
        }
    }

    public char nthCharacter(String s, int r, int n) {
        ListNode dummy = new ListNode('t'); // dummy
        ListNode temp = dummy;

        for (int i = 0; i < s.length(); i++) {
            temp.next = new ListNode(s.charAt(i));
            temp = temp.next;
        }

        while (r > 0) {
            temp = dummy.next;
            while (temp != null) {
                ListNode newNode;
                if (temp.data == '1') {
                    newNode = new ListNode('0');
                } else { // temp.data is 0
                    newNode = new ListNode('1');
                }

                newNode.next = temp.next;
                temp.next = newNode;

                if (temp.next != null)
                    temp = temp.next.next;
                else
                    temp = null;
            }

            /*
             * Catch in this problem:
             * - If we take the whole new string then it will get to TLE
             * - Instead we have to take string which is of atmmost size n because we want
             * only nth character
             */
            temp = dummy.next;
            for (int i = 0; i < n; i++) {
                temp = temp.next;
            }
            temp.next = null;
            r--;
        }

        temp = dummy.next;
        while (temp.next != null) {
            temp = temp.next;
        }
        return temp.data;
    }
}
