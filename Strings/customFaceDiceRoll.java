/*
 * Same as DiceRoll Question
 *
 * - but the difference is in this we will have a custom face dice
 * - so we will run the loop till the face and add an arg in the function
 */

package Strings;

import java.util.ArrayList;

public class customFaceDiceRoll {
    public static void main(String[] args){
        System.out.println(diceRollList("", 4, 8));
    }

    static ArrayList<String> diceRollList(String p, int target, int face){
        // base condition
        if(target == 0){
            ArrayList<String> ans = new ArrayList<>();
            ans.add(p);
            return ans;
        }

        // function body
        ArrayList<String> list = new ArrayList<>();
        
        for(int i=1; i<=face && i<=target; i++){
            // recrusive call
            list.addAll(diceRollList(p+i, target-i, face));
        }
        return list;
    }

}
