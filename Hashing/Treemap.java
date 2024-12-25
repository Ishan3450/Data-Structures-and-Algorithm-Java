/*
 * TreeMap is used to maintain the order of keys in map in sorted manner
 */
package Hashing;

import java.util.TreeMap;

public class Treemap {
    public static void main(String[] args) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(9, 10);
        map.put(4, 10);
        map.put(7, 10);
        map.put(1, 10);
        System.out.println(map);

        // ! Rest all the methods are same as the hashmap
    }
}
