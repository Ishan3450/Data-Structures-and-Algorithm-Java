/*
 * LC; 1079
 * 
 * Tips in notion.
 */


package Backtracking;

import java.util.HashSet;

public class LetterTilePossibilities {
    public int numTilePossibilities(String tiles) {
        HashSet<String> set = new HashSet<>();
        boolean[] visited = new boolean[tiles.length()];
        helper(tiles, set, visited, new StringBuilder(""));
        return set.size() - 1;
    }

    public void helper(String tiles, HashSet<String> set, boolean[] visited, StringBuilder seq) {
        set.add(seq.toString());
        for (int i = 0; i < tiles.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                seq.append(tiles.charAt(i));

                // recursive call
                helper(tiles, set, visited, seq);

                // backtracking
                seq.deleteCharAt(seq.length() - 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {

    }
}