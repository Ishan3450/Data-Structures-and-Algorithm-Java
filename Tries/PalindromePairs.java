package Tries;

import java.util.ArrayList;
import java.util.List;

public class PalindromePairs {
    private class TrieNode {
        char data;
        int stringNo; // -1 is normal or any else tells as a terminal node
        TrieNode[] children;

        TrieNode(char data) {
            this.data = data;
            stringNo = -1;
            children = new TrieNode[26];
        }
    }

    private void insert(TrieNode root, String s, int idx, int stringNo) {
        TrieNode temp = root;

        while (idx >= 0) {
            char curr = s.charAt(idx);

            if (temp.children[curr - 'a'] == null) {
                temp.children[curr - 'a'] = new TrieNode(curr);
            }

            temp = temp.children[curr - 'a'];
            idx--;
        }
        temp.stringNo = stringNo;
    }

    private boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (Character.compare(s.charAt(start), s.charAt(end)) != 0) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    private void search(TrieNode root, String s, List<Integer> indices) {
        TrieNode temp = root;

        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            int idx = (int) (curr - 'a');

            if (temp.stringNo != -1) { // terminal node found
                // Case 2 applies here
                if (isPalindrome(s, i, s.length() - 1)) {
                    indices.add(temp.stringNo);
                }
            }

            if (temp.children[idx] == null) {
                return;
            }

            temp = temp.children[idx];
        }

        getAllPalindromicStrings(temp, indices, "");
    }

    private void getAllPalindromicStrings(TrieNode root, List<Integer> indices, String s) {
        // base condition
        if (root.stringNo != -1) {
            if (isPalindrome(s, 0, s.length() - 1)) {
                indices.add(root.stringNo);
            }
        }

        // function body
        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null) {
                getAllPalindromicStrings(root.children[i], indices, s + (char) (i + 'a'));
            }
        }
    }

    public List<List<Integer>> palindromePairs(String[] words) {
        TrieNode root = new TrieNode('-');

        for (int i = 0; i < words.length; i++) {
            insert(root, words[i], words[i].length() - 1, i);
        }

        List<List<Integer>> pairs = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            List<Integer> indices = new ArrayList<>();
            search(root, words[i], indices);

            for (int j = 0; j < indices.size(); j++) {
                if (indices.get(j) != i) {
                    List<Integer> l = new ArrayList<>();
                    l.add(i);
                    l.add(indices.get(j));
                    pairs.add(l);
                }
            }

        }

        return pairs;
    }
}
