package Strings;

public class SkipNotRequiredString {
    public static void main(String[] args){
        String str = "I will use app to order apple.";
        String toSkip = "app";
        String toNotSkip = "apple";

        System.out.println(skipNotRequired(str, toSkip, toNotSkip));

    }

    static String skipNotRequired(String str, String toSkip, String toNotSkip){
        // base condition
        if(str.isEmpty()){
            return "";
        }

        // function body + recursive call
        if(str.startsWith(toSkip) && !str.startsWith(toNotSkip)){
            return skipNotRequired(str.substring(toSkip.length()), toSkip, toNotSkip);
        } else{
            char ch = str.charAt(0);
            return ch + skipNotRequired(str.substring(1), toSkip, toNotSkip);
        }

    }
}
