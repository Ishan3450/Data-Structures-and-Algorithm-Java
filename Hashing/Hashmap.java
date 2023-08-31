package Hashing;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Hashmap {
    public static void main(String[] args){
        HashMap<String, Integer> map = new HashMap<>();

        // insertion
        /* Country is Key and Population is its value */
        map.put("India", 130);
        map.put("USA", 80);
        map.put("Russia", 100);

        /*
         * In map.put() method there are 2 case exists:
         * 1. If Key already exists : in that case the corresponding value of the key will be updated to the new value
         * 2. If Key doesn't exists: in that case new key and value pair will be added
         */
        System.out.println(map);

        map.put("India", 150); // key already exists
        map.put("UK", 150); // new pair will be created
        System.out.println(map);

        // search for a key in map
        if(map.containsKey("India")){
            System.out.println("Found : India");
        }

        if(map.containsKey("Canada")){
            System.out.println("Found");
        } else{
            System.out.println("Not Found: Canada");
        }

        // to get particular key's value
        System.out.println(map.get("India")); // present in map
        System.out.println(map.get("Canada")); // not present in map

        // * Iteration in HashMap
        System.out.println("Iteration in HashMap");

        /*
         * Entry Set will return the set of key, value pair
         * Key Set will return the set of all the keys present in the map
         */
        System.out.println("Iteration using entry set ");
        for(Map.Entry<String, Integer> pair: map.entrySet()){
            /*
             * getKey() - to get the key
             * getValue() - get the value corresponding to that key
             */
            System.out.print(pair.getKey() + " -> ");
            System.out.println(pair.getValue());
        }

        System.out.println("Iteration using key set ");
        Set<String> keys = map.keySet();

        for(String key: keys){
            System.out.println(key + " -> " + map.get(key));
        }


        // to remove any pair from map
        map.remove("UK");
        System.out.println(map);
    }
}
