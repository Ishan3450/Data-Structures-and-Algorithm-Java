package Strings;

import java.util.ArrayList;
public class DiceRoll {
    public static void main(String[] args){
        diceRoll("", 4);

        System.out.println(diceRollList("", 4));
    }

    static void diceRoll(String p, int target){ // no String up required as range of dice is 1 to 6 (will take that)
        // base condition
        if(target == 0){
            System.out.println(p);
            return;
        }

        // function body
        
        /*
         * Things to be in mind:
         * - we will have to run the loop till the target
         * - at every iteration we will have to add the current char to the processed string 
         *   and do a recrusion call having p+i and target is target - i
         * - for 4:
         *      1. loop will run till 4
         *      2. and the very next recursion call will be p+i -> 1, target will be target-i -> 4-1 -> 3 -> Summary: (1/3) 1+3 is 4
         *      3. after the previous recursion call value will be p+i -> 2, target will be target-i -> 4-2 -> 2 -> Summary: (2/2) 2+2 is 4
         * - at last whenever target is 0 we got a possible single answer
         *      
         */

        for(int i=1; i<=6 && i<=target; i++){
            // recursive call
            diceRoll(p+i, target-i);
        }
    }

    static ArrayList<String> diceRollList(String p, int target){
        // base condition
        if(target == 0){
            ArrayList<String> ans = new ArrayList<>();
            ans.add(p);
            return ans;
        }

        // function body
        ArrayList<String> list = new ArrayList<>();
        
        for(int i=1; i<=6 && i<=target; i++){
            // recrusive call
            list.addAll(diceRollList(p+i, target-i));
        }
        return list;
    }
}
