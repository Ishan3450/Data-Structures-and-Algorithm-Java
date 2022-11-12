package StackQuestions;

import java.util.Stack;

public class ValidParenthesis {
    static boolean matches(char curr, char topOfStack){

        if(topOfStack == '(' && curr == ')'){
            return true;
        } else if(topOfStack == '[' && curr == ']'){
            return true;
        } else if(topOfStack == '{' && curr == '}'){
            return true;
        }

        return false;
    }
    static boolean isValid(String s) {
        Stack<Character> p = new Stack<>();

        for(int i=0; i<s.length(); i++){
            char curr = s.charAt(i);

            /*
             * 2 cases:
             * 
             * if curr is opening bracket, then push in stack
             * if not then check the topmost of the stack
             */
            if(curr == '(' || curr == '[' || curr == '{'){ // opening bracket
                p.push(curr);
            } else{ // closing bracket
                if(p.empty()){
                    return false;
                }
                char topOfStack = p.peek();

                if(matches(curr, topOfStack)){
                    p.pop();
                } else{
                    return false;
                }
            }
        }

        // at last check that after all the processing checking if the stack is empty or not
        if(p.empty()){
            return true;
        } 
        return false;
    }
    public static void main(String[] args){
        String str = "()";

        System.out.println(isValid(str));
    }
}
