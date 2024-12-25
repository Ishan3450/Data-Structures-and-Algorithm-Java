package Graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class WordLadder2 {
    private class Pair {
        ArrayList<String> words;
        int level;

        Pair(ArrayList<String> words, int level) {
            this.words = words;
            this.level = level;
        }
    }

    public ArrayList<ArrayList<String>> findSequences(String startWord, String targetWord, String[] wordList) {
        ArrayList<ArrayList<String>> sequences = new ArrayList<>();

        Set<String> set = new HashSet<>();
        for (String s : wordList)
            set.add(s);

        if (!set.contains(targetWord)) {
            return new ArrayList<>();
        }

        ArrayList<String> temp = new ArrayList<>();
        temp.add(startWord);

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(temp, 1));

        ArrayList<String> wordsToBeRemoved = new ArrayList<>();
        wordsToBeRemoved.add(startWord);

        int prevLevel = -1;

        while (!q.isEmpty()) {
            Pair peek = q.remove();
            ArrayList<String> peekList = peek.words;

            if (peekList.get(peekList.size() - 1).equals(targetWord)) {
                sequences.add(peek.words);
                continue;
            }

            if (prevLevel != peek.level) {
                // remove all the wordsTobeRemoved strings from set
                for (String s : wordsToBeRemoved) {
                    set.remove(s);
                }
                wordsToBeRemoved.clear();
                prevLevel = peek.level;
            }

            for (int i = 0; i < peekList.get(peekList.size() - 1).length(); i++) {
                StringBuilder curr = new StringBuilder(peekList.get(peekList.size() - 1));
                for (char c = 'a'; c <= 'z'; c++) {
                    curr.setCharAt(i, c);

                    String modified = curr.toString();
                    if (set.contains(modified)) {
                        wordsToBeRemoved.add(modified);
                        ArrayList<String> cloned = (ArrayList<String>) peekList.clone();
                        cloned.add(modified);

                        q.add(new Pair(cloned, peek.level + 1));
                    }
                }
            }
        }

        return sequences;
    }
}
