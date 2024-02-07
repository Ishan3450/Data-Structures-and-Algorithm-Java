package Hashing;

import java.util.HashMap;
import java.util.Objects;

public class CustomClassAsAKeyInHashMap {
    private static class Pair {
        int from;
        int to;

        Pair(int from, int to) {
            this.from = from;
            this.to = to;
        }

        /*
         * Below equals() and hashCode() method is necessary to implement when we are using custom class as a key in hashmap
         */

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;
            Pair pair = (Pair) o;
            return from == pair.from && to == pair.to;
        }

        @Override
        public int hashCode() {
            return Objects.hash(from, to);
        }
    }

     public static void main(String[] args) {
        int[] arr = { 6, 2, 4 };

        HashMap<Pair, Integer> rangeMaxValues = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            rangeMaxValues.put(new Pair(i, i), arr[i]);
            int maxVal = arr[i];

            for (int j = i + 1; j < arr.length; j++) {
                maxVal = Math.max(arr[j], maxVal);
                rangeMaxValues.put(new Pair(i, j), maxVal);
            }
        }

        System.out.println(rangeMaxValues.get(new Pair(0, 2)));
    }
}
