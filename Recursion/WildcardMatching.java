// LC Hard: 44

package Recursion;

import java.util.Arrays;

public class WildcardMatching {
    public static boolean isMatch(String s, String p) {
        return isMatchHelper(s.toCharArray(), p.toCharArray(), 0, 0);
    }

    public static boolean isMatchHelper(char[] s, char[] p, int si, int pi){
        // base condition
        // case 1: both pointers are out of bound it means that both strings matches the pattern
        if(si == s.length && pi == p.length){
            return true;
        }

        // case 2:
        if(si == s.length && pi < p.length){
            // if pi is somewhere in the middle of the string then there are more 2 cases:
            /*
                Case 2.1:
                abc
                abc***

                in this case after comparing there are only the * remaining so this case is true.
            */

            /* 
                Case 2.2:
                abcdefg
                ab*fg

                in this case after comparing there are still fg remaining in the patterns string so for this case we have to return false
            */

            while(pi < p.length){
                // case 2.2
                if(p[pi] != '*'){
                    return false;
                }
                pi++;
            }

            // case 2.1
            return true;
        }

        /* 
            Case 3:
            aa
            a
            
            in this case p is a and s is aa, after first comparision the p pointer goes out of bound and s in within the range, so for this case when s pointer < s.length && p pointer == p.length then we have to return false
         */
        if(si < s.length && pi == p.length){
            return false;
        }
        // function body + recursive calls

        // case 1: both characters are same or question mark is there 
        if(s[si] == p[pi] || p[pi] == '?'){
            return isMatchHelper(s, p, si+1, pi+1);
        }

        // case 2: * comes in the patterns string
        if(p[pi] == '*'){
            // if * comes in the pattern string then we have more 2 cases:

            // case 2.1: in this case we have to ignore the * and move forward
            boolean case1 = isMatchHelper(s, p, si, pi+1);

            // case 2.2: in this case we have to consider * as 1 character and move the si forward
            boolean case2 = isMatchHelper(s, p, si+1, pi);

            return case1 || case2;
        }

        // if both characters are neither equal or ?(1st condition of the func body) nor *(2nd condition in the func body) it means both the characters are different
        return false; // as not matching patterns
    }

    
    public static void main(String[] args){
        System.out.println(isMatch("aa", "a"));
    }
}
