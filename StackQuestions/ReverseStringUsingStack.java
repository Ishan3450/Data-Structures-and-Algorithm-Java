package StackQuestions;

import java.util.Stack;

public class ReverseStringUsingStack {
    static String rev(String str){
        Stack<Character> st = new Stack<>();

        for(int i=0; i<str.length(); i++){
            st.push(str.charAt(i));
        }

        String ans = "";

        for(int i=0; i<str.length(); i++){
            ans += st.pop();
        }
        return ans;
    }

    public static void main(String[] args){
        String str = "Ishan";

        System.out.println(rev(str));
    }
}
