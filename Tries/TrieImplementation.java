package Tries;

import java.util.Arrays;

/*
 * Trie is a multi-way tree
 * Used for pattern matching, generally in strings
 */

public class TrieImplementation {
    static class TrieNode{
        char data;
        TrieNode[] children;
        boolean isTerminal; // isTerminal used to identify whether the current node is a end of word or not
    
        TrieNode(char data) {
            this.data = data;
            children = new TrieNode[26];
            isTerminal = false;
        }
    }
    
    public static void insertInTrie(TrieNode root, String s) {
        // base condition
        if(s.length() == 0){
            root.isTerminal = true;
            return;
        }

        // function body
        char curr = s.charAt(0);

        if(root.children[curr-'a'] != null){ // root is having a tree with curr as child
            insertInTrie(root.children[curr-'a'], s.substring(1));
        } else { // curr is not a child of root
            root.children[curr-'a'] = new TrieNode(curr);
            insertInTrie(root.children[curr-'a'], s.substring(1));
        }
    }

    public static boolean searchInTrie(TrieNode root, String str){
        // base condition
        if(str.length() == 0){
            return root.isTerminal;
        }

        // function body
        char ch = str.charAt(0);

        if(root.children[ch-'a'] == null){
            return false;
        }

        return searchInTrie(root.children[ch-'a'], str.substring(1));
    }

    public static boolean deleteFromTrie(TrieNode root, String str){
        // base condition
        if(str.length() == 0){
            root.isTerminal = false;
            return true;
        }

        // function body
        char curr = str.charAt(0);

        if(root.children[curr-'a'] == null){
            return false;
        }

        return deleteFromTrie(root.children[curr-'a'], str.substring(1));
    }


    public static void printTrie(TrieNode root){
        TrieNode temp = root;

        while(!temp.isTerminal){
            TrieNode[] children = temp.children;

            for(TrieNode child: children){
                if(child != null){
                    System.out.print(child.data);
                    temp = child;
                }
            }
        }

    }


    public static void main(String[] args) {
        TrieNode t = new TrieNode('-');
        
        insertInTrie(t, "coding");
        insertInTrie(t, "code");
        insertInTrie(t, "coder");
        insertInTrie(t, "codehelp");
        insertInTrie(t, "baba");

        System.out.println(searchInTrie(t, "coding")); // t
        System.out.println(deleteFromTrie(t, "coding")); // t
        System.out.println(searchInTrie(t, "coding")); // f

        System.out.println(searchInTrie(t, "coder")); // t
        System.out.println(deleteFromTrie(t, "coder")); // t
        System.out.println(searchInTrie(t, "coder")); // f
        
        System.out.println(deleteFromTrie(t, "codeo")); // f

    }
}
