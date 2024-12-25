public class ReverseTheStringUsingRecursion {
    public static String rev(String str){
        // base condition
        if(str.equals(null) || str.length() == 1){
            return str;
        }
        
        // function body
        char ch = str.charAt(str.length()-1);
        return ch + rev(str.substring(0, str.length()-1));
    }
    public static void main(String[] args){
        System.out.println(rev("this"));
    }
}
