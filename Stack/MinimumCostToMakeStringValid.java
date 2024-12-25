/*
 * Question 8 in the video: https://www.youtube.com/watch?v=BmZnJehDzyU&list=PLDzeHZWIZsTryvtXdMr6rPh4IDexB5NIA&index=64
 * 
 */

package Stack;

import java.util.Stack;

public class MinimumCostToMakeStringValid {
    public static int findMinimumCost(String str) {
		// edge case
        if(str.length()%2 != 0){ // odd length
            return -1;
        }
        // for length: {{{{{ : it is not possible to make the expr valid, so returning -1

        Stack<Character> st = new Stack<>();

        // for : {{{}
        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);

            if(ch == '{'){
                st.push(ch);
            } else{ // we found a '}' bracket
                if(!st.isEmpty() && st.peek() == '{'){ // found the corresponding bracket, so removing it
                    st.pop();
                } else{
                    st.push(ch);
                }
            }
        }
        // after this loop the expr will be: {{

        // to make the expr valid

        /*
         * 3 case can be there for the invalid expressions:
         * 
         * NOTE: length will be even only as if length is odd then we have edge case up there
         * 
         * 1. {{{{ - all are opening braces
         * 2. }}}}}} - all are closing braces
         * 3. }}}{{{ - combination of both
         * 
         * - to make valid from invalid:
         * - for {{{{ : {}{} - index 1 and 3 are replaced
         * - }}}} - {}{} - index 0 and 2 are replaced
         * - }}}{{{ - {}{}{} - index 0, 2, 3, 4 are replaced
         * 
         * - above valid making thing will be done using count logic and will derive a general expression
         * - general expression: ( (openCount+1) / 2 ) + ( (closeCount+1) / 2);
         */
        int openCount = 0, closeCount = 0;

        while(!st.empty()){
            if(st.pop() == '{'){
                openCount ++;
            } else{
                closeCount ++;
            }
        }

        // below formula is to obtain the answer, to know how the answer is coming from the formula do watch the video, link at the top of this file.
        // this general expression came from the above 3 types of invalid expressions
        int ans = ( (openCount+1) / 2 ) + ( (closeCount+1) / 2);

        return ans;
    }

    public static void main(String[] args){
        String str = "{{{}";

        System.out.println(findMinimumCost(str));
    }
}
