package Tries;

public class ImplementTriePrefixTreeLeetcode {
    private class Node {
        char data;
        Node[] children;
        boolean isTerminal;

        Node(char data) {
            this.data = data;
            children = new Node[26];
            isTerminal = false;
        }
    }

    Node root;

    public ImplementTriePrefixTreeLeetcode() {
        root = new Node('-');
    }

    public void insert(String word) {
        Node temp = root;

        for (int i = 0; i < word.length(); i++) {
            char curr = word.charAt(i);
            int idx = (int) (curr - 'a');

            if (temp.children[idx] == null) {
                temp.children[idx] = new Node(curr);
            }

            temp = temp.children[idx];
        }
        temp.isTerminal = true;
    }

    public boolean search(String word) {
        Node temp = root;

        for (int i = 0; i < word.length(); i++) {
            char curr = word.charAt(i);
            int idx = (int) (curr - 'a');

            if (temp.children[idx] == null) {
                return false;
            }

            temp = temp.children[idx];
        }
        return temp.isTerminal;
    }

    public boolean startsWith(String prefix) {
        Node temp = root;

        for (int i = 0; i < prefix.length(); i++) {
            char curr = prefix.charAt(i);
            int idx = (int) (curr - 'a');

            if (temp.children[idx] == null) {
                return false;
            }

            temp = temp.children[idx];
        }
        return true;
    }
}
