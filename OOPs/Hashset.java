package OOPs;

import java.util.HashSet;
import java.util.Iterator;

public class Hashset {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();

        // adding in a set
        set.add(1);
        set.add(2);
        set.add(2);
        set.add(3);
        set.add(3);
        set.add(4);

        System.out.println(set);

        // set will only contain unque element value, no duplicates are allowed in set
        if(set.contains(1)){
            System.out.println("1 is present");
        }

        set.remove(1);

        if(!set.contains(1)){
            System.out.println("1 is not present in the set");
        }
        
        System.out.println(set);

        // Iterator
        Iterator it = set.iterator();

        /*
         * Iterator has main 2 methods:
         * 
         * hasNext() - tells weather there is more element to the right size of the iterator
         * next() - updates the iterator and return the value with of its next
         */
        while(it.hasNext()){
            System.out.print(it.next() + " - ");
        }
        System.out.print("Iterator End");
        System.out.println();

    }
}