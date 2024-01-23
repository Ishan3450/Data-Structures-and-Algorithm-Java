package Heaps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class TopKFrequentWords {
    private class HeapNode implements Comparable<HeapNode> {
        String str;
        int occr;

        HeapNode(String str, int occr) {
            this.str = str;
            this.occr = occr;
        }

        @Override
        public int compareTo(HeapNode h) {
            if (h.occr == this.occr) {
                return this.str.compareTo(h.str);
            }

            return this.occr > h.occr ? -1 : 1;
        }
    }

    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> track = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            track.put(words[i], track.getOrDefault(words[i], 0) + 1);
        }

        PriorityQueue<HeapNode> pq = new PriorityQueue<>();

        for (String key : track.keySet()) {
            pq.add(new HeapNode(key, track.get(key)));
        }

        List<String> list = new ArrayList<>();

        while (k > 0) {
            list.add(pq.remove().str);
            k--;
        }

        return list;
    }
}
