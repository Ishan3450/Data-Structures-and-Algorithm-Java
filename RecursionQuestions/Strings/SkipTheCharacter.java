package RecursionQuestions.Strings;

public class SkipTheCharacter {
    public static void main(String[] args){
        String str = "abccbah";
        System.out.print("Without return function: ");
        skip("", str);
        System.out.println("With Return Function: " + skip_2(str));
    }

    static String skip_2(String str){
        // base condition
        if(str.isEmpty()){
            return "";
        }

        // function body + recursive condition
        char ch = str.charAt(0);

        if(ch == 'a'){
            // skip adding the char
            return skip_2(str.substring(1));
        } else{
            // add the current character
            return ch + skip_2(str.substring(1));
        }
    }

    static void skip(String processedString, String unprocessedString){
        // base condition
        if(unprocessedString.isEmpty()){
            // when original string is empty just print the processedString and exit the function
            System.out.println(processedString);
            return;
        }

        // function body + recursive condition
        char ch = unprocessedString.charAt(0);
        if(ch == 'a'){
            // skip the a i.e present at the first index so we are getting substring from 1
            skip(processedString, unprocessedString.substring(1));
        } else{
            // add the character
            skip(processedString + ch, unprocessedString.substring(1));
        }
    }
}
