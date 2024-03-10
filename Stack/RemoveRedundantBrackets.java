package Stack;

import java.util.Stack;

public class RemoveRedundantBrackets {
    public static int checkRedundancy(String s) {
        Stack<Character> st = new Stack<>();
        
        for(int i = 0 ; i < s.length(); i++){
            char curr = s.charAt(i);
            
            if(Character.isAlphabetic(curr)){
                continue;
            }
            
            if( curr == '(' || isOperator(curr)){
                st.push(curr);
            } else {
                boolean isOperatorFound = false;
                
                while(!st.isEmpty() && st.peek() != '('){
                    if(isOperator(st.peek())){
                        isOperatorFound = true;
                    }
                    st.pop();
                }
                st.pop();
                
                if(!isOperatorFound){
                    return 1;
                }
            }
        }
        return 0;
    }
    
    public static boolean isOperator(char curr){
        if(curr == '+' || curr == '-' || curr == '*' || curr == '/'){
            return true;
        }
        return false;
    }
}
