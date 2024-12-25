package LeetCodeContests;

import java.util.*;

public class Q387 {
    public static int firstUniqChar(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(int i=0; i<s.length(); i++){
            char curr = s.charAt(i);
            
            if(map.containsKey(curr)){
                map.put(curr, map.get(curr) + 1);
            } else{
                map.put(curr, 1);
            }
        }

        for(int i=0; i<s.length(); i++){
            char curr = s.charAt(i);
            
            if(map.get(curr) == 1){
                return i;
            }
        }
        
        return -1;
    }

    public static void main(String[] args){
        System.out.println(firstUniqChar("loveleetcode"));
    }
}
