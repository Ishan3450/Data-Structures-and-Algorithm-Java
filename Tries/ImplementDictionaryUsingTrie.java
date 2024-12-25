/*
 * Given a string: codef and array of strings: [code, coder, codechef, coding, car, cast]
 * 
 * We have to tell that:
 * at c, co, cod, code, codef what suggestions we will be getting
 * 
 * c -> code, coder, codechef, coding, car, cast
 * co -> code, coder, codechef, coding
 * cod -> code, coder, codechef, coding
 * code -> code, coder, codechef
 * codef -> empty
 * 
 */

package Tries;

import java.util.*;

public class ImplementDictionaryUsingTrie {
    private static class TrieNode{
        char data;
        TrieNode[] children;
        boolean isTerminal;

        TrieNode(char data) {
            this.data = data;
            children = new TrieNode[26];
            isTerminal = false;
        }
    }

    private static void insertInTrie(TrieNode root, String str, int idx){
        // base condition
        if(idx >= str.length()){
            root.isTerminal = true;
            return;
        }

        // function body
        char curr = str.charAt(idx);

        if(root.children[curr-'a'] == null){
            root.children[curr-'a'] = new TrieNode(curr);
        }
        
        insertInTrie(root.children[curr-'a'], str, idx+1);
    }

    public static List<List<String>> getAllSuggestions(TrieNode root, String query) {
        List<List<String>> allSuggestions = new ArrayList<>();

        TrieNode prev = root;
        
        String currQuery = "";
        for(int i = 0; i < query.length(); i++){
            currQuery += query.charAt(i);
            TrieNode curr = prev.children[query.charAt(i) - 'a'];

            if(curr == null){
                break;
            }

            List<String> suggestions = new ArrayList<>();
            getSuggestions(curr, currQuery, suggestions);
            
            System.out.println("For " + currQuery + " " + suggestions);
            System.out.println();

            allSuggestions.add(suggestions);
            prev = curr;
        }

        return allSuggestions;
    }

    public static void getSuggestions(TrieNode root, String s, List<String> suggestion){
        // base condition
        if(root.isTerminal){
            suggestion.add(s);
        }

        // function body
        TrieNode[] children = root.children;

        for(TrieNode child: children){
            if(child != null){
                getSuggestions(child, s + child.data, suggestion);
            }
        }
    }

    public static void main(String[] args) {
        TrieNode root = new TrieNode('-');

        insertInTrie(root, "code", 0);
        insertInTrie(root, "coder", 0);
        insertInTrie(root, "codechef", 0);
        insertInTrie(root, "coding", 0);
        insertInTrie(root, "car", 0);
        insertInTrie(root, "casting", 0);
        insertInTrie(root, "cast", 0);

        List<String> list = new ArrayList<>();

        getSuggestions(root, "", list);

        System.out.println(getAllSuggestions(root, "codec"));
    }
}
