package Strings;

public class SkipTheString {
    public static void main(String[] args){
        String str = "twentythousandsonly";
        String toSkip = "only";

        System.out.println(skipString(str, toSkip));
    }

    static String skipString(String str, String toSkip){
        // base condition
        if(str.isEmpty()){
            return "";
        }

        // function body + recursive call
        if(str.startsWith(toSkip)){
            return skipString(str.substring(toSkip.length()), toSkip);
        } else{
            char ch = str.charAt(0);
            return ch + skipString(str.substring(1), toSkip);
        }
    }
}
