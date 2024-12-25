package Graphs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadder {
    private class Pair {
        String word;
        int count;

        Pair(String word, int count) {
            this.word = word;
            this.count = count;
        }
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> words = new HashSet<>(wordList);

        if (!words.contains(endWord)) {
            return 0;
        }

        return bfs(beginWord, endWord, words);
    }

    public int bfs(String beginWord, String endWord, Set<String> words) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(beginWord, 1));
        words.remove(beginWord);

        while (!q.isEmpty()) {
            Pair peek = q.remove();

            if (peek.word.equals(endWord)) {
                return peek.count;
            }

            for (int i = 0; i < peek.word.length(); i++) {
                StringBuilder sb = new StringBuilder(peek.word);

                for (char c = 'a'; c <= 'z'; c++) {
                    sb.setCharAt(i, c);
                    String modified = sb.toString();

                    if (words.contains(modified)) {
                        words.remove(modified); // last time while solving this problem forgot to remove the modified word from the set
                        q.add(new Pair(modified, peek.count + 1));
                    }
                }
            }
        }
        return 0;
    }
}
