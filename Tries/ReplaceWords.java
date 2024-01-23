package Tries;

import java.util.List;

public class ReplaceWords {
    private class Node {
        char data;
        Node[] children;
        boolean isTerminal;

        Node(char data) {
            this.data = data;
            this.children = new Node[26];
            this.isTerminal = false;
        }
    }

    private void insert(Node root, String s) {
        Node temp = root;

        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            int idx = (int) (curr - 'a');

            if (temp.children[idx] == null) {
                temp.children[idx] = new Node(curr);
            }

            temp = temp.children[idx];
        }
        temp.isTerminal = true;
    }

    private String getRootForm(Node root, String s) {
        StringBuilder sb = new StringBuilder();

        Node temp = root;

        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            int idx = (int) (curr - 'a');

            if (temp.children[idx] == null) {
                return s;
            }

            sb.append(curr);

            // way 1 to terminal on the end node
            if (temp.children[idx].isTerminal) {
                return sb.toString();
            }

            temp = temp.children[idx];

            // way 2 to terminal on the end node
            // if(temp.isTerminal){
            // return sb.toString();
            // }

        }

        return s;
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        Node root = new Node('-');

        for (int i = 0; i < dictionary.size(); i++) {
            insert(root, dictionary.get(i));
        }

        String[] splitted = sentence.split(" ");

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < splitted.length; i++) {
            String rootForm = getRootForm(root, splitted[i]);

            if (sb.length() != 0) {
                sb.append(" ");
            }
            sb.append(rootForm);
        }

        return sb.toString();
    }
}
