package Hashing;

import java.util.HashSet;
import java.util.Iterator;

public class IteratorInfo {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(5);
        set.add(7);

        Iterator<Integer> it = set.iterator(); // return iterator which can iterate on set

        while (it.hasNext()) { // .hasNext() checkes whether iterator is on the end or not
            /*
             * prints the value (first time it .next() will print the very first value from
             * set means the initial state of iterator is just info not the actual values)
             */
            System.out.println(it.next());
        }

    }
}
