package Recursion.Easy;

public class Palindrom {
    public static void main(String[] args){
        int n = 111;

        System.out.println(isPalindrom(n, 0, (int)Math.log10(n)));

    }

    static boolean isPalindrom(int n, int start, int end){
        String str = Integer.toString(n);

        if(start == end){
            return true;
        }
        
        // function call and base condition and recursive condition
        if(str.charAt(start) == str.charAt(end)){
            return isPalindrom(n, ++start, --end);
        } else{
            return false;
        }
    }
}
