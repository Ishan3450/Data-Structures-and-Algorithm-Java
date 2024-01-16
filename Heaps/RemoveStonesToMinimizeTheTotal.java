package Heaps;

import java.util.Collections;
import java.util.PriorityQueue;

public class RemoveStonesToMinimizeTheTotal {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int totalStones = 0;

        for (int i = 0; i < piles.length; i++) {
            pq.add(piles[i]);
            totalStones += piles[i];
        }

        while (k > 0) {
            int biggestPile = pq.remove();
            int toBeRemovedStones = (int) Math.floor(biggestPile / 2);
            int pileAfterRemoval = biggestPile - toBeRemovedStones;

            totalStones -= toBeRemovedStones;
            pq.add(pileAfterRemoval);
            k--;
        }
        return totalStones;
    }
}
