package RecursionQuestions.Strings;

import java.util.ArrayList;

public class Permutations {
    public static void main(String[] args){
        String str = "abc";

        permutations("", str);

        System.out.println(permutationsList("", str));
        System.out.println(permutationsCount("", str));
    }

    static int permutationsCount(String p, String up){
        // base condition
        if(up.isEmpty()){
            return 1;
        }

        // function body
        char ch = up.charAt(0);
        int count = 0;

        for(int i=0; i<=p.length(); i++){
            String first = p.substring(0, i);
            String second = p.substring(i, p.length());
            count += permutationsCount(first + ch + second, up.substring(1));
        }

        return count;
    }

    static ArrayList<String> permutationsList(String p, String up){
        // base condition
        if(up.isEmpty()){
            ArrayList<String> ans = new ArrayList<>();
            ans.add(p);
            return ans;
        }

        // function body + recursive condition
        char ch = up.charAt(0);
        ArrayList<String> list = new ArrayList<>();

        for(int i=0; i<=p.length(); i++){
            String firstPart = p.substring(0, i);
            String secondPart = p.substring(i, p.length());

            list.addAll(permutationsList(firstPart + ch + secondPart, up.substring(1)));
        }

        return list;
    }

    static void permutations(String p, String up){
        // base condition
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }

        // function body + recrusive call
        char ch = up.charAt(0);

        for(int i=0; i<=p.length(); i++){
            String firstPart = p.substring(0, i);
            String secondPart = p.substring(i, p.length());

            // recrusive call
            permutations(firstPart + ch + secondPart, up.substring(1));
        }
    }
}
