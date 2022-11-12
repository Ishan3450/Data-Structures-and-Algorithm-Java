package RecursionQuestions.Strings;

import java.util.ArrayList;

public class PhonePad{
    public static void main(String[] args){
        phonePad("", "12");

        System.out.println(phonePadList("", "12"));

        System.out.println(phonePadCount("", "12"));
    }

    static void phonePad(String p, String up){
        // base condition
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }

        // function body
        int digit = up.charAt(0) - '0'; // this will convert character '2' to integer 2

        /*
         * Range will be like:
         * range((digit - 1) * 3, digit * 3)
         * 
         * Example: for 2 -> (2-1)*3 till 2*3 -> from 3 till 6 (6 is exclusive)
         * for 4 -> (4-1)*3 till 4*3 -> 9 till 12 (12 is exclusive)
         */

        for(int i=(digit-1)*3; i < digit*3; i++){
            char ch = (char) ('a' + i);
            
            // recursive call
            phonePad(p + ch, up.substring(1));
        }
    }

    static ArrayList<String> phonePadList(String p, String up){
        // base condition
        if(up.isEmpty()){
            ArrayList<String> ans = new ArrayList<>();
            ans.add(p);
            return ans;
        }

        // function body
        int digit = up.charAt(0) - '0';
        ArrayList<String> ans = new ArrayList<>();

        for(int i=(digit-1)*3; i< digit*3; i++){
            char ch = (char)('a' + i);
            // using addAll method of ArrayList as we will be getting multiple possible strings from the recrusive calls
            ans.addAll(phonePadList(p+ch, up.substring(1)));
        }

        return ans;
    }

    static int phonePadCount(String p, String up){
        // base condition
        if(up.isEmpty()){
            return 1;
        }

        // function body
        int count = 0;
        int digit = up.charAt(0) - '0';

        for(int i=(digit-1)*3; i< digit*3; i++){
            char ch = (char)('a' + i);
            // using addAll method of ArrayList as we will be getting multiple possible strings from the recrusive calls
            count += phonePadCount(p+ch, up.substring(1));
        }

        return count;        
    }

}