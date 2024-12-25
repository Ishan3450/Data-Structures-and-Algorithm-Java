public class AsciiValue {
    public static void main(String[] args){
        char ch = 'a';
        char ch2 = 'z';
        char chNum = '9';
        char chToNum = (char) (9 + '0');

        System.out.println(ch - 0);
        System.out.println(ch2 - 0);
        System.out.println(chNum - '0');
        System.out.println(chToNum);
    }
}
