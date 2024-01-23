package Heaps;

import java.util.HashMap;
import java.util.PriorityQueue;

// https://www.geeksforgeeks.org/problems/rearrange-characters4649/1

public class RearrangeCharactersUsingHeap {
    private static class Node implements Comparable<Node> {
        char ch;
        int occr;

        Node(char ch, int occr) {
            this.ch = ch;
            this.occr = occr;
        }

        @Override
        public int compareTo(Node n) {
            return this.occr > n.occr ? -1 : 1; // max-heap
        }
    }

    public static String rearrangeCharacters(String str) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0) + 1);
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();

        for (char key : map.keySet()) {
            pq.add(new Node(key, map.get(key)));
        }

        StringBuilder sb = new StringBuilder();

        while (pq.size() > 1) {
            Node mostOccurring = pq.remove();
            Node secondMostOccurring = pq.remove();

            sb.append(mostOccurring.ch);
            sb.append(secondMostOccurring.ch);

            if (--mostOccurring.occr > 0) {
                pq.add(mostOccurring);
            }

            if (--secondMostOccurring.occr > 0) {
                pq.add(secondMostOccurring);
            }

        }

        if (pq.size() == 1) {
            Node top = pq.remove();

            if (top.occr > 1) {
                return "-1";
            }
            sb.append(top.ch);
        }

        return sb.toString();
    }
}
