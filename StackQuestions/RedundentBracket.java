/*
 * https://www.codingninjas.com/codestudio/problems/redundant-brackets_975473?leftPanelTab=0
 * 
 * Redundent Bracket means useless brackets or brackets which do not impacts the whole expression
 * 
 * Approach:
 * - we will start with the first character and check wheter the char is opening bracket or operator
 *      : if it is then we will push the char into the stack
 * - if not it means we have found either closing bracket or lowercase alphabet
 *      : in that case we will ignore lowercase alphabet and check fro the closing bracket
 * - for closing bracket will check that is any operator present in the stack
 *      : if operator is present then we will pop the closing bracket
 *      : else redundent bracket is present so will return true
 * - example: (a+b+(c)) -> stack: (++())
 *            (a+b*(a/c)) -> stack: (+*(/))
 */

package StackQuestions;

import java.util.Stack;

public class RedundentBracket {
    public static boolean findRedundantBrackets(String s){
        // Write your code here.
        Stack<Character> stack = new Stack<>();

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);

            if(ch == '(' || ch == '+' || ch == '*' || ch == '-' || ch == '/' ){
                stack.push(ch);
            } else{ // we found: either ')' or alphabet
                // we will proceed further for only closing bracket
                if(ch == ')'){
                    boolean isRedundent = true;

                    while(stack.peek() != '('){
                        char top = stack.pop();;
    
                        if(top == '+' || top == '*' || top == '-' || top == '/' ){
                            isRedundent = false;
                        }
                        
                    }

                    if(isRedundent){
                        return true;
                    }
                    stack.pop(); // removing the extra ( bracket
                }
            }
        }

        return false;
    }

    public static void main(String[] args){
        String str = "((a/b))";

        System.out.println(findRedundantBrackets(str));
    }
}
